package com.aiBeginner.state;

import com.aiBeginner.entity.BaseGameEntity;

public interface State {
	public void enter(BaseGameEntity gameEntity);
	public void execute(BaseGameEntity gameEntity);
	public void exit();
}
