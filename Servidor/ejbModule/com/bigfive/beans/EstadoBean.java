package com.bigfive.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Estado;

/**
 * Session Bean implementation class EstadoBean
 */
@Singleton
@Startup
public class EstadoBean implements EstadoBeanRemote {
	@PersistenceContext
	EntityManager em;
	
	private List<Estado> estados;
    /**
     * Default constructor. 
     */
    public EstadoBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PostConstruct
    public void init() {
    	System.out.println("CARGANDO ITR'S DE LA BASE DE DATOS");
    	this.estados = new ArrayList<>();
    	this.estados = em.createQuery("SELECT e FROM Estado e").getResultList();
    	this.estados.forEach(i -> {
    		System.out.println("ESTADO: " + i.getNombre());
    	});
    }
    
    @PreDestroy
    public void destroy() {
    	System.out.println("ITRBean termina");
    }
    

	@Override
	public boolean crear(Estado value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL CREAR ESTADO: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean borrar(Estado value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL BORRAR ESTADO: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean modificar(Estado value) {
		try {
			em.merge(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL MODIFICAR TUTOR: " + e.getMessage());
		}
		return false;
	}

	@Override
	public List<Estado> listarElementos() {
		return this.estados;
	}

	@Override
	public void actualizar() {
		this.estados = em.createQuery("SELECT e FROM Estado e").getResultList();		
	}

}
