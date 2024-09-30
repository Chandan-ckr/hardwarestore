package com.hardwarestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hardwarestore.dao.UserDao;
import com.hardwarestore.entity.User;

@CrossOrigin (origins="*",allowedHeaders="*")
@RestController
public class LoginController {

	
	@Autowired UserDao userdao;
	
	
	
	// Add User
	
	@PostMapping("/adduser")
	public String addUser(@RequestParam String uName,
							 @RequestParam String uPass) {
			User p = new User();
			p.setuName(uName);
			p.setuPassword(uPass);
			userdao.save(p);
		
		return "User added successfully";
	}
	
	
	// Get All User
	@GetMapping("/getalluser")
	public List<User> gedAll(){
		return userdao.getAll();
	}
	
	
	// Login
	
	@PostMapping("/login")
	public String login(@RequestParam String uname,
							@RequestParam String pass) {
		
		User u = userdao.findByuname(uname);
		
		if(u==null)
		{
			return "User is not registered";
		}else {
			
			if(uname.equals(u.getuName())&&pass.equals(u.getuPassword()))
			{
				return "Login Successfully";
			}else
			{
				return "Providing wrong password";
			}
		}
		
		
		
		
	}
	
}
