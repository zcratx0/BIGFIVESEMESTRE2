package com.bigfive.vista.registrar;

import javax.ejb.Remote;

import com.bigfive.modelo.usuarios.Usuario;

@Remote
public interface RegistrarRemote {
	public void registrar(Usuario usuario);
}
