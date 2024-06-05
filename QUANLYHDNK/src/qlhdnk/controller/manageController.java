package qlhdnk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/manage/")
public class manageController {
	@RequestMapping("accountManage")
	public String getAccountManage(ModelMap model) {
		
		return "manage/accountManage";
	}
	@RequestMapping("activityManage")
	public String getActivityManage(ModelMap model) {
		
		return "manage/activityManage";
	}
}
