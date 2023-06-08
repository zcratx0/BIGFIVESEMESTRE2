package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_IDUSUARIO_GENERATOR", sequenceName="SEQ_ID_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_IDUSUARIO_GENERATOR")
	@Column(name="ID_USUARIO")
	private long idUsuario;

	private String apellido;

	private String contrasenia;

	private String documento;

	private BigDecimal estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	private String localidad;

	private String mail;

	@Column(name="MAIL_INSTITUCIONAL")
	private String mailInstitucional;

	private String nombre;

	private String telefono;

	//uni-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamento;

	//uni-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="ID_GENERO")
	private Genero genero;

	//uni-directional many-to-one association to Itr
	@ManyToOne
	@JoinColumn(name="ID_ITR")
	private Itr itr;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMailInstitucional() {
		return this.mailInstitucional;
	}

	public void setMailInstitucional(String mailInstitucional) {
		this.mailInstitucional = mailInstitucional;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Itr getItr() {
		return this.itr;
	}

	public void setItr(Itr itr) {
		this.itr = itr;
	}

}