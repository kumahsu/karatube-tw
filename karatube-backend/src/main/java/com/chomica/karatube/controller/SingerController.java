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

import com.chomica.karatube.model.http.req.CreateSingerReq;
import com.chomica.karatube.model.http.req.UpdateSingerReq;
import com.chomica.karatube.model.http.resp.CreateSingerResp;
import com.chomica.karatube.model.http.resp.DeleteSingerResp;
import com.chomica.karatube.model.http.resp.GetSingerDetailResp;
import com.chomica.karatube.model.http.resp.GetSingerListResp;
import com.chomica.karatube.model.http.resp.GetSongListResp;
import com.chomica.karatube.model.http.resp.UpdateSingerResp;

@Controller
@RequestMapping(value = "/singer")
public class SingerController {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(SingerController.class);
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "", 
                   method = RequestMethod.POST, 
                   consumes = MediaType.APPLICATION_JSON_VALUE, 
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody CreateSingerResp createSinger(@RequestBody CreateSingerReq req) {
      logger.debug("Receive create singer request: {}", req);
      return null;
   }
   
   @RequestMapping(value = "/{singer_id}",
                   method = RequestMethod.PUT,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)   
   public @ResponseBody UpdateSingerResp updateSinger(@PathVariable("singer_id") String singer_id, 
                                                      @RequestBody UpdateSingerReq req)
   {
      logger.debug("Receive udpate singer {} request: {}", singer_id, req);
      return null;
   }
   
   @RequestMapping(value = "/{singer_id}",
                   method = RequestMethod.DELETE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody DeleteSingerResp deleteSinger(@PathVariable("singer_id") String singer_id) {
      logger.debug("Receive delete singer {} request", singer_id);
      return new DeleteSingerResp();
   }
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/{singer_id}",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetSingerDetailResp getSingerDetail(@PathVariable("singer_id") String singer_id) {
      logger.debug("Receive get singer {} detail", singer_id);
      return null;
   }
   
   @RequestMapping(value = "/list",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetSingerListResp getSingerList(@RequestParam("index") Integer index,
                                                        @RequestParam("size") Integer size,
                                                        @RequestParam("type") Integer type,
                                                        @RequestParam("keyword") String keyword)
   {
      logger.debug("Receive get singer list request from {} get {}, type={}, keyword={}", index, size, type, keyword);
      return null;
   }
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/{singer_id}/songs",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetSongListResp getSongsBySinger(@PathVariable("singer_id") String singer_id) {
      logger.debug("Receive get songs by singer {} request", singer_id);
      return null;
   }
}
