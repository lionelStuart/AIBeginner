package com.aiBeginner.entity;

import com.aiBeginner.state.State;

public class Miner extends BaseGameEntity {
	private static final String TAG = Miner.class.getName();

	private State currentState;
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("class " + TAG + "object ID:" + getEntityID());
	}
		
	public void changeState(State newState) {
		
	}
}
