package com.pbburnham3.zookeeper;

public class MammalTest {

	public static void main(String[] args) {
		
		System.out.println("===ZooKeeper V1===");
		
		Gorilla g1 = new Gorilla();
		
		g1.displayEnergy();
		
		g1.throwSomething();
		g1.throwSomething();
		g1.throwSomething();
		
		g1.displayEnergy();
		
		g1.eatBanana();
		g1.eatBanana();
		
		g1.displayEnergy();
		
		g1.climb();
		
		g1.displayEnergy();
		
		Bat b1 = new Bat();
		
		b1.displayEnergy();
		
		b1.attackTown();
		b1.attackTown();
		b1.attackTown();
		
		b1.displayEnergy();
		
		b1.eatHuman();
		b1.eatHuman();
		
		b1.displayEnergy();
		
		b1.fly();
		b1.fly();
		
		b1.displayEnergy();
		
		
		
	}

}
