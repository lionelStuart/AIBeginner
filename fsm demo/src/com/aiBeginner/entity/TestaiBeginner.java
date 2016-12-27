package com.aiBeginner.entity;

public class TestaiBeginner {
	public static void main(String[] args) {
		Miner miner=new Miner();
		for(int i=0;i!=120;i++)
		miner.update();
		Miner miner2=new Miner();
		miner2.update();
	}
}
