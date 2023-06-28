package com.bigfive.beans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Area;
/**
 * Session Bean implementation class AreaBeanRemote
 */
@Singleton
@Startup
public class AreaBeanRemote implements AreaBeanRemoteRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
	
	private List<Area> areas;
	
	
    public AreaBeanRemote() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    @PostConstruct
    public void init() {
    	System.out.println("CARGANDO AREAS DE LA BASE DE DATOS");
    	this.areas = new ArrayList<>();
    	this.areas = em.createQuery("SELECT e FROM Area e").getResultList();
    	this.areas.forEach(a ->  {System.out.println(a.getIdArea() + " - " + a.getArea() );});
    }
    
    @PreDestroy
    public void destroy() {
    	System.out.println("SingletonBean termina");
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
		return this.areas;
	}

}
