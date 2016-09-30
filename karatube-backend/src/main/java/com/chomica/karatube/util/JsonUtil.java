package com.chomica.karatube.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.exception.UnexpectException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtil {
   //---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
   
   //---------------------------------------------------------------
   private static ObjectMapper OBJECT_MAPPER;
   private static ObjectWriter PRETTY_MAPPER;

   //---------------------------------------------------------------
   private static final Object MAPPER_LOCK = new Object();
   private static final Object PRETTY_FORMAT_LOCK = new Object();
   
   //---------------------------------------------------------------
   public static ObjectMapper getObjectMapper() {
       if(OBJECT_MAPPER == null) {
           synchronized(MAPPER_LOCK) {
               logger.debug("Create object mapper instance");
               OBJECT_MAPPER = new ObjectMapper();
           }
       }
       return OBJECT_MAPPER;
   }
   public static ObjectWriter getPrettyFormatMapper() {
       if(PRETTY_MAPPER == null) {
           synchronized(PRETTY_FORMAT_LOCK) {
               logger.debug("Create pretty format mapper instance");
               PRETTY_MAPPER = new ObjectMapper().writer().withDefaultPrettyPrinter();
           }   
       }
       return PRETTY_MAPPER;
   }
   
   //---------------------------------------------------------------
   public static String writeObjectToJson(Object obj) {
       String result = null;
       try {
           result = getObjectMapper().writeValueAsString(obj);
       } catch (JsonProcessingException e) {
           logger.error("Write object to Json failed: {}", e);
           throw new UnexpectException(StatusCode.UNKNOWN_ERROR, "Write object to Json");
       }
       return result;
   }
   
   //---------------------------------------------------------------
   public static <T> T readJsonToObject(String jsonString, Class<T> clazz) {
       T result = null;
       try {
           result = getObjectMapper().readValue(jsonString, clazz);
       } catch (IOException e) {
           logger.error("Parse Json failed: {}", e);
           throw new UnexpectException(StatusCode.UNKNOWN_ERROR, "Parsing json to object");
       }
       return result;
   }
}
