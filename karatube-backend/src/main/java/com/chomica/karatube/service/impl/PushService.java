package com.chomica.karatube.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.chomica.karatube.service.IPushService;
import com.chomica.karatube.socket.message.KaratubeMsg;

@Component("pushService")
public class PushService implements IPushService {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(PushService.class);

   // ---------------------------------------------------------------
   @Override
   public void pushMessage(WebSocketSession session, KaratubeMsg<?> msg) {
      try {
         session.sendMessage(new TextMessage(String.valueOf(msg)));
      } catch (IOException e) {
         logger.error("Send message to player {} failed: {}", msg.getId(), e);
      }
   }
}
