package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RECIBE_JUSTIFICACION database table.
 * 
 */
@Entity
@Table(name="RECIBE_JUSTIFICACION")
@NamedQuery(name="RecibeJustificacion.findAll", query="SELECT r FROM RecibeJustificacion r")
public class RecibeJustificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECIBE_JUSTIFICACION_IDRECIBEJU_GENERATOR", sequenceName="SEQ_ID_RECIBE ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECIBE_JUSTIFICACION_IDRECIBEJU_GENERATOR")
	@Column(name="ID_RECIBEJU")
	private long idRecibeju;

	//uni-directional many-to-one association to Accione
	@ManyToOne
	@JoinColumn(name="ID_ACCIONES")
	private Accione accione;

	//uni-directional many-to-one association to Justificacion
	@ManyToOne
	@JoinColumn(name="ID_JUSTIFICACION")
	private Justificacion justificacion;

	public RecibeJustificacion() {
	}

	public long getIdRecibeju() {
		return this.idRecibeju;
	}

	public void setIdRecibeju(long idRecibeju) {
		this.idRecibeju = idRecibeju;
	}

	public Accione getAccione() {
		return this.accione;
	}

	public void setAccione(Accione accione) {
		this.accione = accione;
	}

	public Justificacion getJustificacion() {
		return this.justificacion;
	}

	public void setJustificacion(Justificacion justificacion) {
		this.justificacion = justificacion;
	}

}