package com.chomica.karatube.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chomica.karatube.model.http.req.EchoReq;
import com.chomica.karatube.model.http.resp.EchoResp;
import com.chomica.karatube.model.http.resp.HealthCheckResp;

@Controller
@RequestMapping(value = "/common")
public class CommonController {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
   
   // ---------------------------------------------------------------
   @RequestMapping(value = "/health", 
                   method = RequestMethod.GET, 
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody HealthCheckResp healthCheck() {
      logger.debug("Receive health check request");
      return new HealthCheckResp();
   }
   
   @RequestMapping(value = "/echo",
                   method = RequestMethod.POST,
                   consumes = MediaType.APPLICATION_JSON_VALUE,
                   produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody EchoResp echo(@RequestBody EchoReq req) {
      logger.debug("Receive echo request: {}", req);
      String message = req.getMessage();
      return new EchoResp(message);
   }
}
