package qlhdnk.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.DAO.ActivitiesDAO;
import qlhdnk.DAO.NotificationsDAO;
import qlhdnk.DAO.RegistersDAO;
import qlhdnk.DAO.TitlesDAO;
import qlhdnk.entity.AccountsEntity;
import qlhdnk.entity.ActivitiesEntity;
import qlhdnk.entity.NotificationsEntity;
import qlhdnk.entity.RegistersEntity;
import qlhdnk.entity.TitlesEntity;
import qlhdnk.util.Image;

@Controller
@RequestMapping("/activity/")
@ComponentScan(basePackages ="qlhdnk.DAO")
public class ActivityController {
	@Autowired
	private ActivitiesDAO activitiesDAO;
	@Autowired
	private TitlesDAO titlesDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired 
	private NotificationsDAO notificationsDAO;
	@Autowired
	private RegistersDAO registersDAO;
	
	@RequestMapping("activities")
	public String getActivity(ModelMap model, HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("SV")){
			List<ActivitiesEntity> list = activitiesDAO.getListActivities(account.getUserId());
			for(ActivitiesEntity acti: list) { 
				 if(acti.getAvatar()!=null) acti.setPictureBase64(Image.encodeToBase64(acti.getAvatar())); 
				 acti.setQuantityAvailable(registersDAO.getListByActivity(acti.getIdActivity()));
				 
			 }
			List<TitlesEntity> listTitle = titlesDAO.getListTitle();
			model.addAttribute("activities", list);
			model.addAttribute("titles", listTitle);
			model.addAttribute("account", account);
			if(list.isEmpty()) {
				model.addAttribute("message", "Hiện chưa có hoạt động nào!");
			}
			return "activity/activities";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			}else {
				 return "redirect:/manage/account-manage.htm"; 
			} 
		}

	}

	@RequestMapping("dangky")
	public String getDaDangKy(ModelMap model, HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("SV")){
			List<RegistersEntity> list = registersDAO.getListRegisters(account.getUserId());		
			model.addAttribute("registers", list);
			if(list.isEmpty()) {
				model.addAttribute("message", "Bạn chưa đăng ký hoạt động nào!");
			}
			return "activity/dangky";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			}else {
				 return "redirect:/manage/account-manage.htm"; 
			}
		}
	}
	
	@RequestMapping("thamgia")
	public String getDaThamGia(ModelMap model,HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("SV")){
		List<RegistersEntity> list = registersDAO.getListDaTG(account.getUserId());
//		for(int i = 0; i < list.size();i++) {
//			System.out.println(list.get(i).getRegistrant());
//		}
		model.addAttribute("datg",list);
		if(list.isEmpty()) {
			model.addAttribute("message", "Bạn chưa tham gia hoạt động nào!");
		}
		return "activity/thamgia";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			}else {
				 return "redirect:/manage/account-manage.htm"; 
			} 
		}
	}
	
	@RequestMapping("account")
	public String getAccount(ModelMap model,HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("SV")){
			/* AccountsEntity account = accountDAO.getAccount(account.getUserId()); */
//		for(int i = 0; i < list.size();i++) {
//			System.out.println(list.get(i).getUserName());
//		}
		model.addAttribute("account", account);
		return "activity/account";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			}else {
				 return "redirect:/manage/account-manage.htm"; 
			} 
		}
	}
	@RequestMapping("thongbao")
	public String getThongBao(ModelMap model,HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("SV")){
		List<NotificationsEntity> list = notificationsDAO.getTB(account.getUserId());
		if(list.isEmpty()) {
			model.addAttribute("message", "Bạn chưa có thông báo!");
		}
//		for(int i = 0; i < list.size();i++) {
//			System.out.println(list.get(i).getNameNotifi());
//		}
		model.addAttribute("notification", list);
		return "activity/thongbao";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			}else {
				 return "redirect:/manage/account-manage.htm"; 
			} 
		}
	}


	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registersActivity(ModelMap model,	@ModelAttribute("register") RegistersEntity register, int idActivity, 
		@RequestParam("idAccount") String idAccount, HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("SV")){
		ActivitiesEntity activity = new ActivitiesEntity();
		activity.setIdActivity(idActivity);
		try{
			if(registersDAO.checkRegister(activity, account)) {
				RegistersEntity existingRegister = registersDAO.getRegister(activity, account);
				if(existingRegister != null){
					existingRegister.setFlagDK(false);
	                existingRegister.setTimeRegister(new Date());
					registersDAO.updateRegister(existingRegister);
				}
				else {
					model.addAttribute("error", "Lỗi tìm hoạt động");
					return "redirect:/activity/activities.htm";
				}
			}else {
				registersDAO.insertRegister(activity, account);
			}
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Không thể đăng ký!");
			return "redirect:/activity/activities.htm";
			// TODO: handle exception
		}
			
		return "redirect:/activity/activities.htm";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			}else {
				 return "redirect:/manage/account-manage.htm"; 
			} 
		}
	}
	
	@RequestMapping(value = "cancel", method = RequestMethod.POST)
	public String cancelRegister(ModelMap model, @ModelAttribute("register") RegistersEntity register, 
			int idActivity, String idAccount) {
		ActivitiesEntity activity = new ActivitiesEntity();
		activity.setIdActivity(idActivity);
		AccountsEntity account = new AccountsEntity();
		account.setUserId(idAccount);
		registersDAO.cancelRegister(activity, account);;
		return "redirect:/activity/dangky.htm";
	}
	
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.htm";
    }
}
