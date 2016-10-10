package com.connection.MongoDB.restService.controller;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connection.MongoDB.restService.model.login;
import com.connection.MongoDB.restService.service.loginService;
import com.connection.document.restService.Login;

@RestController
@RequestMapping("/login")
public class loginController {
	@Autowired
	loginService ls;
	
	@Autowired
	MongoOperations mongoOperations;
	
	@RequestMapping("/all")
	public List<Login> getAll()
	{
		return ls.getAll();
	}
	@RequestMapping("{username}/{password}")
	public String getLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
		if(password.equals(""))
		{
			return ls.getLogin(username,"");
			
		}
		return ls.getLogin(username,password);
		
	}
}
