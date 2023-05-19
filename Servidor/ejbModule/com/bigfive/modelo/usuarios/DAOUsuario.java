package com.bigfive.modelo.usuarios;

import java.sql.ResultSet;
import java.util.LinkedList;

public class DAOUsuario {
	private static LinkedList<Usuario> listaDeUsuarios;	
	
	public static Usuario usuarioFromResultSet(ResultSet rs) {
		Usuario user = new Usuario();
		return user;
	}

	/**
	 * @return the listaDeUsuarios
	 */
	public static LinkedList<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}
	/**
	 * @param listaDeUsuarios Lista de usuarios para agregar
	 */
	public static void setListaDeUsuarios(LinkedList<Usuario> listaDeUsuarios) {
		listaDeUsuarios = listaDeUsuarios;
	}
}
