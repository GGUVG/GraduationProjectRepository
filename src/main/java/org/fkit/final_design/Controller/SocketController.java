package org.fkit.final_design.Controller;
import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.fkit.final_design.Websocket.WebSocketUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
@Controller
@ServerEndpoint("/chat-room/{username}")
//接收类上需要添加 @ServerEndpoint("url") 代表监听此地址的 WebSocket信息
public class SocketController {
	@OnOpen
	public void openSession(@PathParam("username") String username, Session session) {
		WebSocketUtils.ONLINE_USER_SESSIONS.put(username, session);
	    String message = "欢迎用户[" + username + "] 来到聊天室！";
	    //logger.info("用户登录："+message);
	    System.out.println("用户登录："+message);
	    WebSocketUtils.sendMessageAll(message);
	}
	/*
	 * 用户登录聊天室时，将用户信息添加到 ONLINE_USER_SESSIONS 中，
	 * 同时通知聊天室中的人。其中，@OnOpen 
	 * 注解和前端的 onopen 事件一致，表示用户建立连接时触发。
	 */
	
	@OnMessage
	public void onMessage(@PathParam("username") String username, String message) {
	    //logger.info("发送消息："+message);
		System.out.println("发送消息："+message);
	    WebSocketUtils.sendMessageAll("用户[" + username + "] : " + message);
	}
	/*
	 * 当聊天室某个用户发送消息时，将此消息同步给聊天室所有人。其中，@OnMessage 监听发送消息的事件。
	 */
	
	
	@OnClose
	public void onClose(@PathParam("username") String username, Session session) {
	    //当前的Session 移除
		WebSocketUtils.ONLINE_USER_SESSIONS.remove(username);
	    //并且通知其他人当前用户已经离开聊天室了
		WebSocketUtils.sendMessageAll("用户[" + username + "] 已经离开聊天室了！");
	    try {
	        session.close();
	    } catch (IOException e) {
	        //logger.error("onClose error",e);
	    	System.out.println("onClose error"+e);
	    }
	}
	/*
	 * 当用户离开聊天室后，需要将用户信息从 ONLINE_USER_SESSIONS 移除，
	 * 并且通知到在线的其他用户,其中，@OnClose 监听用户断开连接事件。
	 */
	
	@OnError
	public void onError(Session session, Throwable throwable) {
	    try {
	        session.close();
	    } catch (IOException e) {
	        //logger.error("onError excepiton",e);
	    	System.out.println("onError excepiton"+e);
	    }
	    //logger.info("Throwable msg "+throwable.getMessage());
	    System.out.println("Throwable msg "+throwable.getMessage());
	}
	/*
	 * 当 WebSocket 连接出现异常时，出触发 @OnError 事件，可以在此方法内记录下错误的异常信息，并关闭用户连接。
	 */
	
	//多个房间参考https://www.cnblogs.com/gaby-gl/articles/9765013.html

}
