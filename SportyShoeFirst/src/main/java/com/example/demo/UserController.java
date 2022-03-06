package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

	@Autowired
	UserRepositoryImpl userRepoImpl;

	
	@RequestMapping("/searchUser")
	public String searchUser(HttpServletRequest request, Model model) {

		String username = request.getParameter("username");
		List<UserLoginDetails> userList;
		if (username.isBlank()) {
			userList = userRepoImpl.getLoggedInUsers();
		} else {
			userList = userRepoImpl.searchUsersByName(username);
		}
		model.addAttribute("listUsers", userList);
		return "users.jsp";
	}

}
