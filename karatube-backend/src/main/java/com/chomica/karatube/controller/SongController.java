package com.chomica.karatube.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chomica.karatube.model.http.req.ConfirmedSongReq;
import com.chomica.karatube.model.http.req.CreateSongReq;
import com.chomica.karatube.model.http.resp.ConfirmedSongResp;
import com.chomica.karatube.model.http.resp.CreateSongResp;
import com.chomica.karatube.model.http.resp.DeleteSongResp;
import com.chomica.karatube.model.http.resp.GetSongDetailResp;
import com.chomica.karatube.model.http.resp.GetSongListResp;

@Controller
@RequestMapping(value = "/song")
public class SongController {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(SongController.class);
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "",
                   method = RequestMethod.POST,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody CreateSongResp createSong(@RequestBody CreateSongReq req) {
      logger.debug("Receive create song request: {}", req);
      return null;
   }
   
   @RequestMapping(value = "/{song_id}/confirmed",
                   method = RequestMethod.PUT,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody ConfirmedSongResp confirmedSong(@PathVariable("song_id") String song_id, 
                                                        @RequestBody ConfirmedSongReq req)
   {
      logger.debug("Receive confirmed song {} request: {}", song_id, req);
      return null;
   }
   
   @RequestMapping(value = "/{song_id}",
                   method = RequestMethod.DELETE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody DeleteSongResp deleteSong(@PathVariable("song_id") String song_id) {
      logger.debug("Receive delete song {} request", song_id);
      return null;
   }
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/{song_id}",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetSongDetailResp getSongDetail(@PathVariable("song_id") String song_id) {
      logger.debug("Receive get song {} request", song_id);
      return null;
   }
   
   @RequestMapping(value = "/list",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetSongListResp getSongList(@RequestParam("index") Integer index,
                                                    @RequestParam("size") Integer size,
                                                    @RequestParam("category") Integer category,
                                                    @RequestParam("name") String name)
   {
      logger.debug("Receive get song list request from {} get {}, category={}, name={}", index, size, category, name);
      return null;
   }
}
