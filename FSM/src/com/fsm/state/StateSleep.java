/**   
* @Title: StateSleep.java 
* @Package com.fsm.state 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016年12月27日 下午3:44:13 
* @version V1.0   
*/
package com.fsm.state;

import com.fsm.entity.Miner;
import com.fsm.message.MessageDispatcher;
import com.fsm.message.MessageType;
import com.fsm.message.Telegram;

/** 
* @ClassName: StateSleep 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016年12月27日 下午3:44:13 
*  
*/
public class StateSleep implements State<Miner> {

	/* (non-Javadoc)
	 * @see com.fsm.state.State#enter(com.fsm.entity.BaseGameEntity)
	 */
	/**
	 * 
	 */
	private StateSleep() {
		// TODO Auto-generated constructor stub
	}
	public static StateSleep Instance() {
		return StateFactory.getInstance(StateSleep.class);
	}
	@Override
	public void enter(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString()+" goes to bed");
	}

	/* (non-Javadoc)
	 * @see com.fsm.state.State#execute(com.fsm.entity.BaseGameEntity)
	 */
	@Override
	public void execute(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString()+" take Sleep");
		gameEntity.addHealth(-10);
		gameEntity.addStrengh(10);
		if(gameEntity.isUrgent())
			MessageDispatcher.dispatchMessage(gameEntity.getEntityID(), gameEntity.getEntityID(), MessageType.MSG_PEE, null, 0);
		if(gameEntity.getStrength()>90)
			MessageDispatcher.dispatchMessage(gameEntity.getEntityID(), gameEntity.getEntityID(), MessageType.MSG_WORK, null, 0);
	}

	/* (non-Javadoc)
	 * @see com.fsm.state.State#exit(com.fsm.entity.BaseGameEntity)
	 */
	@Override
	public void exit(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString()+" wakes up");
	}

	/* (non-Javadoc)
	 * @see com.fsm.state.State#equals(com.fsm.state.State)
	 */
	@Override
	public boolean equals(State<Miner> state) {
		// TODO Auto-generated method stub
		return this.equals(state);
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
		case MSG_WORK:
			owner.getStateMachine().changeState(StateWork.Instance());
			return true;
		default:
			break;
		}
		return false;
	}

}
