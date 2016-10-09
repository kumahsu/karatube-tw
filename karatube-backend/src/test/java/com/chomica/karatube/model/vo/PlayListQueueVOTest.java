package com.chomica.karatube.model.vo;

import org.junit.Test;

import com.chomica.karatube.constant.ConfirmedType;
import com.chomica.karatube.constant.SingerType;
import com.chomica.karatube.constant.SongCategory;

public class PlayListQueueVOTest {
   
   private SongVO getSongVO(int seq) {
      Long now = System.currentTimeMillis();
      String id = "song_" + seq;
      String name = "Mock Song " + seq;
      SongCategory category = SongCategory.CHINESE;
      SingerVO singer = new SingerVO("singer_" + seq, "Singer", SingerType.MALE, null, now, now);
      String tubeId = "tube_" + seq;
      ConfirmedType confirmed = ConfirmedType.NEW;
      return new SongVO(id, name, category, singer, tubeId, confirmed, now, now);
   }
   
   @Test
   public void test() {
      PlaylistQueueVO playList = new PlaylistQueueVO();
      for(int i = 0; i < 10; i++) {
         playList.push(this.getSongVO(i));
      }
      while(playList.hasNex()) {
         System.out.println(playList.pop().getId());
      }
      System.out.println();
      for(int i = 0; i < 10; i++) {
         playList.push(this.getSongVO(i));
      }
      playList.insert("song_5");
      while(playList.hasNex()) {
         System.out.println(playList.pop().getId());
      }
   }

}
