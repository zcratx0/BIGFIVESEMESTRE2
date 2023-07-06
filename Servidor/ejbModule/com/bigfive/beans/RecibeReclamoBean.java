package com.bigfive.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.RecibeReclamo;
import com.bigfive.entities.Reclamo;

/**
 * Session Bean implementation class RecibeReclamoBean
 */
@Stateless
@LocalBean
public class RecibeReclamoBean implements RecibeReclamoBeanRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RecibeReclamoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(RecibeReclamo value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(RecibeReclamo value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(RecibeReclamo value) {
		try {
			em.merge(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<RecibeReclamo> listarElementos() {
		// TODO Auto-generated method stub
		return null;
	}


}
