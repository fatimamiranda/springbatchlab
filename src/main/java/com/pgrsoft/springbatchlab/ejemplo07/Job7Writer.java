package com.pgrsoft.springbatchlab.ejemplo07;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Job7Writer implements ItemWriter<Product> {

	@Override
	public void write(List<? extends Product> products) throws Exception {
		products.forEach(System.out::println);
	}
}
