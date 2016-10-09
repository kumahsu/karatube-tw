package com.chomica.karatube.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.http.SongDetail;
import com.chomica.karatube.model.http.req.ConnectEnvReq;
import com.chomica.karatube.model.http.req.EnvAddSongReq;
import com.chomica.karatube.model.http.req.EnvInsertSongReq;
import com.chomica.karatube.model.http.resp.ConnectEnvResp;
import com.chomica.karatube.model.http.resp.ControlCmdResp;
import com.chomica.karatube.model.http.resp.EnvAddSongResp;
import com.chomica.karatube.model.http.resp.EnvDeleteSongResp;
import com.chomica.karatube.model.http.resp.EnvInsertSongResp;
import com.chomica.karatube.model.http.resp.GetPlaylistResp;
import com.chomica.karatube.model.vo.EnvironmentVO;
import com.chomica.karatube.model.vo.SongVO;
import com.chomica.karatube.service.IEnvService;
import com.chomica.karatube.service.ISongService;

@Controller
@RequestMapping(value = "/control")
public class ControlPanelController {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(ControlPanelController.class);

   // ---------------------------------------------------------------
   @Autowired
   @Qualifier("mockEnvService")
   private IEnvService envService;
   
   @Autowired
   @Qualifier("songService")
   private ISongService songService;
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/connect",
                   method = RequestMethod.POST,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody ConnectEnvResp connectEnv(@RequestBody ConnectEnvReq req,
                                                    HttpServletResponse resp)
   {
      logger.debug("Receive connect env request: {}", req);
      String envId = this.envService.getPairEnv(req.getPairCode());
      resp.addCookie(new Cookie("env", envId));
      return new ConnectEnvResp(envId);
   }
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/playlist",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetPlaylistResp getPlaylist(@CookieValue("env") String envId,
                                                    @RequestParam("index") Integer index,
                                                    @RequestParam("size") Integer size)
   {
      EnvironmentVO env = this.envService.getEnv(envId);
      QueryListData<SongVO> result = this.envService.getPlayList(env, index, size);
      List<SongDetail> list = new LinkedList<SongDetail>();
      for(SongVO song : result.getList()) {
         list.add(song.adaptor().toHttpModel());
      }
      return new GetPlaylistResp(new QueryListData<SongDetail>(result.getSize(), result.getTotalCount(), result.getStart(), list));
   }
   
   @RequestMapping(value = "/history",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetPlaylistResp getHistory(@CookieValue("env") String envId,
                                                   @RequestParam("index") Integer index,
                                                   @RequestParam("size") Integer size)
   {
      EnvironmentVO env = this.envService.getEnv(envId);
      QueryListData<SongVO> result = this.envService.getHistory(env, index, size);
      List<SongDetail> list = new LinkedList<SongDetail>();
      for(SongVO song : result.getList()) {
         list.add(song.adaptor().toHttpModel());
      }
      return new GetPlaylistResp(new QueryListData<SongDetail>(result.getSize(), result.getTotalCount(), result.getStart(), list));
   }
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/playlist",
                   method = RequestMethod.POST,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody EnvAddSongResp addSong(@CookieValue("env") String envId,
                                               @RequestBody EnvAddSongReq req)
   {
      EnvironmentVO env = this.envService.getEnv(envId);
      SongVO song = this.songService.findSongById(req.getSongId());
      this.envService.addSong(env, song);
      if(env.isIdle()) {
         this.envService.notifyPlayer(env);
      }
      return new EnvAddSongResp();
   }
   
   @RequestMapping(value = "/playlist",
                   method = RequestMethod.PUT,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody EnvInsertSongResp insertSong(@CookieValue("env") String envId,
                                                     @RequestBody EnvInsertSongReq req)
   {
      EnvironmentVO env = this.envService.getEnv(envId);
      this.envService.insertSongToHead(env, req.getSongId());
      return new EnvInsertSongResp();
   }
   
   @RequestMapping(value = "/playlist/{songId}",
                   method = RequestMethod.DELETE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody EnvDeleteSongResp deleteSong(@CookieValue("env") String envId,
                                                     @PathVariable("songId") String songId)
   {
      EnvironmentVO env = this.envService.getEnv(envId);
      this.envService.removeSong(env, songId);
      return new EnvDeleteSongResp();
   }
   
   // ---------------------------------------------------------------
   public @ResponseBody ControlCmdResp skip(@CookieValue("env") String envId) {
      return new ControlCmdResp();
   }
   public @ResponseBody ControlCmdResp restart(@CookieValue("env") String envId) {
      return new ControlCmdResp();
   }
   public @ResponseBody ControlCmdResp playPause(@CookieValue("env") String envId) {
      return new ControlCmdResp();
   }
   public @ResponseBody ControlCmdResp enableOrigin(@CookieValue("env") String envId) {
      return new ControlCmdResp(); 
   }
}
