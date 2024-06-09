package qlhdnk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.entity.AccountsEntity;
import qlhdnk.util.Image;
@Controller
@ComponentScan(basePackages ="qlhdnk.DAO")
@RequestMapping("/manage/")
public class ManageController {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping("account-manage")
	public String getAccountManage(ModelMap model) {
		List<AccountsEntity> accounts = accountDAO.getListAccount();
		for(AccountsEntity acc: accounts) {
			if(acc.getAvatar()!=null)
			acc.setAvatarBase64(Image.encodeToBase64(acc.getAvatar()));
		}
		model.addAttribute("accounts",accounts);
		return "manage/account-manage";
	}
	@RequestMapping("activity-manage")
	public String getActivityManage(ModelMap model) {
		
		return "manage/activity-manage";
	}
}
