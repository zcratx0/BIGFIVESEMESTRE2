package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ACCION_JUSTIFICACION database table.
 * 
 */
@Entity
@Table(name="ACCION_JUSTIFICACION")
@NamedQuery(name="AccionJustificacion.findAll", query="SELECT a FROM AccionJustificacion a")
public class AccionJustificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCION_JUSTIFICACION_IDACCIONJUSTIFICACION_GENERATOR", sequenceName="SEQ_ID_ACCION_JUSTIFICACION ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCION_JUSTIFICACION_IDACCIONJUSTIFICACION_GENERATOR")
	@Column(name="ID_ACCION_JUSTIFICACION")
	private long idAccionJustificacion;

	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	@Column(name="ID_ANALISTA")
	private BigDecimal idAnalista;

	@Column(name="ID_CONSTANCIA")
	private BigDecimal idConstancia;

	public AccionJustificacion() {
	}

	public long getIdAccionJustificacion() {
		return this.idAccionJustificacion;
	}

	public void setIdAccionJustificacion(long idAccionJustificacion) {
		this.idAccionJustificacion = idAccionJustificacion;
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

	public BigDecimal getIdAnalista() {
		return this.idAnalista;
	}

	public void setIdAnalista(BigDecimal idAnalista) {
		this.idAnalista = idAnalista;
	}

	public BigDecimal getIdConstancia() {
		return this.idConstancia;
	}

	public void setIdConstancia(BigDecimal idConstancia) {
		this.idConstancia = idConstancia;
	}

}