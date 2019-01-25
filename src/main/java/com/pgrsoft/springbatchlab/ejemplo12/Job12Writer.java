package com.pgrsoft.springbatchlab.ejemplo12;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class Job12Writer implements ItemWriter<Pedido> {

	@Override
	public void write(List<? extends Pedido> items) throws Exception {
		
		for(Pedido pedido: items) {
			System.out.println(pedido);
		}
		
	}

}
