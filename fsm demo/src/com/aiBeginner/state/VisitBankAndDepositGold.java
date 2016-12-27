package com.aiBeginner.state;

import com.aiBeginner.entity.Miner;

public class VisitBankAndDepositGold implements State<Miner> {
	private VisitBankAndDepositGold() {
		// TODO Auto-generated constructor stub
	}
	public static VisitBankAndDepositGold getInstance() {
		return StateFactory.getInstance(VisitBankAndDepositGold.class);
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
