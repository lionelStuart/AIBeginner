/**   
* @Title: StatePee.java 
* @Package com.fsm.state 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016年12月27日 下午3:45:50 
* @version V1.0   
*/
package com.fsm.state;

import com.fsm.entity.Miner;
import com.fsm.message.MessageDispatcher;
import com.fsm.message.MessageType;
import com.fsm.message.Telegram;

/** 
* @ClassName: StatePee 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016年12月27日 下午3:45:50 
*  
*/
public class StatePee implements State<Miner> {

	/* (non-Javadoc)
	 * @see com.fsm.state.State#enter(com.fsm.entity.BaseGameEntity)
	 */
	/**
	 * 
	 */
	private StatePee() {
		// TODO Auto-generated constructor stub
	}
	public static StatePee Instance() {
		return StateFactory.getInstance(StatePee.class);
	}
	@Override
	public void enter(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString()+" goes to toliet");
	}

	/* (non-Javadoc)
	 * @see com.fsm.state.State#execute(com.fsm.entity.BaseGameEntity)
	 */
	@Override
	public void execute(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString()+" pees");
		gameEntity.addHealth(100);
		MessageDispatcher.dispatchMessage(gameEntity.getEntityID(), gameEntity.getEntityID(),MessageType.MSG_PREVIOUS,null,200);
	}

	/* (non-Javadoc)
	 * @see com.fsm.state.State#exit(com.fsm.entity.BaseGameEntity)
	 */
	@Override
	public void exit(Miner gameEntity) {
		// TODO Auto-generated method stub
		System.out.println(gameEntity.toString()+" leaves the toliet");
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
		switch (msg.message){
		case MSG_PREVIOUS:
			owner.getStateMachine().revertToPreviousState();
			return true;
		default:
			break;
		}
		return false;
	}

}
