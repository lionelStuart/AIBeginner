/**   
* @Title: MessageDispatcher.java 
* @Package com.fsm.message 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016年12月27日 上午11:43:56 
* @version V1.0   
*/
package com.fsm.message;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fsm.entity.BaseGameEntity;
import com.fsm.entity.EntityID;
import com.fsm.entity.EntityManager;

/**
 * @ClassName: MessageDispatcher
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2016年12月27日 上午11:43:56
 * 
 */
public class MessageDispatcher {

	static private Set<Telegram> DelayTelegrams = new HashSet<>();

	static MessageDispatcher messageDispatcher = new MessageDispatcher();

	private MessageDispatcher() {
		// TODO Auto-generated constructor stub
	}

	private static void discharge(BaseGameEntity receiver, Telegram message) {
		receiver.handleMessage(message);
	}

	public static void dispatchMessage(EntityID sender, EntityID receiver, MessageType msg, ExtraInfo extraInfo,
			long delayTime) {
		BaseGameEntity recevierEntity = EntityManager.Instance().getEntityByID(receiver);
		if (recevierEntity == null)
			return;
		long currentTime = new Date().getTime();
		Telegram telegram = new Telegram(sender, receiver, msg, extraInfo, currentTime);
		if (delayTime <= 0) {
			discharge(recevierEntity, telegram);
		} else {
			telegram.dispatchTime += delayTime;
			DelayTelegrams.add(telegram);
		}
	}

	public static void dispatchDelayedMessage() {
		long currentTime = new Date().getTime();
		for (Telegram telegram : DelayTelegrams) {
			if (telegram.dispatchTime >= currentTime)
				discharge(EntityManager.Instance().getEntityByID(telegram.receiver), telegram);
			DelayTelegrams.remove(telegram);
		}
	}
}
