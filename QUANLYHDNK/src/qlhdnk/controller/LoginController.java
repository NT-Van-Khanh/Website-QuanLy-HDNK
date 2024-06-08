package qlhdnk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping("login")
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value="signin",method = RequestMethod.POST)
	public String signin(ModelMap model,  HttpSession session,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		/* AccountsEntity account = new AccountsEntity(); */
		
		return "";
	}
}
