/**   
* @Title: StateWork.java 
* @Package com.fsm.state 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016年12月27日 下午3:44:53 
* @version V1.0   
*/
package com.fsm.state;

import com.fsm.entity.Miner;
import com.fsm.message.MessageDispatcher;
import com.fsm.message.MessageType;
import com.fsm.message.Telegram;

/**
 * @ClassName: StateWork
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2016年12月27日 下午3:44:53
 * 
 */
public class StateWork implements State<Miner> {

	/**
	 * 
	 */
	private StateWork() {
		// TODO Auto-generated constructor stub
	}

	public static StateWork Instance() {
		return StateFactory.getInstance(StateWork.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsm.state.State#enter(com.fsm.entity.BaseGameEntity)
	 */
	@Override
	public void enter(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString() + " goes to mine");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsm.state.State#execute(com.fsm.entity.BaseGameEntity)
	 */
	@Override
	public void execute(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString() + " at work");
		gameEntity.addHealth(-10);
		gameEntity.addStrengh(-5);
		if (gameEntity.isTired()) {
			MessageDispatcher.dispatchMessage(gameEntity.getEntityID(), gameEntity.getEntityID(), MessageType.MSG_SLEEP,
					null, 0);
		}
		if (gameEntity.isUrgent()) {
			MessageDispatcher.dispatchMessage(gameEntity.getEntityID(), gameEntity.getEntityID(), MessageType.MSG_PEE,
					null, 0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsm.state.State#exit(com.fsm.entity.BaseGameEntity)
	 */
	@Override
	public void exit(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString() + " leaves mine");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fsm.state.State#equals(com.fsm.state.State)
	 */
	@Override
	public boolean equals(State<Miner> state) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.fsm.state.State#onMessage(com.fsm.message.MessageType)
	 */
	@Override
	public boolean onMessage(Miner owner,Telegram msg) {
		// TODO Auto-generated method stub
		switch (msg.message) {
		case MSG_PEE:
			owner.getStateMachine().changeState(StatePee.Instance());
			return true;
		case MSG_SLEEP:
			owner.getStateMachine().changeState(StateSleep.Instance());
			return true;
		default:
			break;
		}
		return false;
	}

}
