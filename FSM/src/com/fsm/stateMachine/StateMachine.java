/**   
* @Title: StateMachine.java 
* @Package com.fsm.stateMachine 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016年12月27日 上午10:06:21 
* @version V1.0   
*/
package com.fsm.stateMachine;

import com.fsm.entity.BaseGameEntity;
import com.fsm.message.Telegram;
import com.fsm.state.State;

/**
 * @ClassName: StateMachine
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2016年12月27日 上午10:06:21
 * 
 */
public class StateMachine<T extends BaseGameEntity> {
	private T owner;

	private State<T> currentState;
	private State<T> previousState;
	private State<T> globalState;

	public StateMachine(T owner) {
		// TODO Auto-generated constructor stub
		this.owner = owner;
		this.currentState = null;
		this.previousState = null;
		this.globalState = null;
	}

	public void setCurrentState(State<T> currentState) {
		this.currentState = currentState;
	}

	public void setPreviousState(State<T> previousState) {
		this.previousState = previousState;
	}

	public void setGlobalState(State<T> globalState) {
		this.globalState = globalState;
	}

	public final State<T> getCurrentState() {
		return currentState;
	}

	public final State<T> getPreviousState() {
		return previousState;
	}

	public final State<T> getGlobalState() {
		return globalState;
	}
	
	public void update() {
		if (this.globalState != null){
//			System.out.println("handle global");
			globalState.execute(owner);
		}

		if (this.currentState != null){
//			System.out.println("handle currentSate");
			currentState.execute(owner);
		}
	}
	public void changeState(State<T> newState){
		if(newState==null)return;
		previousState=currentState;
		currentState.exit(owner);
		currentState=newState;
		currentState.enter(owner);
	}
	public void revertToPreviousState(){
		changeState(previousState);
	}
	public boolean handleMessage(Telegram msg){
		if(currentState!=null&&currentState.onMessage(owner,msg)){
			return true;
		}
		if(globalState!=null&&globalState.onMessage(owner,msg)){
			return true;
		}
		return false;
	}
}
