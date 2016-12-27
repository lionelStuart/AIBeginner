package com.aiBeginner.state;

import com.aiBeginner.entity.Miner;

public class EnterMineAndDigForNugget implements State<Miner> {
	private EnterMineAndDigForNugget() {
		// TODO Auto-generated constructor stub
		
	}
	public static EnterMineAndDigForNugget getInstance() {
		return StateFactory.getInstance(EnterMineAndDigForNugget.class);
	}
	@Override
	public void enter(Miner miner) {
		// TODO Auto-generated method stub
		System.out.println("miner "+miner.getEntityID()+" enters the mine");
	}

	@Override
	public void execute(Miner miner) {
		// TODO Auto-generated method stub
		miner.addGoldCarried(1);
		miner.addThirstValue(1);
		System.out.println("miner "+miner.getEntityID()+" PocketGold: "+miner.getGoldCarried()+ 
				" thirstValue: "+miner.getThirstValue());
		if(miner.isPocketFull()){
			miner.changeState(VisitBankAndDepositGold.getInstance());
		}
		if(miner.isThirsty()){
			miner.changeState(QuenchThirst.getInstance());
		}
	}

	@Override
	public void exit(Miner miner) {
		// TODO Auto-generated method stub
		System.out.println("miner "+miner.getEntityID()+" leaves the mine");
	}

}
