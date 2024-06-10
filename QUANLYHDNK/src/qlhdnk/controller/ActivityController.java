package qlhdnk.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.DAO.ActivitiesDAO;
import qlhdnk.DAO.RegistersDAO;
import qlhdnk.DAO.TitlesDAO;
import qlhdnk.entity.AccountsEntity;
import qlhdnk.entity.ActivitiesEntity;
import qlhdnk.entity.RegistersEntity;
import qlhdnk.entity.TitlesEntity;

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
	@RequestMapping("activities")
	public String getActivity(ModelMap model) {
		List<ActivitiesEntity> list = activitiesDAO.getListActivities();
		List<TitlesEntity> listTitle = titlesDAO.getListTitle();
//		for(int i = 0; i < listTitle.size();i++) {
//			System.out.println(listTitle.get(i).getNameTitle());
//		}
		model.addAttribute("activities", list);
		model.addAttribute("titles", listTitle);
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
		List<AccountsEntity> list = accountDAO.getInfoAcount();
		model.addAttribute("info",list);
		return "activity/account";
	}
	@RequestMapping("login")
	public String getLogin() {
		return "login";
	}
}
