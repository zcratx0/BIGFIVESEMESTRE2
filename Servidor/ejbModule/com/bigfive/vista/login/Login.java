package com.bigfive.vista.login;

import javax.ejb.Stateless;

@Stateless
public class Login implements LoginRemote {
    public Login() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean login(String nombre, String password) {
		
		return false;
	}
    

}
