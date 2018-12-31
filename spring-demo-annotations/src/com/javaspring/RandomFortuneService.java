package com.javaspring;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {"you are the best", "take your time", "follow your heart"};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int randIndex = myRandom.nextInt(data.length);
		return data[randIndex];
	}

}
