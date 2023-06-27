package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bigfive.entities.Rol;

/**
 * Session Bean implementation class RolBean
 */
@Stateless
public class RolBean implements RolBeanRemote {
	@PersistenceContext
	EntityManager em;
    
    public RolBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(Rol value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR ROL");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Rol value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR ROL");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Rol value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR ROL");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Rol> listarElementos() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM Rol r").getResultList();
	}

}
