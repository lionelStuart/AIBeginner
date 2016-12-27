package com.aiBeginner.entity;

import com.aiBeginner.state.EnterMineAndDigForNugget;
import com.aiBeginner.state.State;

public class Miner extends BaseGameEntity {
	private static final String TAG = Miner.class.getName();

	public static int MAX_THIRST_VALUE = 10;
	public static int MAX_GOLD_CARRIED = 5;
	public static int MAX_STRENGTH_VALUE = 10;

	private State currentState;

	private LocationType locationType;

	private int goldCarried;
	private int moneyInBank;
	int thirstValue;
	int strengthValue;
	
	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	public int getGoldCarried() {
		return goldCarried;
	}

	public void setGoldCarried(int goldCarried) {
		this.goldCarried = goldCarried;
	}

	public void addGoldCarried(int amount) {
		this.goldCarried += amount;
	}

	public boolean isPocketFull(){
		if(this.goldCarried>MAX_GOLD_CARRIED)
			this.setGoldCarried(MAX_GOLD_CARRIED);
		return this.goldCarried>=MAX_GOLD_CARRIED;
	}
	
	public int getMoneyInBank() {
		return moneyInBank;
	}

	public void setMoneyInBank(int moneyInBank) {
		this.moneyInBank = moneyInBank;
	}

	public void addMoneyInBank(int amount) {
		this.moneyInBank += amount;
	}

	public int getThirstValue() {
		return thirstValue;
	}

	public void setThirstValue(int thirstValue) {
		this.thirstValue = thirstValue;
	}

	public void addThirstValue(int amount) {
		this.thirstValue += amount;
	}
	public boolean isThirsty() {
		if(this.thirstValue>MAX_THIRST_VALUE)
			this.setThirstValue(MAX_THIRST_VALUE);
		return this.thirstValue>=MAX_STRENGTH_VALUE;
	}

	public int getStrengthValue() {
		return strengthValue;
	}

	public void setStrengthValue(int strengthValue) {
		this.strengthValue = strengthValue;
	}
	public boolean isStrenghtOut(){
		if(this.strengthValue>MAX_STRENGTH_VALUE)
			this.setStrengthValue(MAX_STRENGTH_VALUE);
		return this.strengthValue>=MAX_STRENGTH_VALUE;
	}

	public State getCurrentState() {
		return currentState;
	}

	/**
	 * 
	 */
	public Miner() {
		// TODO Auto-generated constructor stub
		init();
	}
	private void init() {
		currentState=EnterMineAndDigForNugget.getInstance();
		this.setGoldCarried(0);
		this.setStrengthValue(0);
		this.setMoneyInBank(0);
		this.setLocationType(LocationType.LOCATION_GOLD_MINE);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		currentState.execute(this);
	}

	public void changeState(State newState) {
		if (currentState == null || newState == null)
			return;
		System.out.println("# state changes from "+currentState.toString());
		currentState.exit(this);
		currentState = newState;
		currentState.enter(this);
		System.out.println("# to "+currentState.toString());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Miner "+getEntityID();
	}
}
