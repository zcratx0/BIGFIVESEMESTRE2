package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Usuario;

@Remote
public interface UsuarioBeanRemote extends ICrud<Usuario> {
	public boolean loginUsuario(String name, String password);
}
