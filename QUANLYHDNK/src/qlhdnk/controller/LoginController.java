package qlhdnk.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qlhdnk.entity.AccountsEntity;
import qlhdnk.DAO.AccountDAO;

@Controller
@ComponentScan(basePackages ="qlhdnk.DAO")
@RequestMapping("login")
public class LoginController {
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	JavaMailSender mailer;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLogin() {
		return "login/login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String signin(ModelMap model,  HttpSession session,
		@RequestParam("username") String username, @RequestParam("password") String password) {
		 AccountsEntity account = accountDAO.login(username, password); 
		 if(account==null) {
			model.addAttribute("message","Sai tài khoản mật khẩu!");
		 	return "login/login";
		 } else{
			 model.addAttribute("message","Đăng nhập thành công!"); 
			 if(account.getRole().getId().equals("QL")){
				 System.out.println("ADMIN");
				 return "redirect:/manage/account-manage.htm";
			 }else if(account.getRole().getId().equals("ND")) {
				 System.out.println("ND");
				 return "redirect:activity/activities.htm";
			 }else {
				 System.out.println("sv");
				 return "redirect:activity/activities.htm";
			 } 
		 }
	}
	
	@RequestMapping(value = "forgot-password", method = RequestMethod.GET)
	public String getForgotPassword() {
		return "login/forgot-password";
	}
	@RequestMapping(value = "forgot-password", method = RequestMethod.POST)
	public String getForgotPassword(ModelMap model,  HttpSession session,
			@RequestParam("username") String username, @RequestParam("email") String email) {
		System.out.println(username);
		System.out.println(email);
		if(accountDAO.chekUserEmail(username, email)){
			model.addAttribute("message","Đúng tài khoản hoặc email!");
			try {
				MimeMessage mail= mailer.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(mail);

				helper.setTo(email);
				helper.setSubject("Code lấy lại mật khẩu");
				helper.setText("Test code",true);
				mailer.send(mail);
				model.addAttribute("message","Vui lòng kiểm tra email!");
			}catch(Exception e) {
				model.addAttribute("message","Lỗi gửi code qua email!");
			}
		}else {
			model.addAttribute("message","Sai tài khoản hoặc email!");
		}
		return "login/forgot-password";
	}
}
