package com.fsm.entity;

import java.util.ArrayList;

import com.fsm.message.Telegram;
import com.fsm.state.State;
import com.fsm.state.StateSleep;
import com.fsm.stateMachine.StateMachine;
import com.fsm.util.Math;

public class Miner extends BaseGameEntity {
	private static final String TAG = Miner.class.getName();

	ArrayList<State<Miner>> states=new ArrayList<>();
	
	private StateMachine<Miner> stateMachine;


	public static final int STRENGTH_MAX= 100;
	public static final int HEALTH_MAX=100;
	
	private int strength;

	private int health;

	public Miner(EntityID entityID) {
		// TODO Auto-generated constructor stub
		super(entityID);
		init();
	}
	public final StateMachine<Miner> getStateMachine() {
		return stateMachine;
	}
	public final int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = Math.clamp(0, STRENGTH_MAX, strength);
	}
	public final int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = Math.clamp(0, HEALTH_MAX, health);
	}
	public void addHealth(int amount) {
		this.setHealth(amount+this.health);
	}
	public void addStrengh(int amount){
		this.setStrength(amount+this.strength);
	}
	public boolean isTired(){
		return this.strength<1;
	}
	public boolean isUrgent() {
		return this.health<1;
	}
	private void init() {
		setHealth(90);
		setStrength(90);
		stateMachine=new StateMachine<Miner>(this);
		stateMachine.setCurrentState(StateSleep.Instance());
		stateMachine.setGlobalState(null);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		currentState();
		stateMachine.update();
		
	}
	
	/* (non-Javadoc
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return TAG+"  "+getEntityID();
	}
	public void currentState() {
		System.out.println(toString()+"\thealth: "+getHealth()+"\tstrength"+getStrength());
		System.err.println(toString()+"\tcurrentState: "+getStateMachine().getCurrentState().toString());
	}
	/* (non-Javadoc)
	 * @see com.fsm.entity.BaseGameEntity#handleMessage(com.fsm.message.Telegram)
	 */
	@Override
	public boolean handleMessage(Telegram msg) {
		// TODO Auto-generated method stub
		return stateMachine.handleMessage(msg);			
	}

}
