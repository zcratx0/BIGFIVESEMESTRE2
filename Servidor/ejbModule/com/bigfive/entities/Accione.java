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
	@SequenceGenerator(name="ACCIONES_IDACCIONES_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCIONES_IDACCIONES_GENERATOR")
	@Column(name="ID_ACCIONES")
	private long idAcciones;

	private String descripcion;

	//uni-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

	public Accione() {
	}

	public long getIdAcciones() {
		return this.idAcciones;
	}

	public void setIdAcciones(long idAcciones) {
		this.idAcciones = idAcciones;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}