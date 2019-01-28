package com.pgrsoft.springbatchlab.jobexplorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
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
		
		List<String> jobNames = jobExplorer.getJobNames();
		
		List<JobExecution> jobExecutions = new ArrayList<>();
		
		for (String jobName: jobExplorer.getJobNames()) {
			List<JobInstance> jobInstances = jobExplorer.getJobInstances(jobName, 0, 1000);
			
			for (JobInstance jobInstance: jobInstances) {
				List<JobExecution> jobExecutionsForJobInstance = jobExplorer.getJobExecutions(jobInstance);
				jobExecutions.addAll(jobExecutionsForJobInstance);
			}
			
		}
		
		jobExecutions.sort((a,b) -> a.getId().compareTo(b.getId()));
		
		jobExecutions.stream().forEach(x-> {
			System.out.println(x.getExitStatus());
			System.out.println(x.getCreateTime());
			System.out.println(x.getJobInstance().getJobName());
			System.out.println(x.getJobParameters());
			
			
			
			System.out.println(x.getJobId());
		});
		
		model.put("jobNames",jobNames);
		model.put("jobExecutions",jobExecutions);
		
		System.out.println(jobExecutions);
		
		return "jobexplorer";
	}
	
}
