package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Analista;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Tutor;
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
	public Usuario loginUsuario(String name, String password) {
		Usuario x = null;
		x = (Usuario) em.createQuery(
				"SELECT u FROM Usuario u WHERE SUBSTRING(u.mailInstitucional, 1, LOCATE('@', u.mailInstitucional) - 1) LIKE :name AND u.contrasenia = :password")
				.setParameter("name", name).setParameter("password", password).getSingleResult();
		System.out.println(x);
		return x;
	}

	@Override
	public int detectarUsuario(Long usuario) {
		// Retorna "0" para analista, "1" para tutor, "2" para estudiante y "-1" para error
		Analista analista = null;
		try {
			analista = (Analista) em.createQuery("SELECT a FROM Analista a WHERE a.usuario.id = :user").setParameter("user", usuario).getSingleResult();
			if (analista != null) {return 0;}
		} catch (Exception e) {
			try {
				Tutor tutor = null;
				tutor = (Tutor) em.createQuery("SELECT t FROM Tutor t WHERE t.usuario.id = :user").setParameter("user", usuario).getSingleResult();
				if (tutor != null) {return 1;}
			} catch (Exception e1) {
				try {
					Estudiante estudiante = null;
					estudiante = (Estudiante) em.createQuery("SELECT e FROM Estudiante e WHERE e.usuario.id = :user").setParameter("user", usuario).getSingleResult();
					if (estudiante != null) {return 2;}
				} catch (Exception e2) {
					return -1;
				}
			}
		}
		return -1;		
	}
	

	@Override
	public int getEstadoUsuario(Usuario usuario) {
		// Obtiene el estado del Usuario

		int estado;

		estado = (int) em.createQuery("SELECT u.estado FROM Usuario u WHERE u.estado = :user")
				.setParameter("user", usuario).getSingleResult();

		return estado;
	}

	@Override
	public Long createWithId(Usuario usuario) {
		try {
			em.persist(usuario);
			em.flush();
			System.out.println("CREANDO USUARIO");
			return (Long) usuario.getIdUsuario();
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR USUARIO " + usuario.toString());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Analista getAnalista(Usuario usuario) {
		return (Analista) em.createQuery("SELECT a FROM Analista a WHERE a.usuario.id = :user").setParameter("user", usuario.getIdUsuario()).getSingleResult();
	}
	@Override
	public Estudiante getEstudiante(Usuario usuario) {
		return (Estudiante) em.createQuery("SELECT e FROM Estudiante e WHERE e.usuario.id = :user").setParameter("user", usuario.getIdUsuario()).getSingleResult();
	}
	@Override
	public Tutor getTutor(Usuario usuario) {
		return (Tutor) em.createQuery("SELECT t FROM Tutor t WHERE t.usuario.id = :user").setParameter("user", usuario.getIdUsuario()).getSingleResult();
	}
	
	
}
