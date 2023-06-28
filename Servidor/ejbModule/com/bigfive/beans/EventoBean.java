package com.bigfive.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Evento;

/**
 * Session Bean implementation class EventoBean
 */
@Singleton
@Startup
public class EventoBean implements EventoBeanRemote {
    @PersistenceContext
	EntityManager em;
    
    private List<Evento> eventos;
    
    /**
     * Default constructor. 
     */
    public EventoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void init() {
    	System.out.println("CARGANDO EVENTOS DE LA BASE DE DATOS");
    	this.eventos = em.createQuery("SELECT e FROM Evento e").getResultList();
    	this.eventos.forEach(e -> {
    		System.out.println(e.getIdEvento() + " - " + e.getTítulo());
    	});
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
		return this.eventos;
	}

}
