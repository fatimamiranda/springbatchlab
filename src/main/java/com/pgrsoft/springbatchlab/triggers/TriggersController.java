package com.pgrsoft.springbatchlab.triggers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggersController {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	@Qualifier("asyncJobLauncher")
	private JobLauncher asyncJobLauncher;
	
	@Autowired
	@Qualifier("syncJobLauncher")
	private JobLauncher syncJobLauncher;
			
	@Autowired
	private Job job4;
	
	@Autowired
	private Job job15;
	
	@RequestMapping("/trigger/{job}")
	public String endPoint(@PathVariable ("job") String strJob,
						   @RequestParam(name="p1",required=false) Object p1) throws Exception {
		
		return launch(strJob);
	}
	
	private String launch(String strJob) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Job job = context.getBean(strJob, Job.class);
		
		Map<String,JobParameter> jobParametersMap = new HashMap<>();		
		jobParametersMap.put("parametro1", new JobParameter("parametro_" + System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(jobParametersMap);
		JobExecution jobExecution = asyncJobLauncher.run(job, jobParameters);
		return "Estado " + strJob + ": " + jobExecution.getStatus().toString();
	}
		
	// El parámetro llega como "request parameter"
		
	@RequestMapping("/job4")
	public String job4parameter(@RequestParam ("familia") String familia) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
			
		Map<String,JobParameter> jobParametersMap = new HashMap<>();
			
		jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
		jobParametersMap.put("familia", new JobParameter(familia));
		JobParameters jobParameters = new JobParameters(jobParametersMap);
		asyncJobLauncher.run(job4, jobParameters);
			
		return "ok";
	}
													
	@RequestMapping("/job15")
	public String job15(@RequestParam(name="fail", required=false,  defaultValue="3") String fail) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Map<String,JobParameter> jobParametersMap = new HashMap<>();
		jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
		jobParametersMap.put("fail", new JobParameter(fail));
		JobParameters jobParameters = new JobParameters(jobParametersMap);
		asyncJobLauncher.run(job15, jobParameters);
		return "ok";
	}
}
