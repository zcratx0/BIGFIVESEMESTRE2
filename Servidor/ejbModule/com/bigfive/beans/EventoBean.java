package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Evento;

/**
 * Session Bean implementation class EventoBean
 */
@Stateless
public class EventoBean implements EventoBeanRemote {
    @PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EventoBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean crear(Evento value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR EVENTO");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean borrar(Evento value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR EVENTO");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean modificar(Evento value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR EVENTO");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Evento> listarElementos() {
		return em.createQuery("SELECT e FROM Evento e").getResultList();
	}

}
