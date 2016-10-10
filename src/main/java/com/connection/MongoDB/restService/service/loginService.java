package com.connection.MongoDB.restService.service;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.connection.MongoDB.restService.model.login;
import com.connection.document.restService.Login;

@Service
public class loginService implements CommandLineRunner{
	@Autowired
	MongoOperations mongoOperations;
	
	Hashtable<String, Login> hs=new Hashtable<String, Login>();

	public String getLogin(String name,String ps)
	{
		String str="No record Found";
		try
		{
		Query query = new Query(Criteria.where("username").is(name));
		// search operation
		Login object = (Login) mongoOperations.findOne(query, Login.class);
		
		if(object!=null)
		{
			if(object.getUsername().equals(name))
			{
				if(object.getPassword().equals(ps))
				{
					str= "Sucessful login";
				}
				else if(ps.equals(""))
					str= "enter password !!";
				else
					str= "USerame or pasword id wrong please try again !!!";
			}				
		}
		}
		catch(Exception e)
		{
			str="Exception occours not a valid user !!! Please try again";
		}
		
		return str;			
	}
	
	public List<Login> getAll(){
		List<Login> objLst = mongoOperations.findAll(Login.class);
		System.out.println(objLst);
		
		return objLst;
	}
	
	public void run(String... arg0) throws Exception {

		Login l= new Login("a","a123");
		Login record = new Login(l.getUsername(), l.getPassword());
		// comment the save code if data already stored
		// save operation 
		mongoOperations.save(record);

		l= new Login("b","b123");
		record = new Login(l.getUsername(), l.getPassword());
		// save operation 
		mongoOperations.save(record);
		
		l= new Login("c","c123");
		record = new Login(l.getUsername(), l.getPassword());
		// save operation 
		mongoOperations.save(record);
		
	}

}
