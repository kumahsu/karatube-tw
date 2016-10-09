package com.chomica.karatube.socket.processor;

import org.springframework.web.socket.WebSocketSession;

public interface IKaratubeSocketProcessor<T> {
   // ---------------------------------------------------------------
   public void process(WebSocketSession session, String envId, T msg);
}
