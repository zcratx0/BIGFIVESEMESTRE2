package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ITR database table.
 * 
 */
@Entity
@NamedQuery(name="Itr.findAll", query="SELECT i FROM Itr i")
public class Itr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ITR_IDITR_GENERATOR", sequenceName="SEQ_ID_ITR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITR_IDITR_GENERATOR")
	@Column(name="ID_ITR")
	private long idItr;

	private String nombre;

	//uni-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamento;

	public Itr() {
	}

	public long getIdItr() {
		return this.idItr;
	}

	public void setIdItr(long idItr) {
		this.idItr = idItr;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return this.nombre+"-"+this.departamento;
	}
	

}