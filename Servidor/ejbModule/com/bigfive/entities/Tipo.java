package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPO database table.
 * 
 */
@Entity
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_IDTIPO_GENERATOR", sequenceName="SEQ_ID_TIPO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_IDTIPO_GENERATOR")
	@Column(name="ID_TIPO")
	private long idTipo;

	private String tipo;

	public Tipo() {
		
	}
	public long getIdTipo() {
		return this.idTipo;
	}
	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}