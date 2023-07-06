package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Evento;
import com.bigfive.entities.Reclamo;

/**
 * Session Bean implementation class Reclamo
 */
@Stateless
public class ReclamoBean implements ReclamoRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ReclamoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(Reclamo value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR RECLAMO");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Reclamo value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR RECLAMO");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Reclamo value) {
		try {
			em.merge(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR RECLAMO");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Reclamo> listarElementos() {
		return em.createQuery("SELECT r FROM Reclamo r WHERE r.habilitado = 1").getResultList();
	}

	@Override
	public List<Reclamo> reclamosDelEstudiante(Estudiante estudiante) {
		return em.createQuery("SELECT r FROM Reclamo r WHERE r.estudiante = :estudiante AND r.habilitado = 1").setParameter("estudiante", estudiante).getResultList();
	}

	
	@Override
	public boolean agregarReclamo(Reclamo value, Evento evento) {
		try {
			value.setEvento(evento);
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR RECLAMO");
			e.printStackTrace();
		}
		return false;
	}
	
}
