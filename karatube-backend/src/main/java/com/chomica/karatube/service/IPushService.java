package com.chomica.karatube.service;

import org.springframework.web.socket.WebSocketSession;

import com.chomica.karatube.socket.message.KaratubeMsg;

public interface IPushService {
   // ---------------------------------------------------------------
   public void pushMessage(WebSocketSession session, KaratubeMsg<?> msg);
}
