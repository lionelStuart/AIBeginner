package com.aiBeginner.entity;

public abstract class BaseGameEntity {
	private static int nextEntityID = 0;
	private int entityID;

	private static int generateEntityID() {
		return nextEntityID++;
	}

	public int getEntityID() {
		return entityID;
	}
	
	public BaseGameEntity() {
		// TODO Auto-generated constructor stub
		this.entityID = generateEntityID();
	}
	
	public abstract void update();
}
