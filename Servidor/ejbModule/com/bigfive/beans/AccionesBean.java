package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Accione;
import com.bigfive.entities.RecibeReclamo;
import com.bigfive.entities.Reclamo;
import com.bigfive.utils.Mail;

/**
 * Session Bean implementation class AccionesBean
 */
@Stateless
public class AccionesBean implements AccionesBeanRemote {
    @PersistenceContext
    EntityManager em;
    /**
     * Default constructor. 
     */
    public AccionesBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean crear(Accione value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR ACCIONE");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean borrar(Accione value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR ACCIONE");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean modificar(Accione value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR ACCIONE");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Accione> listarElementos() {
		return em.createQuery("SELECT e FROM ACCIONE e").getResultList();
		
	}
	
	@Override
	public boolean reportaarAccion(Accione accion, Reclamo reclamo) {
		String msg = "<b>" + reclamo.getEstudiante().getUsuario().getNombre().toUpperCase() 
				+"</b><br>El analista comento sobre tu reclamo"
				+"<br>Nombre: " + reclamo.getTitulo()
				+"<br>Detalle: " + reclamo.getDetalle()
				+"<br>Analista: " + accion.getAnalista().getUsuario().getNombre() + accion.getAnalista().getUsuario().getApellido()
				+"<br>Email analista: " + accion.getAnalista().getUsuario().getMailInstitucional()
				+"<br>Acción: " + accion.getDescripcion()
				+"<br>Estado: " + accion.getEstado().getNombre().toUpperCase();
		try {
			em.persist(accion);
			em.flush();
			RecibeReclamo rc = new RecibeReclamo();
			rc.setAccione(accion);
			rc.setReclamo(reclamo);
			em.persist(rc);
			em.flush();
			Mail.sendMail(reclamo.getEstudiante().getUsuario().getMailInstitucional(), "ACCION SOBRE RECLAMO: " + reclamo.getTitulo().toUpperCase(), msg);
		} catch (Exception e) {
			System.out.println("ERROR AL CREAR ACCION Y REPORTE: " + e.getMessage());
		}
		return false;
	}

}
