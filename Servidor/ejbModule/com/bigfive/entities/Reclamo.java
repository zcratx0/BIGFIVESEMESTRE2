package com.bigfive.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the RECLAMO database table.
 * 
 */
@Entity
@NamedQuery(name="Reclamo.findAll", query="SELECT r FROM Reclamo r")
public class Reclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECLAMO_IDRECLAMO_GENERATOR", sequenceName="SEQ_ID_RECLAMO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECLAMO_IDRECLAMO_GENERATOR")
	@Column(name="ID_RECLAMO")
	private long idReclamo;

	private BigDecimal credito;

	private String detalle;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	@ManyToOne
	@JoinColumn(name="ID_ESTUDIANTE")
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name="ID_TUTOR")
	private Tutor tutor;

	@Column(name="NOMBRE_ACTIVIDAD")
	private String nombreActividad;

	@Column(name="NOMBRE_EVENTO")
	private String nombreEvento;

	private String semestre;

	private String titulo;

	public Reclamo() {
	}

	public long getIdReclamo() {
		return this.idReclamo;
	}

	public void setIdReclamo(long idReclamo) {
		this.idReclamo = idReclamo;
	}

	public BigDecimal getCredito() {
		return this.credito;
	}

	public void setCredito(BigDecimal credito) {
		this.credito = credito;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante idEstudiante) {
		this.estudiante = idEstudiante;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento idEvento) {
		this.evento = idEvento;
	}

	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor idTutor) {
		this.tutor = idTutor;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getNombreEvento() {
		return this.nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}