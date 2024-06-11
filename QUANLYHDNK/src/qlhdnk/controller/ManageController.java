package qlhdnk.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.DAO.ActivitiesDAO;
import qlhdnk.DAO.RoleDAO;
import qlhdnk.entity.AccountsEntity;
import qlhdnk.entity.ActivitiesEntity;
import qlhdnk.entity.RolesEntity;
import qlhdnk.util.SHA256Encryption;

@Controller
@ComponentScan(basePackages = "qlhdnk.DAO")
@RequestMapping("/manage/")
public class ManageController {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private ActivitiesDAO activitiesDAO;
	
	@RequestMapping(value = "account-manage", method = RequestMethod.GET, params = { "!sort", "!fill" })
	public String getAccountManage(ModelMap model,HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("QL")){

			List<AccountsEntity> accounts = accountDAO.getListAccount();
			/*
			 * for(AccountsEntity acc: accounts) { if(acc.getAvatar()!=null)
			 * acc.setAvatarBase64(Image.encodeToBase64(acc.getAvatar())); }
			 */
		 model.addAttribute("accounts",accounts); 
			/*
			 * List<RolesEntity> roles = roleDAO.getRoleList();
			 * model.addAttribute("roles",roles);
			 */
		return "manage/account-manage";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "login/login";
			}else {
				 return "redirect:/activity/activities.htm"; 
			} 
		}
	}

	@RequestMapping(value = "account-manage", method = RequestMethod.POST, params = { "sort", "fill" })
	public String fillAccountManage(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "fill", required = false) String fillBy, ModelMap model) {

		 List<AccountsEntity> accounts = accountDAO.fillListAccount(sortBy, fillBy);
		
		model.addAttribute("accounts", accounts);
		/*
		 * List<RolesEntity> roles = roleDAO.getRoleList(); model.addAttribute("roles",
		 * roles);
		 */
		/*
		 * System.out.println(sortBy); System.out.println(fillBy);
		 */
		return "manage/account-manage";
	}

	@RequestMapping(value = "add-account", method = RequestMethod.GET)
	public String addAccountManage(ModelMap model, HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("QL")){
			return "manage/add-account";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "login/login";
			}else {
				 return "redirect:/activity/activities.htm"; 
			} 
		}
	}

	@RequestMapping(value = "add-account", method = RequestMethod.POST)
	public String addAccount(ModelMap model,
	                         @RequestParam("userId") String userId,
	                         @RequestParam("userName") String userName,
	                         @RequestParam("password") String password,
	                         @RequestParam("gender") Boolean gender,
	                         @RequestParam("email") String email,
	                         @RequestParam("phoneNumber") String phoneNumber,
	                         @RequestParam("address") String address,
	                         @RequestParam("role") String roleId,
	                         @RequestParam("birthday") String birthday) {
	    System.out.println("Received request to add account");
	    System.out.println("UserId: " + userId);
	    System.out.println("UserName: " + userName);
	    System.out.println("Password: " + password);
	    System.out.println("Gender: " + gender);
	    System.out.println("Email: " + email);
	    System.out.println("PhoneNumber: " + phoneNumber);
	    System.out.println("Address: " + address);
	    System.out.println("RoleId: " + roleId);
	    System.out.println("Birthday: " + birthday);
	    AccountsEntity account = new AccountsEntity();
	    account.setUserId(userId);
	    account.setUserName(userName);
	    account.setPassword(SHA256Encryption.toSHA256(password));
	    account.setGender(gender);
	    account.setEmail(email);
	    account.setPhoneNumber(phoneNumber);
	    account.setAddress(address);
	    RolesEntity role = roleDAO.getRole(roleId);
	    account.setRole(role);
	    try {
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date parsedDate = dateFormat.parse(birthday);
	        account.setBirthday(parsedDate);
	        accountDAO.insertAccount(account);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        model.addAttribute("message", "Định dạng ngày tháng không hợp lệ.");
	    }

	    return "manage/add-account";
	}
	
	
	@RequestMapping("activity-manage")
	public String getActivityManage(ModelMap model,HttpSession session) {
		List<ActivitiesEntity> activitiesEntities = activitiesDAO.getActivitiesManage();
		model.addAttribute("activities",activitiesEntities);
		return "manage/activity-manage";
	}
	
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.htm";
    }
}
