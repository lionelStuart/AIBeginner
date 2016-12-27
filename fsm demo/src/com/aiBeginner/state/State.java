package com.aiBeginner.state;

import com.aiBeginner.entity.BaseGameEntity;

public interface State<T extends BaseGameEntity> {
	public void enter(T gameEntity);

	public void execute(T gameEntity);

	public void exit(T gameEntity);
}
