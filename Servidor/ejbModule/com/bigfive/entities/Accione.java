package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACCIONES database table.
 * 
 */
@Entity
@Table(name="ACCIONES")
@NamedQuery(name="Accione.findAll", query="SELECT a FROM Accione a")
public class Accione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCIONES_IDACCIONES_GENERATOR", sequenceName="SEQ_ID_ACCIONES ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCIONES_IDACCIONES_GENERATOR")
	@Column(name="ID_ACCIONES")
	private long idAcciones;

	@Column(name="NOMBRE_ACCION")
	private String nombreAccion;

	public Accione() {
	}

	public long getIdAcciones() {
		return this.idAcciones;
	}

	public void setIdAcciones(long idAcciones) {
		this.idAcciones = idAcciones;
	}

	public String getNombreAccion() {
		return this.nombreAccion;
	}

	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}

}