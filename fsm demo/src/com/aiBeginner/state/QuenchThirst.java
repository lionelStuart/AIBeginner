package com.aiBeginner.state;

import com.aiBeginner.entity.Miner;

public class QuenchThirst implements State<Miner>{
	private QuenchThirst () {
		
	}
	public static QuenchThirst getInstance() {
		return StateFactory.getInstance(QuenchThirst.class);
	}
	@Override
	public void enter(Miner miner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Miner miner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit(Miner miner) {
		// TODO Auto-generated method stub
		
	}

}
