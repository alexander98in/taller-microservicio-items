package com.isbcs.app.items.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isbcs.app.items.clientes.IProductoClienteRest;
import com.isbcs.app.items.models.Item;
import com.isbcs.app.items.models.Producto;

@Service
public class ItemsServiceImpl implements IItemsService {

	@Autowired
	private IProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return this.clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item finfById(Long id, Integer cantidad) {
		return new Item(this.clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto saveProducto(Producto producto) {
		return this.clienteFeign.crear(producto);
	}
	
	@Override
	public Item save(Producto producto, Integer cantidad) {
		Producto productoNuevo = this.clienteFeign.crear(producto);
		Item itemNuevo = new Item();
		itemNuevo.setProducto(productoNuevo);
		itemNuevo.setCantidad(cantidad);
		
		return itemNuevo;
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return this.clienteFeign.update(producto, id);
	}

	@Override
	public Boolean delete(Long id) {
		return this.clienteFeign.eliminar(id);
	}
}
