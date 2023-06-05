package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Constancia;

/**
 * Session Bean implementation class ConstanciaBeanRemote
 */
@Stateless
public class ConstanciaBeanRemote implements ConstanciaBeanRemoteRemote {
    @PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ConstanciaBeanRemote() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean crear(Constancia value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR CONSTANCIA");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean borrar(Constancia value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR CONSTANCIA");
			e.printStackTrace();
		}
		return false;
		
	}
	@Override
	public boolean modificar(Constancia value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR CONSTANCIA");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Constancia> listarElementos() {
		return em.createQuery("SELECT e FROM Constancia e").getResultList();
	}

}
