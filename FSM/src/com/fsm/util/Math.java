/**   
* @Title: Math.java 
* @Package com.fsm.util 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016��12��27�� ����4:01:13 
* @version V1.0   
*/
package com.fsm.util;

/** 
* @ClassName: Math 
* @Description: TODO(������һ�仰��������������) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016��12��27�� ����4:01:13 
*  
*/
public class Math {
	public static int clamp(int MIN,int MAX,int current){
		int val=MIN>current?MIN:current;
		val=MAX<current?MAX:current;
		return val;
	}
}
