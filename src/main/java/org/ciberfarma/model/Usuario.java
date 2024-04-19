package org.ciberfarma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "tb_usuarios")
@NamedQuery(name = "Usuario.findAll", query = "select u from Usuario u") // en lugar de poner tb_usuarios pongo la entidad Usuarios
																		//  select u , recuerda que devuelve todos los campos
@NamedQuery(name = "Usuario.findAllxTipo", query = "select u from Usuario u where u.tipo = :xtipo")//  si yo quiero algunos no todos los campos

public class Usuario {
	
	@Id
	@Column(name = "cod_usua")
	private int codigo;
	
	@Column(name = "nom_usua")
	private String nombre;
	
	@Column(name = "ape_usua")
	private String apellido;
	
	@Column(name = "usr_usua")
	private String usuario;
	
	@Column(name = "cla_usua")
	private String clave;
	
	@Column(name = "fna_usua")
	private String fnacim;
	
	@Column(name = "idtipo")
	private int tipo;

	@Column(name = "est_usua")
	private int estado;
	
	

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFnacim() {
		return fnacim;
	}
	public void setFnacim(String fnacim) {
		this.fnacim = fnacim;
	}

	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

	
}
