package com.fsm.state;

import com.fsm.entity.BaseGameEntity;
import com.fsm.message.MessageType;
import com.fsm.message.Telegram;

public interface State<T extends BaseGameEntity> {
	public void enter(T gameEntity);

	public void execute(T gameEntity);

	public void exit(T gameEntity);
	
	boolean equals(State<T> state);
	
	boolean onMessage(T owner,Telegram message);
}
