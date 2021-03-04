package com.webApp.Interfaces;

import java.util.List;
import java.util.Map;

import com.webApp.Models.Productos;
import com.webApp.Models.Users;

public interface ConsultasInterfaces {
	/*Model USERS */
	public List<Map<String,Object>>verUser();
	public List<Map<String,Object>>verUser(String id);
	public int InsertUser(Users u);
	public int UpdateUser(Users u);
	public int DeleteUser(Users u);
	/*MODEL PRODUCTOS */
	public List<Map<String,Object>>verProductos();
	public List<Map<String,Object>>verProductos(String id);
	public List<Map<String,Object>>valProductos(String name);
	public int InsertProducto(Productos p);
	public int UpdateProductos(Productos p);
	public int DeleteProductos(Productos p);
}
