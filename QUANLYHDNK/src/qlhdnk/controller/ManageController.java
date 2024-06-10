package qlhdnk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.DAO.RoleDAO;
import qlhdnk.entity.AccountsEntity;
import qlhdnk.entity.RolesEntity;
import qlhdnk.util.Image;
@Controller
@ComponentScan(basePackages ="qlhdnk.DAO")
@RequestMapping("/manage/")
public class ManageController {
	
	@Autowired
	private AccountDAO accountDAO;
	@Autowired 
	private RoleDAO roleDAO;
	
	@RequestMapping(value = "account-manage", method = RequestMethod.GET, params = {"!sort","!fill"})
	public String getAccountManage(ModelMap model) {
		List<AccountsEntity> accounts = accountDAO.getListAccount();
		//Chuyển byte[] thành ảnh
		/*
		 * for(AccountsEntity acc: accounts) { if(acc.getAvatar()!=null)
		 * acc.setAvatarBase64(Image.encodeToBase64(acc.getAvatar())); }
		 */
		model.addAttribute("accounts",accounts);
		
		List<RolesEntity> roles = roleDAO.getRoleList();
		model.addAttribute("roles",roles);
		
		return "manage/account-manage";
	}
	
	@RequestMapping(value = "account-manage", method = RequestMethod.POST, params = {"sort","fill"})
	public String fillAccountManage(@RequestParam(value="sort",required = false) String sortBy,
			@RequestParam(value="fill",required = false) String fillBy,ModelMap model) {
		List<AccountsEntity> accounts = accountDAO.fillListAccount(sortBy,fillBy);
		model.addAttribute("accounts",accounts);
		List<RolesEntity> roles = roleDAO.getRoleList();
		model.addAttribute("roles",roles);
		System.out.println(sortBy);
		System.out.println(fillBy);
		return "manage/account-manage";
	}
	@RequestMapping(value="add-account",method=RequestMethod.GET)
	public String addAccountManage(ModelMap model) {
		return "manage/add-account";
	}
	@RequestMapping("activity-manage")
	public String getActivityManage(ModelMap model) {
		
		return "manage/activity-manage";
	}
}
