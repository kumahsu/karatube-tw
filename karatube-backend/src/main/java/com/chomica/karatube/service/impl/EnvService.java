package com.chomica.karatube.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import com.chomica.karatube.constant.KaratubeTopic;
import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.exception.BadRequestFieldException;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.vo.EnvironmentVO;
import com.chomica.karatube.model.vo.PlaylistQueueVO;
import com.chomica.karatube.model.vo.SongVO;
import com.chomica.karatube.service.IEnvService;
import com.chomica.karatube.service.IPushService;
import com.chomica.karatube.socket.message.KaratubeMsg;

@Component("envService")
public class EnvService implements IEnvService {
   // ---------------------------------------------------------------
   private static final Map<String, EnvironmentVO> ENVS = new HashMap<String, EnvironmentVO>();;
   private static final Map<String, String> PAIRS = new HashMap<String, String>();

   // ---------------------------------------------------------------
   @Autowired
   private IPushService pushService;
   
   // ---------------------------------------------------------------
   @Override
   public EnvironmentVO createEnv(WebSocketSession session) {
      String envId = UUID.randomUUID().toString();
      String pairCode = "0000";
      EnvironmentVO env = new EnvironmentVO(envId, pairCode, session);
      ENVS.put(envId, env);
      PAIRS.put(pairCode, envId);
      return env;
   }

   @Override
   public String getPairEnv(String pairCode) {
      if(!PAIRS.containsKey(pairCode)) {
         throw new BadRequestFieldException(StatusCode.INVALID_FIELD, "pair_code");
      }
      String envId = PAIRS.get(pairCode);
      ENVS.get(envId).clearPairCode();
      PAIRS.remove(pairCode);
      return envId;
   }

   @Override
   public EnvironmentVO getEnv(String envId) {
      if(!ENVS.containsKey(envId)) {
         throw new BadRequestFieldException(StatusCode.INVALID_FIELD, "env_id");
      }
      return ENVS.get(envId);
   }

   @Override
   public void addSong(EnvironmentVO env, SongVO song) {
      PlaylistQueueVO playlist = env.getPlaylist();
      playlist.push(song);
   }

   @Override
   public QueryListData<SongVO> getPlayList(EnvironmentVO env, Integer index, Integer size) {
      PlaylistQueueVO playlist = env.getPlaylist();
      List<SongVO> list = playlist.getSongs(index, size);
      int totalCount = playlist.size();
      int resultSize = list.size();
      return new QueryListData<SongVO>(resultSize, totalCount, index, list);
   }

   @Override
   public QueryListData<SongVO> getHistory(EnvironmentVO env, Integer index, Integer size) {
      PlaylistQueueVO history = env.getHistory();
      List<SongVO> list = history.getSongs(index, size);
      int totalCount = history.size();
      int resultSize = list.size();
      return new QueryListData<SongVO>(resultSize, totalCount, index, list);
   }

   @Override
   public void insertSongToHead(EnvironmentVO env, String songId) {
      PlaylistQueueVO playlist = env.getPlaylist();
      playlist.insert(songId);
   }

   @Override
   public void removeSong(EnvironmentVO env, String songId) {
      PlaylistQueueVO playlist = env.getPlaylist();
      playlist.remove(songId);
   }

   // ---------------------------------------------------------------
   @Override
   public void notifyPlayer(EnvironmentVO env) {
      env.awake();
      KaratubeMsg<String> cmd = new KaratubeMsg<>(env.getId(), KaratubeTopic.NOTIFY, null);
      this.pushService.pushMessage(env.getSession(), cmd);
   }

   @Override
   public void skipSong(EnvironmentVO env) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void restartSong(EnvironmentVO env) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void playPause(EnvironmentVO env) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void enableOrigin(EnvironmentVO env) {
      // TODO Auto-generated method stub
      
   }

}
