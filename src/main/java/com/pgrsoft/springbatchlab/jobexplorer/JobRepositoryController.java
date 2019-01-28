package com.pgrsoft.springbatchlab.jobexplorer;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobRepositoryController {

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobExplorer jobExplorer;
	
	@Autowired
	private JobRegistry jobRegistry;
	
	@RequestMapping("/prueba")
	public String prueba(Map<String, Object> model) {
		
		System.out.println(jobRepository);
		
		System.out.println(jobExplorer);
		
		System.out.println(jobRegistry);
		
		List<String> jobNames = jobExplorer.getJobNames();
		
		model.put("jobNames",jobNames);
		
		return "jobexplorer";
	}
	
}
