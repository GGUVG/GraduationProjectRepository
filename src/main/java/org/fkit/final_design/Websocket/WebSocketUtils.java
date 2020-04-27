package org.fkit.final_design.Websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;


public class WebSocketUtils {
	public static final Map<String, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap<>();
	/*
	 * 在创建服务端消息接收功能之前，我们先创建一个 WebSocketUtils 工具类，用来存储聊天室在线的用户信息，
	 * 以及发送消息的功能。首先定义一个全局变量 ONLINE_USER_SESSIONS 用来存储在线用户，
	 * 使用 ConcurrentHashMap 提升高并发时效率。
	 */
	
	public static void sendMessage(Session session, String message) 
	{
	    if (session == null) {
	        return;
	    }
	    final RemoteEndpoint.Basic basic = session.getBasicRemote();
	    if (basic == null) {
	        return;
	    }
	    try {
	        basic.sendText(message);
	    } catch (IOException e) {}
	}
	/*
	 * 封装消息发送方法，在发送之前首先判单用户是否存在再进行发送：
	 */
	
	public static void sendMessageAll(String message)
	{
	    ONLINE_USER_SESSIONS.forEach((sessionId, session) -> sendMessage(session, message));
	}
	/*
	 * 其中，ONLINE_USER_SESSIONS.forEach((sessionId, session) -> sendMessage(session, message)) 
	 * 是 JDK 1.8 forEach 的简洁写法。
	 */
	
	
	
}

	