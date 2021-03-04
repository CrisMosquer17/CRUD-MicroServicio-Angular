package com.webApp.Models;

import javax.persistence.Id;

public class Productos {

	@Id
	private int id;
	private String nombre_producto;
	private int cantidad;
	private String fh_create;
	private int usu_create;
	private int usu_update;
	
	
	
	public Productos() {
		super();
	}


	//INSERT
	public Productos(int id, String nombre_producto, int cantidad,int usu_create) {
		super();
		this.id = id;
		this.nombre_producto = nombre_producto;
		this.cantidad = cantidad;
		this.usu_create = usu_create;
	}
	
	
	

	//UPDATE
	public Productos(String nombre_producto, int cantidad, int usu_create, int usu_update, int id) {
		super();
		this.nombre_producto = nombre_producto;
		this.cantidad = cantidad;
		this.usu_update = usu_update;
		this.id = id;
	}
	



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre_producto() {
		return nombre_producto;
	}



	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	

	public int getUsu_create() {
		return usu_create;
	}

	

	public String getFh_create() {
		return fh_create;
	}



	public void setFh_create(String fh_create) {
		this.fh_create = fh_create;
	}



	public void setUsu_create(int usu_create) {
		this.usu_create = usu_create;
	}


	public int getUsu_update() {
		return usu_update;
	}


	public void setUsu_update(int usu_update) {
		this.usu_update = usu_update;
	}
	
	
	
	
	
	
}
