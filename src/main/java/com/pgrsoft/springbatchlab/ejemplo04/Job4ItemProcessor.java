package com.pgrsoft.springbatchlab.ejemplo04;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Job4ItemProcessor implements ItemProcessor<Product,Product> {

	@Override
	public Product process(Product item) throws Exception {
		
		return item;
	}

}
