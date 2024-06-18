package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/search")
	public String search() {

		return "SearchUser";
	}

	@PostMapping("/searchuser")
	public String searchUser(UserBean userBean,Model model) {

		// dao->db query
		List<UserBean> users = userDao.getUsersByName(userBean.getFirstName());
		// model->send to jsp
		model.addAttribute("users",users);
		return "SearchResult";
	}
}
