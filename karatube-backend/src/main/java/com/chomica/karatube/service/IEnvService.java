package com.chomica.karatube.service;

import org.springframework.web.socket.WebSocketSession;

import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.vo.EnvironmentVO;
import com.chomica.karatube.model.vo.SongVO;

public interface IEnvService {
   // ---------------------------------------------------------------
   public EnvironmentVO createEnv(WebSocketSession session);
   public String getPairEnv(String pairCode);
   public EnvironmentVO getEnv(String envId);
   
   // ---------------------------------------------------------------
   public QueryListData<SongVO> getPlayList(EnvironmentVO env, Integer index, Integer size);
   public QueryListData<SongVO> getHistory(EnvironmentVO env, Integer index, Integer size);
   public void addSong(EnvironmentVO env, SongVO song);
   public void insertSongToHead(EnvironmentVO env, String songId);
   public void removeSong(EnvironmentVO env, String songId);
   
   // ---------------------------------------------------------------
   public void notifyPlayer(EnvironmentVO env);
   public void skipSong(EnvironmentVO env);
   public void restartSong(EnvironmentVO env);
   public void playPause(EnvironmentVO env);
   public void enableOrigin(EnvironmentVO env);
}
