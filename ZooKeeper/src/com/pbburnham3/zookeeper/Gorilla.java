package com.pbburnham3.zookeeper;

public class Gorilla extends Mammal{
	
	public Gorilla() {
		super();
	}
	
	
	
	public void throwSomething() {
		this.energyLevel -= 5;
		System.out.println("The gorilla is pleased after throwing something.");
	}
	
	public void climb() {
		this.energyLevel -= 10;
		System.out.println("The gorilla is even MORE pleased after climbing a tree.");
	}
	
	public void eatBanana() {
		this.energyLevel += 10;
		System.out.println("The gorilla has eaten a banana.");
	}

}
