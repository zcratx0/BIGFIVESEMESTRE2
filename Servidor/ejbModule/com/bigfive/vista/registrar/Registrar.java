package com.bigfive.vista.registrar;

import javax.ejb.Stateless;

import com.bigfive.modelo.usuarios.Usuario;

@Stateless
public class Registrar implements RegistrarRemote {
    public Registrar() {}

	@Override
	public void registrar(Usuario usuario) {
		
	}

}
