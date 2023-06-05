package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.ConvocatoriaAsistencia;

/**
 * Session Bean implementation class ConvocatoriaAsistenciaBean
 */
@Stateless
public class ConvocatoriaAsistenciaBean implements ConvocatoriaAsistenciaBeanRemoteRemote {
    @PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ConvocatoriaAsistenciaBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean crear(ConvocatoriaAsistencia value) {
        try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR ConvocatoriaAsistencia");
			e.printStackTrace();
		}
		return false;
	}
    
	@Override
	public boolean borrar(ConvocatoriaAsistencia value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR ConvocatoriaAsistencia");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean modificar(ConvocatoriaAsistencia value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR ConvocatoriaAsistencia");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<ConvocatoriaAsistencia> listarElementos() {
		return em.createQuery("SELECT e FROM ConvocatoriaAsistencia e").getResultList();
	}

}
