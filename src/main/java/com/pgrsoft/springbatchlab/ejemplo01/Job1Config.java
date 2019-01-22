package com.pgrsoft.springbatchlab.ejemplo01;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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

@Configuration
public class Job1Config {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private DataSource dataSource;
	
	// Configuramos el Job
	
	@Bean
	public Job job1() {
		
		
		return jobBuilderFactory.get("Job1... ller Person de csv y guardar en tabla PEOPLE")
				.flow(step1())
				.end()
				.build();
	}
	
	// Configuramos el Step
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<Person,Person> chunk(10)
				.reader(reader1())
				.writer(writer1())
				.build();
	}
	
	// Configuramos el reader

	public FlatFileItemReader<Person> reader1(){
		return new FlatFileItemReaderBuilder<Person>()
			.name("reader1")
			.resource(new FileSystemResource("materiales/entradas/ejemplo01_personas.csv"))
			.delimited()
			.names(new String[] {"firstName","lastName"})
			.fieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){{
				setTargetType(Person.class);
			}}).build();
	}
	
	@Bean // Necesario que esté registrado como Bean!!
	public JdbcBatchItemWriter<Person> writer1(){
		return new JdbcBatchItemWriterBuilder<Person>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO PEOPLE (first_name, last_name) VALUES (:firstName, :lastName)")
				.dataSource(dataSource)
				.build();
	}
}
