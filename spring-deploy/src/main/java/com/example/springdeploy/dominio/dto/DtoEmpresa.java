package com.example.springdeploy.dominio.dto;

public class DtoEmpresa {
	
	
	private int id;

	private String nombre;
	
	private String telefono;
	
	private String ruc;
	
	private String rsCorto;
	private String direccionPrincipal;
	private String distrito;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRsCorto() {
		return rsCorto;
	}
	public void setRsCorto(String rsCorto) {
		this.rsCorto = rsCorto;
	}
	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}
	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	

	
}
