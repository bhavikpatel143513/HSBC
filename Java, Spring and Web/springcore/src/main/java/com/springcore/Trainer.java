package com.springcore;

import org.springframework.stereotype.Component;

@Component("trainer")
public class Trainer implements TrainerInterface {

	public void teach() {
		System.out.println("Teaching the students!!");
		
	}

}
