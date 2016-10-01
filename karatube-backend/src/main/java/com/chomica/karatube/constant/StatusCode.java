package com.chomica.karatube.constant;

public enum StatusCode {
   // ---------------------------------------------------------------
   // ----- 200 Success
   SUCCESS(0, "success"),
   
   // ----- 400 Bad Request
   BAD_REQUEST(400000, "Invalid request format or value"),
   INVALID_JSON_FORMAT(400011, "Invalid request json format"),
   INVALID_CONTENT_TYPE(40021, "Invalid or missing Content-Type header"),
   
   // ----- 500 Internal Server Error
   UNKNOWN_ERROR(500999, "Unknown error occurred")
   ;
   
   // ---------------------------------------------------------------
   private int code;
   private String message;
   
   // ---------------------------------------------------------------
   private StatusCode(int code, String message) {
      this.code = code;
      this.message = message;
   }
   
   // ---------------------------------------------------------------
   public int code() {
      return this.code;
   }
   public String message() {
      return this.message;
   }
}