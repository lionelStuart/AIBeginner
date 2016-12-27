package com.aiBeginner.state;

import com.aiBeginner.entity.Miner;

public class GoHomeAndSleepTilRested implements State<Miner>{
	private GoHomeAndSleepTilRested() {
		// TODO Auto-generated constructor stub
	}
	public static GoHomeAndSleepTilRested getInstance() {
		return StateFactory.getInstance(GoHomeAndSleepTilRested.class);
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
