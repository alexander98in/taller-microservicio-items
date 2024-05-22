package com.isbcs.app.items.service;

import java.util.List;

import com.isbcs.app.items.models.Item;
import com.isbcs.app.items.models.Producto;

public interface IItemsService {
	
	public List<Item> findAll();
	
	public Item finfById(Long id, Integer cantidad);
	
	public Producto saveProducto(Producto producto);
	
	public Item save(Producto producto, Integer cantidad);
	
	public Producto update(Producto producto, Long id);
	
	public Boolean delete(Long id);

}
