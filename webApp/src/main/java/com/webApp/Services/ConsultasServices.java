package com.webApp.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webApp.Dao.ConsultasDao;
import com.webApp.Interfaces.ConsultasInterfaces;
import com.webApp.Models.Productos;
import com.webApp.Models.Users;

@Service
public class ConsultasServices implements ConsultasInterfaces {

	@Autowired
	private ConsultasDao dao;
	
	@Override
	public List<Map<String, Object>> verUser() {
		return dao.verUser();
	}

	@Override
	public List<Map<String, Object>> verUser(String id) {
		return dao.verUser(id);
	}

	@Override
	public int InsertUser(Users u) {
		return dao.InsertUser(u);
	}

	@Override
	public int UpdateUser(Users u) {
		return dao.UpdateUser(u);
	}

	@Override
	public int DeleteUser(Users u) {
		return dao.DeleteUser(u);
	}

	@Override
	public List<Map<String, Object>> verProductos() {
		return dao.verProductos();
	}

	@Override
	public List<Map<String, Object>> verProductos(String id) {
		return dao.verProductos(id);
	}

	@Override
	public int InsertProducto(Productos p) {
		//VAR GLOBAL
		int val = 0;
		try {
			//VALIDO NOMBRE DE PRODUCTO
			List<Map<String, Object>> valName = dao.valProductos(p.getNombre_producto());
			if (valName.size() == 0) {
				//SI NO EXISTE INSERTA
				val = dao.InsertProducto(p);
			} else {
				//YA EXISTE EL NOMBRE
				val = 2;
			}
		} catch (Exception ex) {
			val= 0;
		}
		return val;
	}

	@Override
	public int UpdateProductos(Productos p) {
		//VAR GLOBAL
		int val = 0;
		try {
			//VALIDO NOMBRE DE PRODUCTO
			List<Map<String, Object>> valName = dao.valProductos(p.getNombre_producto());
			if (valName.size() == 0) {
				val = dao.UpdateProductos(p);
			} else {
				//YA EXISTE EL NOMBRE
				val = 2;
			}
		} catch (Exception ex) {
			val=0;
		}
		return val;	
	}

	@Override
	public int DeleteProductos(Productos p) {
		int valide = 0;
		try {
		
		List<Map<String, Object>> OneProd = dao.verProductos(String.valueOf(p.getId()));
		String var = OneProd.get(0).get("Usu_Create").toString();
		if (OneProd.size() == 0) {
			valide = 0;
		} else {
			if (Integer.parseInt(var) == p.getUsu_update()) {
				valide = dao.DeleteProductos(p);
			}
		}
	}catch(Exception ex) {
		valide=0;
	}
		
		return valide;
	}

	@Override
	public List<Map<String, Object>> valProductos(String name) {
		return dao.valProductos(name);
	}

}
