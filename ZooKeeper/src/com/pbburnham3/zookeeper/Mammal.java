package com.pbburnham3.zookeeper;

class Mammal{
	
    protected int energyLevel;
    
    public Mammal() {
    	this.energyLevel = 100;
    }
    
    public int displayEnergy() {
    	System.out.println("My energy level is: " + energyLevel);
    	return energyLevel;
    }
    
}


