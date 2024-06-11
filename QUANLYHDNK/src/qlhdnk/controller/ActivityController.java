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
	@Autowired NotificationsDAO notificationsDAO;
	@RequestMapping("activities")
	public String getActivity(ModelMap model) {
		List<ActivitiesEntity> list = activitiesDAO.getListActivities();
		for(ActivitiesEntity acti: list) { 
			 if(acti.getAvatar()!=null) acti.setPictureBase64(Image.encodeToBase64(acti.getAvatar())); 
		 }
		List<TitlesEntity> listTitle = titlesDAO.getListTitle();
		AccountsEntity account = accountDAO.getAccount("N21DCCN000");
//		for(int i = 0; i < listTitle.size();i++) {
//			System.out.println(listTitle.get(i).getNameTitle());
//		}
		model.addAttribute("activities", list);
		model.addAttribute("titles", listTitle);
		model.addAttribute("account", account);
		if(list.isEmpty()) {
			model.addAttribute("message", "Hiện chưa có hoạt động nào!");
		}
		return "activity/activities";
	}
	@Autowired
	private RegistersDAO registersDAO;
	@RequestMapping("dangky")
	public String getDaDangKy(ModelMap model) {
		List<RegistersEntity> list = registersDAO.getListRegisters();		
		model.addAttribute("registers", list);
		if(list.isEmpty()) {
			model.addAttribute("message", "Bạn chưa đăng ký hoạt động nào!");
		}
		return "activity/dangky";
	}
	@RequestMapping("thamgia")
	public String getDaThamGia(ModelMap model) {
		List<RegistersEntity> list = registersDAO.getListDaTG();
//		for(int i = 0; i < list.size();i++) {
//			System.out.println(list.get(i).getRegistrant());
//		}
		model.addAttribute("datg",list);
		if(list.isEmpty()) {
			model.addAttribute("message", "Bạn chưa tham gia hoạt động nào!");
		}
		return "activity/thamgia";
	}
	
	@RequestMapping("account")
	public String getAccount(ModelMap model) {
		AccountsEntity account = accountDAO.getAccount("N21DCCN000");
//		for(int i = 0; i < list.size();i++) {
//			System.out.println(list.get(i).getUserName());
//		}
		model.addAttribute("account", account);
		return "activity/account";
	}
	@RequestMapping("thongbao")
	public String getThongBao(ModelMap model) {
		List<NotificationsEntity> list = notificationsDAO.getTB("N21DCCN000");
		if(list.isEmpty()) {
			model.addAttribute("message", "Bạn chưa có thông báo!");
		}
//		for(int i = 0; i < list.size();i++) {
//			System.out.println(list.get(i).getNameNotifi());
//		}
		model.addAttribute("notification", list);
		return "activity/thongbao";
	}
	@RequestMapping("login")
	public String getLogin() {
		return "login";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registersActivity(ModelMap model, @ModelAttribute("register") RegistersEntity register, 
									int idActivity, String idAccount) {
		
		
		ActivitiesEntity activity = new ActivitiesEntity();
		activity.setIdActivity(idActivity);
		AccountsEntity account = new AccountsEntity();
		account.setUserId(idAccount);
		
		try{
			if(registersDAO.checkRegister(activity, account)) {
				RegistersEntity existingRegister = registersDAO.getRegister(idActivity, idAccount);
				existingRegister.setFlagDK(false);
				existingRegister.setTimeRegister(new Date());
				registersDAO.updateRegister(existingRegister);
			}else {
				register.setActivityRegis(activity);
				register.setRegistrant(account);
				register.setTimeRegister(new Date());
				register.setFlagDK(false);
				registersDAO.insertRegister(register);
			}
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Không thể đăng ký!");
			// TODO: handle exception
		}
			
		return "redirect:/activity/activities.htm";
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
