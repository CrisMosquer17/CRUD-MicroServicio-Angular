package com.webApp.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webApp.Interfaces.ConsultasInterfaces;
import com.webApp.Models.Productos;
import com.webApp.Models.Users;

@Repository
public class ConsultasDao implements ConsultasInterfaces {
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Map<String, Object>> verUser() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM db_prueba.\"Users\";");
		return view;
	}

	@Override
	public List<Map<String, Object>> verUser(String id) {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM db_prueba.\"Users\" WHERE \"ID_User\" = '"+id+"';");
		return view;
	}

	@Override
	public int InsertUser(Users u) {
		int valide = template.update("INSERT INTO db_prueba.\"Users\"(\r\n"
				+ "	 \"Name\", \"Login\", \"Password\", \"Password_alt\", \"Mail\", \"Enabled\")\r\n"
				+ "	VALUES ( '"+u.getName()+"', '"+u.getLogin()+"', '"+u.getPass()+"', '"+u.getPass_alt()+"', '"+u.getMail()+"', 1);\r\n"
				+ "	");
		return valide;
	}

	@Override
	public int UpdateUser(Users u) {
		int valide = template.update("UPDATE db_prueba.\"Users\" set \"Password\"='"+u.getPass()+"', \"Password_alt\"='"+u.getPass_alt()+"' where \"Login\" = '"+u.getLogin()+"';");
		return valide;
	}

	@Override
	public int DeleteUser(Users u) {
		int valide = template.update("DELETE FROM db_prueba.\"Users\"\r\n"
				+ "	WHERE \"ID_User\"="+u.getId() +";");
		return valide;
	}

	@Override
	public List<Map<String, Object>> verProductos() {
		List<Map<String, Object>>view = template.queryForList("SELECT * FROM db_prueba.\"Productos\";");
		return view;
	}

	@Override
	public List<Map<String, Object>> verProductos(String id) {
		List<Map<String, Object>>view = template.queryForList("select * from db_prueba.\"Productos\" WHERE \"ID\" = '"+ id +"'");
		return view;
	}
	@Override
	public List<Map<String, Object>> valProductos(String name) {
		List<Map<String,Object>> view = template.queryForList("SELECT * FROM db_prueba.\"Productos\" WHERE \"Nombre_Producto\" = '"+name +"' ");
		return view;
	}


	@Override
	public int InsertProducto(Productos p) {
		int valide = template.update("INSERT INTO db_prueba.\"Productos\"(\"Nombre_Producto\", \"Cantidad\", \"Fh_create\", \"Usu_create\")\r\n"
				+ "	VALUES ('"+p.getNombre_producto()+"', "+p.getCantidad()+", CURRENT_DATE, "+p.getUsu_create()+");");
		return valide;
	}

	@Override
	public int UpdateProductos(Productos p) {
		
		int valide = template.update("UPDATE db_prueba.\"Productos\"\r\n"
				+ "	SET \"Nombre_Producto\"='"+p.getNombre_producto()+"', \"Cantidad\"="+p.getCantidad()+", \"Usu_update\"="+ p.getUsu_update()+", \"Fh_update\"= CURRENT_DATE "
						+ "WHERE \"ID\"="+p.getId()+";"); 
	return valide;
	}

	@Override
	public int DeleteProductos(Productos p) {
		int valide = template.update("DELETE FROM db_prueba.\"Productos\"\r\n"
				+ "	WHERE \"ID\"="+p.getId()+";");
		return valide;
	}


	


}
