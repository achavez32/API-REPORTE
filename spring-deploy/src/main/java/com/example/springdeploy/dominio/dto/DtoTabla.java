package com.example.springdeploy.dominio.dto;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DtoTabla {
	private Integer id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String estadoId;
	private String estadoNombre;
	private Date fecha;
	private String valor;
	private Integer idsede;
	
	
	
		
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getIdsede() {
		return idsede;
	}

	public void setIdsede(Integer idsede) {
		this.idsede = idsede;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/* solo sirve para la paginacion */
	@JsonIgnore
	private BigDecimal ROWNUM_;
	
	/* auxiliar cuando es base de datos oracle */
	@JsonIgnore
	private Integer idOracle;
	
	public DtoTabla() {
	}

	public DtoTabla(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	public String getEstadoNombre() {
		return estadoNombre;
	}

	public void setEstadoNombre(String estadoNombre) {
		this.estadoNombre = estadoNombre;
	}

	@JsonIgnore
	public BigDecimal getROWNUM_() {
		return ROWNUM_;
	}

	@JsonIgnore
	public void setROWNUM_(BigDecimal rOWNUM_) {
		ROWNUM_ = rOWNUM_;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonIgnore
	public Integer getIdOracle() {
		return idOracle;
	}

	@JsonIgnore
	public void setIdOracle(Integer idOracle) {
		this.idOracle = idOracle;
		if (idOracle!=null)
			this.id = idOracle; 
	}

	
	
}
