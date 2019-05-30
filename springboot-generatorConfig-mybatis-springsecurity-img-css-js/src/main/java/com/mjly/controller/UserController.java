package com.mjly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjly.bean.TUser;
import com.mjly.dao.TUserMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private TUserMapper tUserMapper;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<TUser> users= tUserMapper.userList();
		model.addAttribute("users", users);
		return "user/list";
	}
	
	@GetMapping("/edit")
	public String edit(Model model) {
		model.addAttribute("tuser", new TUser());
		return "user/edit";
	}
	
	@PostMapping("/update")
	public String save(TUser user) {
		tUserMapper.insert(user);
		return "redirect:/user/list";
	}
}
