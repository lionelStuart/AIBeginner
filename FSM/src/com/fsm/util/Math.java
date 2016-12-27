/**   
* @Title: Math.java 
* @Package com.fsm.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lisi_stuart https://github.com/lionelStuart   
* @date 2016年12月27日 下午4:01:13 
* @version V1.0   
*/
package com.fsm.util;

/** 
* @ClassName: Math 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016年12月27日 下午4:01:13 
*  
*/
public class Math {
	public static int clamp(int MIN,int MAX,int current){
		int val=MIN>current?MIN:current;
		val=MAX<current?MAX:current;
		return val;
	}
}
