package com.pgrsoft.springbatchlab.ejemplo04;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.PreparedStatementSetter;

@Configuration
public class Job04Config {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("job4ItemProcessor")
	private ItemProcessor<Product,Product> processor;

	@Bean
	public Job job4() {
		return jobBuilderFactory.get("job4")
				.flow(step4())
				.end()
				.build();
	}
	
	@Bean
	public Step step4() {
		return stepBuilderFactory.get("step4")
				.<Product,Product> chunk(10)
				.reader(reader4("HARDWARE"))
				.processor(processor)
				.writer(writer4())
				.build();
	}
	
	@Bean
	public JdbcCursorItemReader<Product> reader4 (String familia){
	
		System.out.println("fase de construcción del reader4");
		
		JdbcCursorItemReader<Product> cursorItemReader = new JdbcCursorItemReader<>();
	
		cursorItemReader.setDataSource(dataSource);
		cursorItemReader.setSql("SELECT CODIGO, NOMBRE, PRECIO, FAMILIA FROM PRODUCTS WHERE FAMILIA = ?");
		cursorItemReader.setPreparedStatementSetter(new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,familia);
			}
			
		});
		
		cursorItemReader.setRowMapper(new ProductRowMapper());
		
		return cursorItemReader;
	}
	
	public FlatFileItemWriter<Product> writer4(){
		
		FlatFileItemWriter<Product> writer = new FlatFileItemWriter<>();
		
		// dónde
		
		writer.setResource(new FileSystemResource("materiales/salidas/ejemplo04_productos.csv"));
		
		// cómo
		
		BeanWrapperFieldExtractor<Product> fieldExtractor = new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(new String[] {"codigo","nombre","precio","familia"});
		
		DelimitedLineAggregator<Product> lineAggregator = new DelimitedLineAggregator<>();
		
		lineAggregator.setDelimiter(","); // es obligatorio?
		lineAggregator.setFieldExtractor(fieldExtractor);
		
		writer.setLineAggregator(lineAggregator);
 		
		return writer;
	}
	
	
	
	

}
