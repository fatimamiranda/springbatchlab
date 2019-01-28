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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggersController {

	@Autowired
//	@Qualifier("syncJobLauncher")
	@Qualifier("asyncJobLauncher")
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job1;
	
	@Autowired
	private Job job2;
	
	@Autowired
	private Job job3;
	
	@Autowired
	private Job job4;
	
	@Autowired
	private Job job6;
	
	@Autowired
	private Job job7;
	
	@Autowired
	private Job job8;
	
	@Autowired
	private Job job10;
	
	@Autowired
	private Job job11;
	
	@Autowired
	private Job job12;
	
	@Autowired
	private Job job13;
	
	@Autowired
	private Job job14;
	
	@Autowired
	private Job job15;
	
	@RequestMapping("/job1")
	public String job1() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String,JobParameter> jobParametersMap = new HashMap<>();
		
		jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
		
		JobParameters jobParameters = new JobParameters(jobParametersMap);
		
		jobLauncher.run(job1, jobParameters);
		
		return "ok";
	}
	
	//*******************************************************************
	
	@RequestMapping("/job2")
	public String job2() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String,JobParameter> jobParametersMap = new HashMap<>();
		jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(jobParametersMap);
		JobExecution jobExecution = jobLauncher.run(job2, jobParameters);
		
		return "estado job2: " + jobExecution.getStatus().toString();
	}
	
	//*******************************************************************
	
	@RequestMapping("/job3")
	public String job3() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String,JobParameter> jobParametersMap = new HashMap<>();	
		jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(jobParametersMap);
		jobLauncher.run(job3, jobParameters);
		
		return "ok";
	}
	
	//*******************************************************************
	
	// El parámetro llega como "path variable"
	
	@RequestMapping("/job4/{fam}")
	public String job4(@PathVariable ("fam") String familia) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String,JobParameter> jobParametersMap = new HashMap<>();
		jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
		jobParametersMap.put("familia", new JobParameter(familia));
		JobParameters jobParameters = new JobParameters(jobParametersMap);
		jobLauncher.run(job4, jobParameters);
		
		return "ok";
	}
	
	//*******************************************************************
	
		// El parámetro llega como "request parameter"
		
		@RequestMapping("/job4")
		public String job4parameter(@RequestParam ("familia") String familia) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
			
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
			jobParametersMap.put("familia", new JobParameter(familia));
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			jobLauncher.run(job4, jobParameters);
			
			return "ok";
		}
		
	//*******************************************************************	
		
		@RequestMapping("/job6")
		public String job6() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
			
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			jobLauncher.run(job6, jobParameters);
			
			return "ok";
		}
		
	//*******************************************************************
		
		@RequestMapping("/job7")
		public String job7() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
			
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			jobLauncher.run(job7, jobParameters);
			
			return "ok";
		}
		
	//*******************************************************************
		
		@RequestMapping("/job8")
		public String job8() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
			
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));	
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			jobLauncher.run(job8, jobParameters);
			
			return "ok";
		}
	
	

	//*******************************************************************
		
		@RequestMapping("/job10")
		public String job10() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
			
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			jobLauncher.run(job10, jobParameters);
			
			return "ok";
		}
		
		
		@RequestMapping("/job11")
		public String job11() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
					
				Map<String,JobParameter> jobParametersMap = new HashMap<>();
				jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
				JobParameters jobParameters = new JobParameters(jobParametersMap);
				jobLauncher.run(job11, jobParameters);
					
				return "ok";
			}
				
		//*******************************************************************
		
		@RequestMapping("/job12")
		public String job12() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
					
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			jobLauncher.run(job12, jobParameters);
					
			return "ok";
		}
				
	//*******************************************************************
		
		@RequestMapping("/job13")
		public String job13() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
					
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			jobLauncher.run(job13, jobParameters);
					
			return "ok";
		}
		
	//*******************************************************************	
		
		@RequestMapping("/job14")
		public String job14() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
			
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
			
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			
			jobLauncher.run(job14, jobParameters);
			
			return "ok";
		}
		
		
		@RequestMapping("/job15")
		public String job15(@RequestParam(name="fail", 
		                                  required=false, 
		                                  defaultValue="3") String fail) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
			Map<String,JobParameter> jobParametersMap = new HashMap<>();
			jobParametersMap.put("parametro1", new JobParameter("p_" + System.currentTimeMillis()));
			jobParametersMap.put("fail", new JobParameter(fail));
			JobParameters jobParameters = new JobParameters(jobParametersMap);
			jobLauncher.run(job15, jobParameters);
			
			return "ok";
		}
}
