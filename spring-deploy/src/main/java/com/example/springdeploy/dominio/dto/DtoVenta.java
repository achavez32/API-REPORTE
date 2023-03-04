package com.example.springdeploy.dominio.dto;

import java.util.Date;
import java.util.List;

public class DtoVenta {
	


	private int id;
	private DtoCliente cliente;
	private Date fecha;
	private double montoTotal;
	private List<DtoLetraVenta> letraVentas;
	//private TipoMoneda tipoMoneda;
	private DtoLote lote;
	//private VentaEstado ventaEstado;
	private double montoInicial;
	private double devolucionPorcentaje;
	//private Comisionista comisionista;
	private double comisionPorcentaje;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DtoCliente getCliente() {
		return cliente;
	}
	public void setCliente(DtoCliente cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public List<DtoLetraVenta> getLetraVentas() {
		return letraVentas;
	}
	public void setLetraVentas(List<DtoLetraVenta> letraVentas) {
		this.letraVentas = letraVentas;
	}
	public DtoLote getLote() {
		return lote;
	}
	public void setLote(DtoLote lote) {
		this.lote = lote;
	}
	public double getMontoInicial() {
		return montoInicial;
	}
	public void setMontoInicial(double montoInicial) {
		this.montoInicial = montoInicial;
	}
	public double getDevolucionPorcentaje() {
		return devolucionPorcentaje;
	}
	public void setDevolucionPorcentaje(double devolucionPorcentaje) {
		this.devolucionPorcentaje = devolucionPorcentaje;
	}
	public double getComisionPorcentaje() {
		return comisionPorcentaje;
	}
	public void setComisionPorcentaje(double comisionPorcentaje) {
		this.comisionPorcentaje = comisionPorcentaje;
	}
	
	
	
}
