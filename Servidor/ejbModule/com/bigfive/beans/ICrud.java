package com.bigfive.beans;

import java.util.List;

import com.bigfive.entities.Usuario;

public interface ICrud<T> {
	public boolean crear(T value);
	public boolean borrar(T value);
	public boolean modificar(T value);
	public List<T> listarElementos();
}
