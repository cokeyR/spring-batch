package batch.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import batch.tasklet.HelloWorldTaskLet;

public class ChunkDemo {

	public static void main(String[] args) throws Exception {
		//jobRepository  和    transactionManager
				JobRepository jobRepository = new MapJobRepositoryFactoryBean().getObject();
				PlatformTransactionManager transactionManager=new ResourcelessTransactionManager();
				
				//step
				StepBuilderFactory stepBuilderFactory=new StepBuilderFactory(jobRepository, transactionManager);
				StepBuilder stepBuilder=stepBuilderFactory.get("hello,stepBuilder");
				Step step=stepBuilder.tasklet(new HelloWorldTaskLet())
						.build();
				
				//job
				JobBuilderFactory jobBuilderFactory=new JobBuilderFactory(jobRepository);
				JobBuilder jobBuilder=jobBuilderFactory.get("hello,jobBuilder");
				Job job=jobBuilder.start(step)
						.next(step)
						.build();
				
				//launcher
				SimpleJobLauncher jobLauncher=new SimpleJobLauncher();
				jobLauncher.setJobRepository(jobRepository);
				jobLauncher.setTaskExecutor(new SyncTaskExecutor());
				jobLauncher.run(job, new JobParameters());
	}
}
