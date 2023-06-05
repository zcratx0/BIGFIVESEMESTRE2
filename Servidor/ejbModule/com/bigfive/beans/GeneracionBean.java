package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Generacion;

/**
 * Session Bean implementation class GeneracionBean
 */
@Stateless
public class GeneracionBean implements GeneracionBeanRemote {
    @PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GeneracionBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean crear(Generacion value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR GENERACION");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean borrar(Generacion value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR GENERACION");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean modificar(Generacion value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR GENERACION");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Generacion> listarElementos() {
		return em.createQuery("SELECT e FROM Generacion e").getResultList();
	}

}
