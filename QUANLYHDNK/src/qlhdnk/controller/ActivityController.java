package qlhdnk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
	@RequestMapping("activities")
	public String getActivity(ModelMap model) {
		return "activity/activities";
	}
	@RequestMapping("dangky")
	public String getDaDangKy(ModelMap model) {
		return "activity/dangky";
	}
	@RequestMapping("thamgia")
	public String getDaThamGia(ModelMap model) {
		return "activity/thamgia";
	}
}
