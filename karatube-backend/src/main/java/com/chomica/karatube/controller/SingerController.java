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

import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.http.SingerDetail;
import com.chomica.karatube.model.http.req.CreateSingerReq;
import com.chomica.karatube.model.http.req.UpdateSingerReq;
import com.chomica.karatube.model.http.resp.CreateSingerResp;
import com.chomica.karatube.model.http.resp.DeleteSingerResp;
import com.chomica.karatube.model.http.resp.GetSingerDetailResp;
import com.chomica.karatube.model.http.resp.GetSingerListResp;
import com.chomica.karatube.model.http.resp.GetSongListResp;
import com.chomica.karatube.model.http.resp.UpdateSingerResp;
import com.chomica.karatube.model.vo.SingerVO;
import com.chomica.karatube.service.ISingerService;

@Controller
@RequestMapping(value = "/singer")
public class SingerController {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(SingerController.class);
   
   // ---------------------------------------------------------------
   @Autowired
   @Qualifier("singerService")
   private ISingerService singerService;
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "", 
                   method = RequestMethod.POST, 
                   consumes = MediaType.APPLICATION_JSON_VALUE, 
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody CreateSingerResp createSinger(@RequestBody CreateSingerReq req) {
      logger.debug("Receive create singer request: {}", req);
      SingerDetail detail = new SingerDetail(null, req.getName(), req.getType(), req.getKeywords());
      SingerVO singer = new SingerVO(detail);
      singer = this.singerService.createSinger(singer);
      return new CreateSingerResp(singer.adaptor().toHttpModel());
   }
   
   @RequestMapping(value = "/{singer_id}",
                   method = RequestMethod.PUT,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)   
   public @ResponseBody UpdateSingerResp updateSinger(@PathVariable("singer_id") String singer_id, 
                                                      @RequestBody UpdateSingerReq req)
   {
      logger.debug("Receive udpate singer {} request: {}", singer_id, req);
      SingerVO singer = this.singerService.findSingerById(singer_id);
      SingerDetail detail = new SingerDetail(null, null, req.getType(), req.getKeywords());
      singer.merge(new SingerVO(detail));
      singer = this.singerService.udpateSinger(singer);
      return new UpdateSingerResp(singer.adaptor().toHttpModel());
   }
   
   @RequestMapping(value = "/{singer_id}",
                   method = RequestMethod.DELETE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody DeleteSingerResp deleteSinger(@PathVariable("singer_id") String singer_id) {
      logger.debug("Receive delete singer {} request", singer_id);
      this.singerService.deleteSinger(singer_id);
      return new DeleteSingerResp();
   }
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/{singer_id}",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetSingerDetailResp getSingerDetail(@PathVariable("singer_id") String singer_id) {
      logger.debug("Receive get singer {} detail", singer_id);
      SingerVO singer = this.singerService.findSingerById(singer_id);
      return new GetSingerDetailResp(singer.adaptor().toHttpModel());
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
      QueryListData<SingerVO> result = this.singerService.findSingers(index, size, type, keyword);
      List<SingerDetail> list = new LinkedList<SingerDetail>();
      for(SingerVO singer : result.getList()) {
         list.add(singer.adaptor().toHttpModel());
      }
      return new GetSingerListResp(new QueryListData<SingerDetail>(result.getSize(), result.getTotalCount(), result.getStart(), list));
   }
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/{singer_id}/songs",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody GetSongListResp getSongsBySinger(@RequestParam("index") Integer index,
                                                         @RequestParam("size") Integer size,
                                                         @PathVariable("singer_id") String singer_id) 
   {
      logger.debug("Receive get songs by singer {} request from {} get {}", singer_id, index, size);
      return null;
   }
}
