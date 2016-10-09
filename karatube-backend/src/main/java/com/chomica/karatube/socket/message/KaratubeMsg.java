package com.chomica.karatube.socket.message;

import com.chomica.karatube.constant.KaratubeTopic;
import com.chomica.karatube.util.JsonUtil;

public class KaratubeMsg<T> {
   // ---------------------------------------------------------------
   protected String id;
   protected String topic;
   protected T msg;
   
   // ---------------------------------------------------------------
   public KaratubeMsg() { }
   protected KaratubeMsg(String id, String topic, T msg) {
      this.id = id;
      this.topic = topic;
      this.msg = msg;
   }
   public KaratubeMsg(String id, KaratubeTopic topic, T msg) {
      this(id, topic.topic(), msg);
   }
   
   // ---------------------------------------------------------------
   public void setId(String id) {
      this.id = id;
   }
   public void setTopic(String topic) {
      this.topic = topic;
   }
   public void setMsg(T msg) {
      this.msg = msg;
   }
   
   // ---------------------------------------------------------------
   public String getId() {
      return this.id;
   }
   public String getTopic() {
      return this.topic;
   }
   public T getMsg() {
      return this.msg;
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
