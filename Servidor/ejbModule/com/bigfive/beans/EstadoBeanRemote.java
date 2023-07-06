package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Estado;

@Remote
public interface EstadoBeanRemote extends ICrud<Estado>{
	public void actualizar();

	boolean estaUtilizado(Estado estado);
}
