package com.pgrsoft.springbatchlab.ejemplo07;

import java.text.SimpleDateFormat;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Job7ItemProcessor implements ItemProcessor<ProductDTO,Product>{

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Product process(ProductDTO item) throws Exception {
		
		Product product = new Product();
		
		product.setCodigo(Integer.parseInt(item.getCodigo()));
		product.setNombre(item.getNombre());
		product.setPrecio(Double.parseDouble(item.getPrecio()));
		product.setFamilia(item.getFamilia());
		product.setDescatalogado(Boolean.parseBoolean(item.getDescatalogado()));
		product.setFechaAlta(sdf.parse(item.getFechaAlta()));
		
		return product;
	}
}
