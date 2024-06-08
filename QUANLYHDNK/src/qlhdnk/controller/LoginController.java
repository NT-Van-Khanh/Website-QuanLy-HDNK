package qlhdnk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qlhdnk.entity.AccountsEntity;
import qlhdnk.DAO.AccountDAO;

@Controller
@ComponentScan(basePackages ="qlhdnk.DAO")
public class LoginController {
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping("login")
	public String getLogin() {
		AccountsEntity account = new AccountsEntity();
		account = accountDAO.getAccount("N21DCCN000");
		if(account==null) System.out.println("Lỗi ko tìm thấy");
		else System.out.println("Tìm thành công");
		return "login";
	}
	
	@RequestMapping(value="signin",method = RequestMethod.POST)
	public String signin(ModelMap model,  HttpSession session,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		/* AccountsEntity account = new AccountsEntity(); */
		
		return "";
	}
}
