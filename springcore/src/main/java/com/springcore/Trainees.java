package com.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Trainees {
	
	private TrainerInterface ti;
	
	public void print() {
		ti.teach();
	}

	public TrainerInterface getTi() {
		return ti;
	}

	public void setTi(TrainerInterface ti) {
		this.ti = ti;
	}


	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("abc.xml");
		Trainees t = (Trainees) ctx.getBean("trainees");
		t.print();
		
//		Trainees t = new Trainees();
//		t.setTi(new Trainer());
//		t.print();
	}

}
