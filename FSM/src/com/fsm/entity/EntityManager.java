/**   
* @Title: EntityManager.java 
* @Package com.fsm.entity 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016��12��27�� ����11:10:44 
* @version V1.0   
*/
package com.fsm.entity;

import java.util.HashMap;
import java.util.Map;
/** 
* @ClassName: EntityManager 
* @Description: TODO(������һ�仰��������������) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016��12��27�� ����11:10:44 
*  
*/
public class EntityManager {
	static EntityManager manager=new EntityManager();
	private static Map<EntityID, BaseGameEntity> entityMap=new HashMap<>();
	/**
	 * 
	 */
	private EntityManager() {
		// TODO Auto-generated constructor stub
	}
	public static EntityManager Instance(){
		return manager;
	}
	
	public void register(BaseGameEntity gameEntity) {
		if(entityMap.containsKey(gameEntity.getEntityID()))return;
		entityMap.put(gameEntity.getEntityID(), gameEntity);
	}
	
	public BaseGameEntity getEntityByID(EntityID entityID) {
		return entityMap.get(entityID);
	}
}
