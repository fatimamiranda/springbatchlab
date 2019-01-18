package com.pgrsoft.springbatchlab.triggers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggersController {

	@Autowired
//	@Qualifier("syncJobLauncher")
	@Qualifier("asyncJobLauncher")
	private JobLauncher jobLauncher;
	
	@Autowired
//	@Qualifier("job1")
	private Job job1;
	
	@RequestMapping("/job1")
	public String job1() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String,JobParameter> jobParametersMap = new HashMap<>();
		
		jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
		
		JobParameters jobParameters = new JobParameters(jobParametersMap);
		
		jobLauncher.run(job1, jobParameters);
		
		return "ok";
	}
	
	
	
}
