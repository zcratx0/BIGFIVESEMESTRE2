package com.bigfive.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Itr;

/**
 * Session Bean implementation class ITRBean
 */
@Stateless
public class ITRBean implements ITRBeanRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ITRBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(Itr value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Itr value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Itr value) {
		try {
			em.merge(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Itr> listarElementos() {
		List<Itr> lista = new ArrayList<Itr>();
		try {
			 lista = em.createQuery("SELECT u FROM Itr u").getResultList();
		} catch (Exception e) {
			System.out.println("ERROR AL CARGAR LA LISTA DE ELEMENTOS: " + e.getMessage());
		}
		return lista;
	}
	@Override
	public List<Itr> listarElementosHabilitados() {
		System.out.println("CARGANDO ITR'S");
		List<Itr> lista = new ArrayList<>();
		try {
			lista = em.createQuery("SELECT u FROM Itr u WHERE u.estado <> 0").getResultList();
		} catch (Exception e) {
			System.out.println("ERROR AL CARGAR LA LISTA DE ELEMENTOS: " + e.getMessage());
		}
		return lista;
	}
}
