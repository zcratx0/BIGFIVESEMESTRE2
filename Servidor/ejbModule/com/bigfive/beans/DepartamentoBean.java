package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Departamento;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class DepartamentoBean implements DepartamentoBeanRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public DepartamentoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(Departamento value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR ESTUDIANTE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Departamento value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR ESTUDIANTE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Departamento value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR ESTUDIANTE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Departamento> listarElementos() {
		return em.createQuery("SELECT e FROM Departamento e").getResultList();
	}

}
