package com.aiBeginner.state;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/** 
* @ClassName: StateFactory 
* @Description: TODO(单例模式生成State对象) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016年12月26日 下午3:08:22 
*  
*/
public class StateFactory {
	private static final Map<String, State> states=new HashMap<String,State>();
	//单例模式的缺陷是所有对象共享同一份状态实例，无法存储属于单个状态的局部信息
	/**
	 * @param state 已经实现的有限状态机类
	 * @return 返回该类的实例
	 */
	public static <T extends State>T getInstance(Class<T> state){
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
