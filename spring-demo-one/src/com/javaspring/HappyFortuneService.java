package com.javaspring;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You should try your best!";
	}

}
