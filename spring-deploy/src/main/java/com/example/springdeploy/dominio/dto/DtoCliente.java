package com.example.springdeploy.dominio.dto;

public class DtoCliente {
	
	private int id;

	private String apellidos;
	
	private String distrito;

	private String rutaFoto;

	private String documentoIdentidadPrincipal;

	private String nombres;

	private String sexo;

	private String telefono;

	private String direccion;

	private String NombreConyuge;
	
	private String telefonoFijo;


	private byte[] foto;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public String getRutaFoto() {
		return rutaFoto;
	}


	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}


	public String getDocumentoIdentidadPrincipal() {
		return documentoIdentidadPrincipal;
	}


	public void setDocumentoIdentidadPrincipal(String documentoIdentidadPrincipal) {
		this.documentoIdentidadPrincipal = documentoIdentidadPrincipal;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getNombreConyuge() {
		return NombreConyuge;
	}


	public void setNombreConyuge(String nombreConyuge) {
		NombreConyuge = nombreConyuge;
	}


	public String getTelefonoFijo() {
		return telefonoFijo;
	}


	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}


	public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	

}
