package com.javaspring;

import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
// @ComponentScan("com.javaspring")
public class SportConfig {
	
	@Bean
	public FortuneService sadFortuneService() {// sadFortuneService is the "previous" beanID
		return new SadFortuneService();
	}
	
	
	// define a bean
	@Bean
	// define method to expose bean
	public Coach swimCoach(FortuneService fortuneService) {	// swimCoach is the "previous" beanID
		SwimCoach mySwimCoach = new SwimCoach( sadFortuneService() );
		return mySwimCoach;
	}

}
