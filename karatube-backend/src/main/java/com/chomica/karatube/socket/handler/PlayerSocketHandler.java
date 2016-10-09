package com.chomica.karatube.socket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.chomica.karatube.constant.KaratubeTopic;
import com.chomica.karatube.socket.message.KaratubeMsg;
import com.chomica.karatube.socket.processor.IKaratubeSocketProcessor;
import com.chomica.karatube.util.JsonUtil;

@Component
public class PlayerSocketHandler extends TextWebSocketHandler {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(PlayerSocketHandler.class);
   
   // ---------------------------------------------------------------
   @Autowired
   @Qualifier("initialEnvProcessor")
   private IKaratubeSocketProcessor<String> initEnvProcessor;
   
   @Autowired
   @Qualifier("getNextSongProcessor")
   private IKaratubeSocketProcessor<String> nextSongProcessor;
   
   // ---------------------------------------------------------------
   private void dispatch(WebSocketSession session, String envId, KaratubeTopic topic, Object msg) {
      switch(topic) {
      case INITIAL_ENV:
         if(msg != null || envId != null) {
            logger.warn("Receive Initial environment request, but msg or envId is not null");
         }
         this.initEnvProcessor.process(session, envId, null);
         break;
      case NEXT_SONG:
         this.nextSongProcessor.process(session, envId, null);
         break;
      default:
         logger.error("Can not find any suitable processor: {}", topic);
         break;
      }
   }
   
   // ---------------------------------------------------------------
   @Override
   public void handleTextMessage(WebSocketSession session, TextMessage msg) throws Exception {
      logger.info("Receive WebSocket message: {}", msg.getPayload());
      KaratubeMsg<?> request = JsonUtil.readJsonToObject(msg.getPayload(), KaratubeMsg.class);
      String envId = request.getId();
      KaratubeTopic topic = KaratubeTopic.getTopic(request.getTopic());
      this.dispatch(session, envId, topic, request.getMsg());
   }
   
   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
      logger.info("WebSocket[{}] connection closed: {}", session.getId(), closeStatus);
   }
}
