package com.aiBeginner.state;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/** 
* @ClassName: StateFactory 
* @Description: TODO(����ģʽ����State����) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016��12��26�� ����3:08:22 
*  
*/
public class StateFactory {
	private static final Map<String, State> states=new HashMap<String,State>();
	//����ģʽ��ȱ�������ж�����ͬһ��״̬ʵ�����޷��洢���ڵ���״̬�ľֲ���Ϣ
	/**
	 * @param state �Ѿ�ʵ�ֵ�����״̬����
	 * @return ���ظ����ʵ��
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
