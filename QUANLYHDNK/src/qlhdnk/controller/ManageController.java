package qlhdnk.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.DAO.ActivitiesDAO;
import qlhdnk.DAO.RoleDAO;
import qlhdnk.entity.AccountsEntity;
import qlhdnk.entity.ActivitiesEntity;
import qlhdnk.entity.RolesEntity;
import qlhdnk.util.Image;
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
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "account-manage", method = RequestMethod.GET, params = { "!sort", "!fill" })
	public String getAccountManage(ModelMap model,HttpSession session) {
		AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("QL")){

			List<AccountsEntity> accounts = accountDAO.getListAccount();
			
			/*
			 * for(AccountsEntity acc: accounts) { if(acc.getAvatar()!=null)
			 * System.out.println(acc.getUserName());
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
				 return "redirect:/nguoidang/dangdienra.htm";
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
				 return "redirect:/nguoidang/dangdienra.htm";
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
	                         @RequestParam("birthday") String birthday,
	                         @RequestParam("avatar") MultipartFile avatar) {

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
	        
	        if (!avatar.isEmpty()) {
	            byte[] avatarBytes = avatar.getBytes();
	            account.setAvatar(avatarBytes);
	        }
	        
	        account.setBirthday(parsedDate);
	        model.addAttribute("message", "Thêm thành công!.");
	        accountDAO.insertAccount(account);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        model.addAttribute("message", "Định dạng ngày tháng không hợp lệ.");
	    } catch (IOException e) {
	        e.printStackTrace();
	        model.addAttribute("message", "Không thể lưu ảnh.");
		}

	    return "manage/add-account";
	}
	
	
	@RequestMapping(value= "activity-manage",method = RequestMethod.GET )
	public String getActivityManage(ModelMap model,HttpSession session) {
    	AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("QL")){
		List<ActivitiesEntity> activitiesEntities = activitiesDAO.getActivitiesManage();
		model.addAttribute("activities",activitiesEntities);
		return "manage/activity-manage";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			}else {
				 return "redirect:/activity/activities.htm"; 
			} 
		}
	}
	
	@RequestMapping(value = "activity-manage", method = RequestMethod.POST, params = "sort-activities")
	public String fillActivityManage(@RequestParam(value = "sort-activities", required = false) String sortBy, ModelMap model) {
		/*
		 * List<AccountsEntity> accounts = accountDAO.fillListAccount(sortBy, fillBy);
		 */
		List<ActivitiesEntity> activities = activitiesDAO.sortListActivity(sortBy);
		model.addAttribute("activities", activities);
		return "manage/activity-manage";
	}
	
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.htm";
    }
    
    @RequestMapping(value = "account-detail", method = RequestMethod.GET)
    public String accountDetail(@RequestParam("id") String accountId, ModelMap model, HttpSession session) {
    	AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("QL")){
	        AccountsEntity accountDetail = accountDAO.getAccount(accountId);
	        if(accountDetail.getAvatar()!=null) {
				/* System.out.println(accountDetail.getUserName()); */
				 accountDetail.setAvatarBase64(Image.encodeToBase64(accountDetail.getAvatar())); 
			}
			/* System.out.println(account.getUserName()); */
	        model.addAttribute("acc", accountDetail);
	        return "manage/account-detail";
		}else {
			if(account.getRole().getId().equals("ND")) {
				 return "redirect:/nguoidang/dangdienra.htm";
			}else {
				 return "redirect:/activity/activities.htm"; 
			} 
		}
    }
    
    @RequestMapping(value = "account-detail",method = RequestMethod.POST)
    public String updateAccountDetail(ModelMap model,
		            @RequestParam("userId") String userId,
		            @RequestParam("userName") String userName,
		            @RequestParam("password") String password,
		            @RequestParam("gender") Boolean gender,
		            @RequestParam("email") String email,
		            @RequestParam("phoneNumber") String phoneNumber,
		            @RequestParam("address") String address,
		            @RequestParam("role") String roleId,
		            @RequestParam("birthday") String birthday) {
		/*
		 * System.out.println(userId); System.out.println(userName);
		 */
    	
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
 	        model.addAttribute("message", "Thêm thành công!.");
 	        accountDAO.updateAccount( account);
 	    } catch (ParseException e) {
 	        e.printStackTrace();
 	        model.addAttribute("message", "Định dạng ngày tháng không hợp lệ.");
 	    }

        return "redirect:/manage/account-manage.htm";
    }
    
	/*
	 * @RequestMapping("uploadfile") public String uploadfile(ModelMap
	 * model, @RequestParam("avatar") MultipartFile avartar) {
	 * if(!avartar.isEmpty()) { try { String photoPath =
	 * context.getRealPath("/resources/files/"+avartar.getOriginalFilename());
	 * avartar.transferTo(new File(photoPath));
	 * model.addAttribute("photo_name",avartar.getOriginalFilename());
	 * model.addAttribute("cv_type",avartar.getContentType()); return
	 * "manage/add-account"; }catch(Exception e) {
	 * model.addAttribute("message","Loi luu file!"); }
	 * 
	 * } return "manage/add-account";
	 * 
	 * }
	 */
}
