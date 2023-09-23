package br.com.ada.cielo.primeirodesafio.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
	
	@Bean(name = "taskExecutor")
	TaskExecutor  taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(4); 
	    executor.setMaxPoolSize(10); 
	    executor.setQueueCapacity(20); 
	    return executor;
	}
	
}
