package com.webApp.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.Models.Productos;
import com.webApp.Models.Users;
import com.webApp.Services.ConsultasServices;

@RestController
@RequestMapping(path="/consultas")
public class ConsultasController {
	
	@Autowired
	private ConsultasServices services;
	
	/* REST USUARIOS */
	@GetMapping("/view")
	@CrossOrigin(origins="*")
	public List<Map<String,Object>>verUsers(){
		return services.verUser();
	}
	
	@GetMapping("/view/{id}")
	@CrossOrigin(origins="*")
	public List<Map<String,Object>>verUsers(@PathVariable String id){
		return services.verUser(id);
	}
	
	@PostMapping("user/add")
	@CrossOrigin(origins="*")
	public int InsertUser(@RequestBody Users u) {
		return services.InsertUser(u);
	}
	
	@PutMapping("/user/update")
	@CrossOrigin(origins="*")
	public int UpdateUser(@RequestBody Users u) {
		return services.UpdateUser(u);
	}
	
		
	/* REST PRODUCTOS */
	
	@GetMapping("/producto/view")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> verProductos(){
		return services.verProductos();
	}
	
	@GetMapping("/producto/view/{id}")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> verProductos(@PathVariable String id){
		return services.verProductos(id);
	}
	
	@PostMapping("/producto/add")
	@CrossOrigin(origins="*")
	public int InsertProducto(@RequestBody Productos p) {
		return services.InsertProducto(p);
	}
	
	@PutMapping("/producto/update")
	@CrossOrigin(origins="*")
	public int UpdateProductos(@RequestBody Productos p) {
		return services.UpdateProductos(p);
	}
	
	@PostMapping("/producto/delete")
	@CrossOrigin(origins="*")
	public int deleteProducto(@RequestBody Productos p) {
		return services.DeleteProductos(p);
	}
	
	
	
}
