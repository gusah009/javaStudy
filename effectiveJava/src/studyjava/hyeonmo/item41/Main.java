package studyjava.hyeonmo.item41;

import java.io.Serializable;

public class Main {

  void testMarkerInterface() {
    Serializable object1 = new MyObject1();
//    Serializable object3 = new MyObject3(); // 컴파일 에러!
  }

  void testMarkerAnnotation() {
    Object object2 = new MyObject2();
    Object object3 = new MyObject3(); // 런타임 전까지 Serializable한 지 아닌지 모름
  }
}
