package com.spring.mvc.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.project.models.entity.User;
import com.spring.mvc.project.models.service.IUserService;

@Controller
@RequestMapping("views/users")
public class HomeController {

	@Autowired
	private IUserService userService;

//--------------------------Read user--------------------------	

	@GetMapping("/")
	public String homePage(Model model) {
		List<User> usuarios = userService.findAll();
		model.addAttribute("usuarios", usuarios);
		return "views/home";
	}

//--------------------------Create user--------------------------	
	@GetMapping("/preRegister")
	public String preRegister(Model model) {
		model.addAttribute("user", new User());
		return "/views/register";
	}

	@PostMapping("/postRegister")
	public String postRegister(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "/views/register";
		}
		userService.save(user);
		return "redirect:/views/users/";
	}

//--------------------------Update user--------------------------	
	@GetMapping("/update/{id}")
	public String preUpdate(@PathVariable("id") Long idUser, Model modelo) {
		User user = userService.findById(idUser);
		if (user == null) {
			return "redirect:/views/users/";
		}
		modelo.addAttribute("user", user);
		return "views/register";
	}

//--------------------------Delete user--------------------------	
	@GetMapping("/delete/{id}")
	public String preDelete(@PathVariable("id") Long idUser) {
		User user = userService.findById(idUser);
		if (user == null) {
			return "redirect:/views/users/";
		}
		userService.deleteById(idUser);
		return "redirect:/views/users/";
	}
}