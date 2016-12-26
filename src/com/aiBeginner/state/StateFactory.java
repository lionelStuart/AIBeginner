package com.aiBeginner.state;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class StateFactory {
	private static final Map<String, State> states=new HashMap<String,State>();
	
	@SuppressWarnings("unchecked")
	public static <T extends State>T createInstance(Class<T> state){
		State returnState=null;
		String stateName;
		stateName=state.getName();
		try{
			if(!states.containsKey(stateName)){
				Class<?> class1=Class.forName(stateName);
				Constructor<?> constructor=class1.getDeclaredConstructor();
				constructor.setAccessible(true);
				returnState=(State)constructor.newInstance();
				states.put(stateName, returnState);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return (T)states.get(stateName);
	}
}
