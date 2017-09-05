package com.asiaInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author wuxw
 * @version 1.0.0
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling//任务调度
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
