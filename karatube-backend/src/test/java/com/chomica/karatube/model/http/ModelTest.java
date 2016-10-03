package com.chomica.karatube.model.http;

import org.junit.Test;

import com.chomica.karatube.base.BaseTestCase;
import com.chomica.karatube.model.http.resp.EchoResp;

public class ModelTest extends BaseTestCase {
   // ---------------------------------------------------------------
   @Test
   public void testModelToString() {
      EchoResp resp = new EchoResp("Test");
      System.out.println(resp);
   }

}
