package qlhdnk.controller;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import qlhdnk.DAO.AccountDAO;
import qlhdnk.DAO.ActivitiesDAO;
import qlhdnk.DAO.NguoiDangDAO;
import qlhdnk.DAO.TitlesDAO;
import qlhdnk.entity.AccountsEntity;
import qlhdnk.entity.ActivitiesEntity;
import qlhdnk.entity.RegistersEntity;
import qlhdnk.entity.RolesEntity;
import qlhdnk.entity.TitlesEntity;
import qlhdnk.util.Image;
import qlhdnk.util.SHA256Encryption;

@Controller
@RequestMapping("/nguoidang/")
@ComponentScan(basePackages = "qlhdnk.DAO")
public class PosterController {
    @Autowired
    private NguoiDangDAO nguoiDangDAO;
    @Autowired
    private TitlesDAO titlesDAO;
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private ActivitiesDAO activitiesDAO;

    @RequestMapping(value="dangdienra",method = RequestMethod.GET)
    public String getDangDienRa(ModelMap model,HttpSession session){
    	AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("ND")){
	        List<ActivitiesEntity> list = nguoiDangDAO.getActivitiesByPoster(account.getUserId());
	        List<TitlesEntity> listTitle = titlesDAO.getListTitle();
	        model.addAttribute("titles", listTitle);
	        if (list.isEmpty()) {
	            model.addAttribute("message", "Hiện chưa có hoạt động nào!");
	        }else {
	            model.addAttribute("activities", list);
	        }
	        return "nguoidang/dangdienra";
		}else {
			if(account.getRole().getId().equals("QL")) {
				 return "redirect:/manage/account-manage.htm";
			}else {
				 return "redirect:/activity/activities.htm"; 
			}			
		}
    }
    
    @RequestMapping(value="dadang",method = RequestMethod.GET)
    public String getDaDang(ModelMap model,HttpSession session){
    	AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("ND")){
	        List<ActivitiesEntity> list = nguoiDangDAO.getTakenActivitiesByPoster(account.getUserId());
	        List<TitlesEntity> listTitle = titlesDAO.getListTitle();
	        model.addAttribute("titles", listTitle);
	        if (list.isEmpty()) {
	            model.addAttribute("message", "Hiện chưa có hoạt động nào!");
	        }else {
	            model.addAttribute("activities", list);
	        }
	        return "nguoidang/dadang";
		}else {
			if(account.getRole().getId().equals("QL")) {
				 return "redirect:/manage/account-manage.htm";
			}else {
				 return "redirect:/activity/activities.htm"; 
			}			
		}
    }
    
    @RequestMapping(value="edit-activity",method = RequestMethod.GET)
    public String showActivityDetail(@RequestParam("id") int idActivity, ModelMap model, HttpSession session) {
    	AccountsEntity account = (AccountsEntity)session.getAttribute("account");
    	if(account==null) return "redirect:/login.htm";
    	if(account.getRole().getId().equals("ND")){
    		ActivitiesEntity activity = activitiesDAO.getActivitiesId(idActivity);
    		model.addAttribute("activity",activity);
			return "nguoidang/edit-activity";
		}else if(account.getRole().getId().equals("QL")) {
			return "redirect:/manage/account-manage.htm";
		}else {
			return "redirect:/activity/activities.htm";  
		}	
    }
    
    @RequestMapping(value="edit-activity",method = RequestMethod.POST)
    public String updateActivity(@RequestParam("id") int idActivity, ModelMap model, HttpSession session) {
    	AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("ND")){
			/* ActivitiesEntity activity = model.; */
			/* System.out.println(account.getUserName()); */
			/* model.addAttribute("activity", activity); */
	        return "nguoidang/edit-activity";
		}else {
			if(account.getRole().getId().equals("QL")) {
				 return "redirect:/manage/account-manage.htm";
			}else {
				 return "redirect:/activity/activities.htm"; 
			} 
		}
    }
    
    @RequestMapping(value="dangbai",method = RequestMethod.GET)
    public String createActivity(ModelMap model, HttpSession session) {
    	AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("ND")){
			return "nguoidang/dangbai";
		}else {
			if(account.getRole().getId().equals("QL")) {
				 return "redirect:/manage/account-manage.htm";
			}else {
				 return "redirect:/activity/activities.htm"; 
			} 
		}
    }
    @RequestMapping(value = "dangbai", method = RequestMethod.POST)
	public String addActivity(ModelMap model,
	                    	 @RequestParam("name-activity") String nameActivity,
	                         @RequestParam("title") String idTitle,
	                         @RequestParam("start-time") String startTime,
	                         @RequestParam("end-time") String endTime,
	                         @RequestParam("content-activity") String contentActivity,
	                         @RequestParam("quantity") Integer quantity,
	                         @RequestParam("address") String address,
	                         HttpSession session) {
    	AccountsEntity account = (AccountsEntity)session.getAttribute("account");
		if(account==null) {
			return "redirect:/login.htm";
		}else if(account.getRole().getId().equals("ND")){
	    	ActivitiesEntity activity= new ActivitiesEntity();
	    	activity.setNameActivity(nameActivity);
	    	TitlesEntity title =titlesDAO.getTitle(idTitle);
	    	activity.setPosterActi(accountDAO.getAccount(account.getUserId()));
	    	activity.setTitle(title);
	    	activity.setContentActivity(contentActivity);
	    	activity.setQuantity(quantity);
	    	activity.setAddress(address);
	    	 try {
	    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	 	        Date parsedDate1 = dateFormat.parse(startTime);
	 	        Date parsedDate2 = dateFormat.parse(endTime);
				/*
				 * if (!avatar.isEmpty()) { byte[] avatarBytes = avatar.getBytes();
				 * account.setAvatar(avatarBytes); }
				 */
	 	       activity.setStartTime(parsedDate1);
	 	       activity.setEndTime(parsedDate2);
	 	       activitiesDAO.insertActivity(activity);
	 	        model.addAttribute("message", "Thêm thành công!.");
				/* accountDAO.insertAccount(account); */
	 	    } catch (ParseException e) {
	 	        e.printStackTrace();
	 	        model.addAttribute("message", "Định dạng ngày tháng không hợp lệ.");
	 	    }
	
		    return "nguoidang/dangbai";
		}else {
			if(account.getRole().getId().equals("QL")) {
				 return "redirect:/manage/account-manage.htm";
			}else {
				 return "redirect:/activity/activities.htm"; 
			}
		}
	}
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.htm";
    }
}
