package com.mjly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjly.entity.User;
import com.mjly.entity.UserDao;
import com.mjly.security.UserInfo;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userDao.list());
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/loginIn")
	public String logincheck(UserInfo userInfo) {
		System.out.println(123);
		return "redirect:/user/index";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "add";
	}
	
	@PostMapping("/save")
	public String index(User user) {
		System.out.println(user);
		userDao.add(user);
		return "redirect:/user/index";
	}

}
