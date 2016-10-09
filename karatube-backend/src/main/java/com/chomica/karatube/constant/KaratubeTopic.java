package com.chomica.karatube.constant;

import com.chomica.karatube.exception.TypeNotFoundException;

public enum KaratubeTopic {
   // ---------------------------------------------------------------
   SUCCESS("success"),
   INITIAL_ENV("init"),
   PLAY("play"),
   RESTART("restart"),
   PLAY_PAUSE("play_pause"),
   ENABLE_ORIGIN("origin"),
   WAIT("wait"),
   NOTIFY("notify"),
   NEXT_SONG("next")
   ;
   // ---------------------------------------------------------------
   private String topic;
   
   // ---------------------------------------------------------------
   private KaratubeTopic(String topic) {
      this.topic = topic;
   }
   
   // ---------------------------------------------------------------
   public String topic() {
      return this.topic;
   }
   
   // ---------------------------------------------------------------
   public static KaratubeTopic getTopic(String topic) throws TypeNotFoundException {
      for(KaratubeTopic t : KaratubeTopic.values()) {
         if(t.topic().equalsIgnoreCase(topic)) {
            return t;
         }
      }
      throw new TypeNotFoundException("KaratubeTopic", topic);
   }
}
