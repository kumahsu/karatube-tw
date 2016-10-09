package com.chomica.karatube.socket.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import com.chomica.karatube.constant.KaratubeTopic;
import com.chomica.karatube.model.vo.EnvironmentVO;
import com.chomica.karatube.service.IEnvService;
import com.chomica.karatube.service.IPushService;
import com.chomica.karatube.socket.message.InitialEnvRespMsg;
import com.chomica.karatube.socket.message.KaratubeMsg;

@Component("initialEnvProcessor")
public class InitialEnvProcessor implements IKaratubeSocketProcessor<String> {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(InitialEnvProcessor.class);
   
   // ---------------------------------------------------------------
   @Autowired
   private IEnvService envService;
   
   @Autowired
   private IPushService pushService;
   
   // ---------------------------------------------------------------
   @Override
   public void process(WebSocketSession session, String envId, String msg) {
      logger.debug("Process Initial Env request: {}", msg);
      EnvironmentVO env = this.envService.createEnv(session);
      logger.debug("Environment created: {}", env);
      InitialEnvRespMsg data = new InitialEnvRespMsg(env.getId(), env.getPairCode());
      KaratubeMsg<InitialEnvRespMsg> resp = new KaratubeMsg<InitialEnvRespMsg>(env.getId(), KaratubeTopic.INITIAL_ENV, data);
      logger.debug("Send Initial Env resposne: {}", resp);
      this.pushService.pushMessage(session, resp);
   }
}
