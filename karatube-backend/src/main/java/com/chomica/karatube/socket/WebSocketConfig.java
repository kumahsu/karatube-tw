package com.chomica.karatube.socket;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.chomica.karatube.socket.handler.PlayerSocketHandler;

@Component
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
   // ---------------------------------------------------------------
   @Resource
   private PlayerSocketHandler handler;
   
   // ---------------------------------------------------------------
   @Override
   public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
      registry.addHandler(this.handler, "/ws/player");
      registry.addHandler(this.handler, "/sockjs/player").withSockJS();
   }
}
