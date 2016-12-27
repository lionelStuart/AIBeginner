/**   
* @Title: testMain.java 
* @Package com.fsm.test 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016��12��27�� ����11:34:40 
* @version V1.0   
*/
package com.fsm.test;

import com.fsm.entity.Miner;
import com.fsm.message.MessageDispatcher;

import java.util.Date;

import com.fsm.entity.EntityID;
import com.fsm.entity.EntityManager;

/** 
* @ClassName: testMain 
* @Description: TODO(������һ�仰��������������) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016��12��27�� ����11:34:40 
*  
*/
public class testMain {
	public static void main(String[] args) {
		EntityManager entityManager=EntityManager.Instance();
		Miner minerBob=new Miner(EntityID.ENT_MINER_BOB);
		Miner minerSam=new Miner(EntityID.ENT_MINER_SAM);
		entityManager.register(minerBob);
		entityManager.register(minerSam);
		long runningtime=5000;
		long currentTime=new Date().getTime();
		while(new Date().getTime()<currentTime+runningtime){
			try{
				Thread.currentThread().sleep(50);
				minerBob.update();
				MessageDispatcher.dispatchDelayedMessage();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
