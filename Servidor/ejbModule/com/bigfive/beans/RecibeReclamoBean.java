package com.bigfive.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.bigfive.entities.Reclamo;

/**
 * Session Bean implementation class RecibeReclamoBean
 */
@Stateless
@LocalBean
public class RecibeReclamoBean implements RecibeReclamoBeanRemote {

    /**
     * Default constructor. 
     */
    public RecibeReclamoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(Reclamo value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(Reclamo value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Reclamo value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reclamo> listarElementos() {
		// TODO Auto-generated method stub
		return null;
	}

}
