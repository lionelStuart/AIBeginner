package com.fsm.entity;

import com.fsm.message.Telegram;

public abstract class BaseGameEntity {
	private EntityID entityID;

	public EntityID getEntityID() {
		return entityID;
	}
	
	public BaseGameEntity(EntityID entityID) {
		// TODO Auto-generated constructor stub
		this.entityID = entityID;
	}
	
	public abstract void update();
	public abstract boolean handleMessage(Telegram msg);
}
