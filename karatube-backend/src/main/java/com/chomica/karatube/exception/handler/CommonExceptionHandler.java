package com.chomica.karatube.exception.handler;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.exception.BadRequestFieldException;
import com.chomica.karatube.model.http.resp.ErrorResp;

@ControllerAdvice
public class CommonExceptionHandler {
   // ---------------------------------------------------------------
   private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
   
   // ---------------------------------------------------------------
   // ----- Chomica Exception
   @ExceptionHandler(BadRequestFieldException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public @ResponseBody ErrorResp handleBadRequestFieldException(BadRequestFieldException e) {
      logger.debug("Caught bad request field exception: {}", e.getMessage());
      return new ErrorResp(e.getStatus(), e.getMessage());
   }
   
   // ---------------------------------------------------------------
   // ----- Invalid Request Error
   @ExceptionHandler(TypeMismatchException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public @ResponseBody ErrorResp handleTypeMismatchException(TypeMismatchException e) {
      logger.debug("Caught type mismatch exception: {}", e.getMessage());
      return new ErrorResp(StatusCode.BAD_REQUEST);
   }
   @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public @ResponseBody ErrorResp handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
      logger.debug("Caught http media type not supported exception: {}", e.getMessage());
      return new ErrorResp(StatusCode.INVALID_CONTENT_TYPE);
   }
   @ExceptionHandler(HttpMessageNotReadableException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public @ResponseBody ErrorResp handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
      logger.debug("Caught http message not readable exception: {}", e.getMessage());
      return new ErrorResp(StatusCode.INVALID_JSON_FORMAT);
   }

   // ---------------------------------------------------------------
   // ----- Unexpected Error
   @ExceptionHandler(Throwable.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public @ResponseBody ErrorResp handleThrowable(Throwable t) {
      logger.error("Caught throwable: {}", t);
      return new ErrorResp(StatusCode.UNKNOWN_ERROR);
   }
}
