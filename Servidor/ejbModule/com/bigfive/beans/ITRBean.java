package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Itr;

/**
 * Session Bean implementation class ITRBean
 */
@Stateless
public class ITRBean implements ITRBeanRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ITRBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(Itr value) {
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
	public boolean borrar(Itr value) {
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
	public boolean modificar(Itr value) {
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
	public List<Itr> listarElementos() {
		return em.createQuery("SELECT u FROM Itr u").getResultList();
	}

}
