package br.com.gsc.form;

import org.springframework.context.annotation.Bean;

public class CadastroUser {
	
    private String userName;

    private String password;
    
    private String email;
    
    private String auth = "ROLE_USER";

    public void setUserName(String userName) {
            this.userName = userName;
    }
    public String getUserName() {
            return userName;
    }
    public void setPassword(String password) {
            this.password = password;
    }
    public String getPassword() {
            return password;
    }
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
