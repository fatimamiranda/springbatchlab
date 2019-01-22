package com.pgrsoft.springbatchlab.ejemplo03;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.pgrsoft.springbatchlab.batchconfiguration.AbstractJobConfig;

@Configuration
public class Job3Config extends AbstractJobConfig {
	
	@Autowired
	private DataSource dataSource;
	
	// Configuramos el Job
	
	@Bean
	public Job job3() {
		return jobBuilderFactory.get("Job3... leer Product de csv y guardar en tabla PRODUCTS")
				.flow(step3())
				.end()
				.build();
	}
	
	// Configuramos el Step
	
	@Bean
	public Step step3() {
		return stepBuilderFactory.get("step3")
				.<Product,Product> chunk(10)
				.reader(reader3())
				.writer(writer3())
				.build();
	}
	
	// Configuramos el reader

	public FlatFileItemReader<Product> reader3(){
		
		return new FlatFileItemReaderBuilder<Product>()
			.name("reader3")
			.resource(new FileSystemResource("materiales/entradas/ejemplo03_productos.csv"))
			
			.comments(new String[] {"#"})
			.linesToSkip(14)
			
			.delimited()
			.names(new String[] {"codigo","nombre","precio","fechaAlta","descatalogado","familia"})
			.fieldSetMapper(new BeanWrapperFieldSetMapper<Product>(){{
				setTargetType(Product.class);
			}}).build();
	}
	
	@Bean // Necesario que esté registrado como Bean!!
	public JdbcBatchItemWriter<Product> writer3(){
		return new JdbcBatchItemWriterBuilder<Product>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO PRODUCTS (CODIGO, NOMBRE, PRECIO, FECHA_ALTA, DESCATALOGADO, FAMILIA) VALUES (:codigo, :nombre, :precio, :fechaAlta, :descatalogado, :familia)")
				.dataSource(dataSource)
				.build();
	}
}
