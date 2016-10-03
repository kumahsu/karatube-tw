package com.chomica.karatube.util;

public class MergeUtil {
   // ---------------------------------------------------------------
   public static <T> T merge(T source, T target) {
      return target == null ? source : target;
   }
}
