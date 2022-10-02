package com.pbburnham3.zookeeper;

public class Bat extends Mammal{
	
	public Bat() {
		super();
		this.energyLevel = 300;
	}
	
	
	
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("I am the night - WOOOOSH!");
	}
	
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("The bat is attacking a nearby town - OH, THE HUMANITY!");
	}
	
	public void eatHuman() {
		this.energyLevel += 25;
		System.out.println("That bat is eating her - then, it's going to eat me! oooh myyy gooood!!");
	}

}
