/**   
* @Title: Telegram.java 
* @Package com.fsm.message 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016年12月27日 上午11:52:01 
* @version V1.0   
*/
package com.fsm.message;

import com.fsm.entity.EntityID;

/** 
* @ClassName: Telegram 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016年12月27日 上午11:52:01 
*  
*/
public class Telegram {
	public EntityID sender;
	public EntityID receiver;
	public MessageType message;
	public ExtraInfo extraInfo;
	public long dispatchTime;
	/**
	 * 
	 */
	public Telegram(EntityID sender,
			EntityID receiver,
			MessageType message,
			ExtraInfo extraInfo,
			long dispatchTime) {
		// TODO Auto-generated constructor stub
		this.sender=sender;
		this.receiver=receiver;
		this.message=message;
		this.extraInfo=extraInfo;
		this.dispatchTime=dispatchTime;
	}
}
