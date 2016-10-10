package com.connection.document.restService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document(collection="Login")
public class Login {
    @Id
    String username;
    String password;
  
    public Login()
    {
    	
    }
    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }
  
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String toString() {
        return String.format("[username = %s, password = %s]", username, password);
    }
} 