package com.springcore;

import org.springframework.stereotype.Component;

@Component("trainer1")
public class Trainer1 implements TrainerInterface {

	public void teach() {
		System.out.println("Teaching the kids!!");
	}

}
