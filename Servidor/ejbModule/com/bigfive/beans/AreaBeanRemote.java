package com.bigfive.beans;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bigfive.entities.Area;
/**
 * Session Bean implementation class AreaBeanRemote
 */
@Stateless
public class AreaBeanRemote implements AreaBeanRemoteRemote {
@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AreaBeanRemote() {
        // TODO Auto-generated constructor stub
    }
     @Override
	public boolean crear(Area value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR AREA");
			e.printStackTrace();
		}
		return false;
	}
    @Override
	public boolean borrar(Area value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR AREA");
			e.printStackTrace();
		}
		return false;
	}
    @Override
	public boolean modificar(Area value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR AREA");
			e.printStackTrace();
		}
		return false;
	}
    @Override
	public List<Area> listarElementos() {
		return em.createQuery("SELECT e FROM Area e").getResultList();
	}

}
