/**   
* @Title: EntityManager.java 
* @Package com.fsm.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016年12月27日 上午11:10:44 
* @version V1.0   
*/
package com.fsm.entity;

import java.util.HashMap;
import java.util.Map;
/** 
* @ClassName: EntityManager 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016年12月27日 上午11:10:44 
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
