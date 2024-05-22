package com.isbcs.app.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.isbcs.app.items.models.Item;
import com.isbcs.app.items.models.Producto;
import com.isbcs.app.items.service.IItemsService;


public class ItemsController {
	
	@Autowired
	private IItemsService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		return this.itemService.findAll();
	}

	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return this.itemService.finfById(id, cantidad);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return this.itemService.saveProducto(producto);
	}
	
	@PostMapping("/crear/cantidad/{cantidad}")
	@ResponseStatus(HttpStatus.CREATED)
	public Item crear(@RequestBody Producto producto, @PathVariable Integer cantidad) {
		return this.itemService.save(producto, cantidad);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		return this.itemService.update(producto, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Boolean eliminar(@PathVariable Long id) {
		return this.itemService.delete(id);
	}
}
