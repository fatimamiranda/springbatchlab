package com.pgrsoft.springbatchlab.ejemplo07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Job7Reader implements ItemReader<Product> {

	private List<Product> productos = new ArrayList<Product>();
	
	public Job7Reader() {
		this.productos.add(new Product());
		this.productos.add(new Product());
		this.productos.add(new Product());
	}
	
	@Override
	public Product read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		if (!productos.isEmpty()) {
			return productos.remove(0);
		}
		
		return null;
	}

}
