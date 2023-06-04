package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ACCION_RECLAMO database table.
 * 
 */
@Entity
@Table(name="ACCION_RECLAMO")
@NamedQuery(name="AccionReclamo.findAll", query="SELECT a FROM AccionReclamo a")
public class AccionReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCION_RECLAMO_IDACCIONRECLAMO_GENERATOR", sequenceName="SEQ_ID_ACCION_RECLAMO ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCION_RECLAMO_IDACCIONRECLAMO_GENERATOR")
	@Column(name="ID_ACCION_RECLAMO")
	private long idAccionReclamo;

	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	//uni-directional many-to-one association to Analista
	@ManyToOne
	@JoinColumn(name="ID_ANALISTA")
	private Analista analista;

	//uni-directional many-to-one association to Reclamo
	@ManyToOne
	@JoinColumn(name="ID_RECLAMO")
	private Reclamo reclamo;

	public AccionReclamo() {
	}

	public long getIdAccionReclamo() {
		return this.idAccionReclamo;
	}

	public void setIdAccionReclamo(long idAccionReclamo) {
		this.idAccionReclamo = idAccionReclamo;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Analista getAnalista() {
		return this.analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Reclamo getReclamo() {
		return this.reclamo;
	}

	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

}