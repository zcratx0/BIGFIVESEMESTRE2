package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEPARTAMENTO database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTAMENTO_IDDEPARTAMENTO_GENERATOR", sequenceName="SEQ_ID_DEPARTAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTAMENTO_IDDEPARTAMENTO_GENERATOR")
	@Column(name="ID_DEPARTAMENTO")
	private long idDepartamento;

	private String nombre;

	public Departamento() {
	}

	public long getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	

}