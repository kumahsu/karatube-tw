package com.chomica.karatube.controller;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chomica.karatube.constant.ConfirmedType;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.http.SongDetail;
import com.chomica.karatube.model.http.req.ConfirmedSongReq;
import com.chomica.karatube.model.http.req.CreateSongReq;
import com.chomica.karatube.model.http.resp.ConfirmedSongResp;
import com.chomica.karatube.model.http.resp.CreateSongResp;
import com.chomica.karatube.model.http.resp.DeleteSongResp;
import com.chomica.karatube.model.http.resp.GetSongDetailResp;
import com.chomica.karatube.model.http.resp.GetSongListResp;
import com.chomica.karatube.model.vo.SingerVO;
import com.chomica.karatube.model.vo.SongVO;
import com.chomica.karatube.service.ISingerService;
import com.chomica.karatube.service.ISongService;

@Controller
@RequestMapping(value = "/song")
public class SongController {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(SongController.class);
   
   // ---------------------------------------------------------------
   @Autowired
   @Qualifier("singerService")
   private ISingerService singerService;
   
   @Autowired
   @Qualifier("songService")
   private ISongService songService;
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "",
                   method = RequestMethod.POST,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody CreateSongResp createSong(@RequestBody CreateSongReq req) {
      logger.debug("Receive create song request: {}", req);
      SingerVO singer = this.singerService.findSingerById(req.getSinger_id());
      SongDetail detail = new SongDetail(null, req.getName(), req.getCategory(), 
                                         singer.getId(), singer.getName(), 
                                         req.getTube_id(), ConfirmedType.NEW.code());
      SongVO song = new SongVO(detail);
      song = this.songService.createSong(song);
      return new CreateSongResp(song.adaptor().toHttpModel());
   }
   
   @RequestMapping(value = "/{song_id}/confirmed",
                   method = RequestMethod.PUT,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody ConfirmedSongResp confirmedSong(@PathVariable("song_id") String song_id, 
                                                        @RequestBody ConfirmedSongReq req)
   {
      logger.debug("Receive confirmed song {} request: {}", song_id, req);
      SongVO song = this.songService.findSongById(song_id);
      song = this.songService.confirmedSong(song, req.getType());
      return new ConfirmedSongResp(song.adaptor().toHttpModel());
   }
   
   @RequestMapping(value = "/{song_id}",
                   method = RequestMethod.DELETE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody DeleteSongResp deleteSong(@PathVariable("song_id") String song_id) {
      logger.debug("Receive delete song {} request", song_id);
      this.songService.deleteSong(song_id);
      return new DeleteSongResp();
   }
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/{song_id}",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetSongDetailResp getSongDetail(@PathVariable("song_id") String song_id) {
      logger.debug("Receive get song {} request", song_id);
      SongVO song = this.songService.findSongById(song_id);
      return new GetSongDetailResp(song.adaptor().toHttpModel());
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
      QueryListData<SongVO> result = this.songService.findSongsByCondition(index, size, category, name);
      List<SongDetail> list = new LinkedList<SongDetail>();
      for(SongVO song : result.getList()) {
         list.add(song.adaptor().toHttpModel());
      }
      return new GetSongListResp(new QueryListData<SongDetail>(result.getSize(), result.getTotalCount(), result.getStart(), list));
   }
}
