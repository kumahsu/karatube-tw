package com.chomica.karatube.socket.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import com.chomica.karatube.constant.KaratubeTopic;
import com.chomica.karatube.model.http.SongDetail;
import com.chomica.karatube.model.vo.EnvironmentVO;
import com.chomica.karatube.model.vo.SongVO;
import com.chomica.karatube.service.IEnvService;
import com.chomica.karatube.service.IPushService;
import com.chomica.karatube.socket.message.KaratubeMsg;

@Component("getNextSongProcessor")
public class GetNextSongProcessor implements IKaratubeSocketProcessor<String> {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(GetNextSongProcessor.class);
   
   // ---------------------------------------------------------------
   @Autowired
   @Qualifier("envService")
   private IEnvService envService;
   
   @Autowired
   @Qualifier("pushService")
   private IPushService pushService;
   
   // ---------------------------------------------------------------
   @Override
   public void process(WebSocketSession session, String envId, String msg) {
      logger.debug("Receive get next song request: {}", msg);
      if(envId == null) {
         
      }
      EnvironmentVO env = this.envService.getEnv(envId);
      SongVO song = env.getPlaylist().pop();
      KaratubeMsg<SongDetail> resp = new KaratubeMsg<SongDetail>(envId, KaratubeTopic.SUCCESS, song == null? null : song.adaptor().toHttpModel());
      this.pushService.pushMessage(session, resp);
      if(song == null) {
         env.idle();
         KaratubeMsg<String> cmd = new KaratubeMsg<>(envId, KaratubeTopic.WAIT, null);
         this.pushService.pushMessage(session, cmd);
      }
   }

}
