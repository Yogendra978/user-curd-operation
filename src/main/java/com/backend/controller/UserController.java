package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.backend.entity.User;
import com.backend.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	public String createUser() {
		return "index";
	}
	
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("User") User user,Model model) {
		User userSave = userService.UserSave(user);
		if(!(userSave==null)) {
			model.addAttribute("msg","New Save Record");
		}else {
			model.addAttribute("msg","Empty user");
		}
		return "redirect:/listAll";
	}
	
	@GetMapping("/listAll")
	public String listAllUser(Model model) {
		List<User> listAll = userService.listAll();
		
		model.addAttribute("list",listAll);
		return "list";
	}
	
	@GetMapping("/edit/{id}")
	public String updateUser(@PathVariable Long id,Model model) {
		User userById = userService.getUserById(id);
		
		model.addAttribute("user",userById);
		return "update";
	}
	
	@PostMapping("/edit/{id}")
	public String updatedUser(@PathVariable Long id,@ModelAttribute("user") User user) {
		
		// get user database
		User newUser = userService.getUserById(id);
		newUser.setId(id);
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		
		//uptated user
		User updateUser = userService.UpdateUser(newUser);
		return "redirect:/listAll";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/listAll";
	}
	
	
}
