package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

//your controller's method will return jsp page 
	// open jsp

	@Autowired // spring container -> singleton
	UserDao userDao;// new UserDao();//allocate

	@GetMapping("/signup") // url pattern -> browser
	public String signup() { // method name
		// logic
		return "Signup"; // jsp name ->it will open in browser when you hit the url
	}

	@PostMapping("/saveuser")
	public String saveUser(UserBean userBean, Model model) {
		// read -> request.getParameter() ->
		System.out.println(userBean.getFirstName());
		// remove ->
		// class -> variable : form name

		// you want to send data from controller to jsp
		// model -> addAttribute
		model.addAttribute("user", userBean); // first argument -> data name ? jsp access
		// second argument data value
		// validate
		// db insert
		// dao -> insert query ->
		userDao.addUser(userBean);
		return "Home";// open Login.jsp
	}

	// login
	// authentication

	// jsp -> bean -> dao -> database
	// database -> dao -> bean -> jsp
	@GetMapping("/listusers")
	public String getAllUsers(Model model) {
		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users",users);
		return "ListUsers";
	}

	//dao -> deleteUser() -> call ? use ? 
	// ? => query string 
	@GetMapping("/deleteuser") //?userId=1 
	public String deleteUser(@RequestParam("userId") Integer userId) {
		userDao.deleteUser(userId);
		return "redirect:/listusers";//do not jump to jsp -> jump to another url{method} 
	}
	
	@GetMapping("/viewuser")
	public String viewUSer(@RequestParam("userId") Integer userId,Model model) {
		//dao 
	 UserBean userBean =	userDao.getUserByUserId(userId);
	 model.addAttribute("userBean",userBean);
	 return "ViewUser";
	}
	
	
	
	//user jsp -> input -> data -> 
		//form ->      method:post , action=>
				//controller -> read-> bean 
		//hyperlink->  question mark - query string 
				//controller -> @RequestParam
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
