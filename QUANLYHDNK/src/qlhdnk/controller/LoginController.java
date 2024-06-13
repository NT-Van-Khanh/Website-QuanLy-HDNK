package qlhdnk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import qlhdnk.entity.AccountsEntity;
import qlhdnk.entity.VerificationsEntity;
import qlhdnk.util.SHA256Encryption;
import qlhdnk.DAO.AccountDAO;
import qlhdnk.DAO.VerificationCodeDAO;
import qlhdnk.DAO.XMailler;

@Controller
@ComponentScan(basePackages ="qlhdnk.DAO")
@RequestMapping("login")
public class LoginController {
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private VerificationCodeDAO verificationCodeDAO;
	
	@Autowired
	XMailler mailer;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLogin(ModelMap model, HttpSession session) {
		AccountsEntity account =(AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "login/login";
		}else{
			 if(account.getRole().getId().equals("QL")){
				 return "redirect:/manage/account-manage.htm";
			 }else if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			 }else {
				 session.setAttribute("account", account);
				 return "redirect:/activity/activities.htm"; 
			 } 
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getLogin(ModelMap model,  HttpSession session,
		@RequestParam("username") String username, @RequestParam("password") String password) {
		 AccountsEntity account = accountDAO.login(username, password); 
		 if(account==null) {
			model.addAttribute("message","Sai tài khoản mật khẩu!");
		 	return "login/login";
		 } else{
			 session.setAttribute("account", account);
			 model.addAttribute("message","Đăng nhập thành công!"); 
			 if(account.getRole().getId().equals("QL")){
				 return "redirect:/manage/account-manage.htm";
			 }else if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			 }else {
				 session.setAttribute("account", account);
				 return "redirect:/activity/activities.htm";
				 
			 } 
		 }
	}
	
	@RequestMapping(value = "forgot-password", method = RequestMethod.GET)
	public String getForgotPassword(ModelMap model, HttpSession session) {
		AccountsEntity account =(AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "login/forgot-password";
		}else{
			 if(account.getRole().getId().equals("QL")){
				 return "redirect:/manage/account-manage.htm";
			 }else if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			 }else {
				 session.setAttribute("account", account);
				 return "redirect:/activity/activities.htm"; 
			 } 
		}
	}
	
	@RequestMapping(value = "forgot-password", method = RequestMethod.POST)
	public String getForgotPassword(ModelMap model,  HttpSession session,
			@RequestParam("username") String username, @RequestParam("email") String email) {
		System.out.println(username);
		System.out.println(email);
		
		if(accountDAO.chekUserEmail(username, email)){
			model.addAttribute("message","Đúng tài khoản hoặc email!");
			String verifyCode= XMailler.randomCode();
			try {
				mailer.send(email,"Code lấy lại mật khẩu" ,"Mã xác nhận của bạn là:"+verifyCode);
				VerificationsEntity verificationEntity= verificationCodeDAO.checkAvailableEmail(email);
				if(verificationEntity==null)	verificationCodeDAO.createVerifyCode(email,SHA256Encryption.toSHA256(verifyCode)); 
				else 	verificationCodeDAO.updateVerifyCode(verificationEntity, SHA256Encryption.toSHA256(verifyCode)); 
				session.setAttribute("email", email); 
				session.setAttribute("username", username); 
				model.addAttribute("message","Vui lòng kiểm tra email!");
				return "login/confirm-verification-code";
			}catch(Exception e) {
				model.addAttribute("message","Lỗi gửi code qua email!");
			}
		}else {
			model.addAttribute("message","Sai tài khoản hoặc email!");
		}
		return "login/forgot-password";
	}

	 @RequestMapping(value = "confirm-verification-code",method = RequestMethod.POST) 
	 public String verifyCode(ModelMap model, HttpSession session, @RequestParam("code") String code){
		 String email =(String)session.getAttribute("email");
		 if(email !=null) {
			 int tmp =verificationCodeDAO.confirmVerifyCode(email, SHA256Encryption.toSHA256(code));
			 switch(tmp) {
			 	case 0:
			 		model.addAttribute("message","Vui lòng nhập mật khẩu mới");
			 		return "login/reset-password";
			 	case 1:
			 		model.addAttribute("message","Mã code không đúng!");
			 		return "login/confirm-verification-code";	 
			 	default:
			 		 model.addAttribute("message","Mã code hết hạn");
				 	return "login/confirm-verification-code";	
		 	 } 	
		 }else {
			model.addAttribute("message","Email không tồn tại!");
		 	return "login/confirm-verification-code";
		 }
	 }
	 
	 @RequestMapping(value = "reset-password",method = RequestMethod.POST) 
	 public String resetPassword(ModelMap model, HttpSession session, 
			 @RequestParam("new-password") String newPassword, 
			 @RequestParam("confirm-password") String confirmPassword, 
			 RedirectAttributes redirectAttributes) {
		    String email = (String) session.getAttribute("email");
		    String username = (String) session.getAttribute("username");

		    if (email == null || username == null) {
		        model.addAttribute("message", "Email hoặc tài khoản không tồn tại.");
		        return "login/forgot-password";
		    }
		    if (!newPassword.equals(confirmPassword)) {
		        model.addAttribute("message", "Mật khẩu xác nhận không khớp!");
		        return "login/reset-password";
		    }
		    if (accountDAO.changePassword(username, newPassword)) {
		        redirectAttributes.addFlashAttribute("message", "Thành công. Vui lòng đăng nhập!");
		        session.removeAttribute("email");
		        session.removeAttribute("username");
		        return "redirect:/login.htm";
		    } else {
		        model.addAttribute("message", "Đổi mật khẩu thất bại. Vui lòng thử lại.");
		        return "login/reset-password";
		    }
	 }
}