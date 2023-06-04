package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GENERACION database table.
 * 
 */
@Entity
@NamedQuery(name="Generacion.findAll", query="SELECT g FROM Generacion g")
public class Generacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GENERACION_IDGENERACION_GENERATOR", sequenceName="SEQ_ID_GENERACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENERACION_IDGENERACION_GENERATOR")
	@Column(name="ID_GENERACION")
	private long idGeneracion;

	private String generacion;

	public Generacion() {
	}

	public long getIdGeneracion() {
		return this.idGeneracion;
	}

	public void setIdGeneracion(long idGeneracion) {
		this.idGeneracion = idGeneracion;
	}

	public String getGeneracion() {
		return this.generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}

}