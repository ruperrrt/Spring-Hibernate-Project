package com.javaspring;

import org.springframework.stereotype.Component;

@Component
public class databaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Database fortune service!";
	}

}
