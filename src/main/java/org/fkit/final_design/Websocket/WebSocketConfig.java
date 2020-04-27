package org.fkit.final_design.Websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig 
{
	@Bean
    public ServerEndpointExporter serverEndpointExporter()
	{
        return new ServerEndpointExporter();
    }
}
//https://blog.csdn.net/weixin_42047790/article/details/84840695