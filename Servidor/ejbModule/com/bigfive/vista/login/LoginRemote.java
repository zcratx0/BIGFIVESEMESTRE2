package com.bigfive.vista.login;

import javax.ejb.Remote;

@Remote
public interface LoginRemote {
	public boolean login(String nombre, String password);
}
