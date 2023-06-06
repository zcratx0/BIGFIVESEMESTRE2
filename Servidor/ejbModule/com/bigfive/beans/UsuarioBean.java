package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Usuario;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(Usuario usuario) {
		try {
			em.persist(usuario);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR USUARIO " + usuario.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Usuario value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR USUARIO " + value.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Usuario value) {
		try {
			em.merge(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR Usuario " + value.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Usuario> listarElementos() {
		return em.createQuery("SELECT u FROM Usuario u").getResultList();
	}

	@Override
	public boolean loginUsuario(String name, String password) {
		Usuario x = null;
		x =  (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE SUBSTRING(u.mailInstitucional, 1, LOCATE('@', u.mailInstitucional) - 1) LIKE CONCAT('%', :name, '%') AND u.contrasenia = :password")
        .setParameter("name", name)
        .setParameter("password", password)
        .getSingleResult();
		System.out.println(x);
		return x != null;
	}
    

}
