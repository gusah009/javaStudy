package studyjava.hyeonmo.item24;

public class OuterClass {

  private int a;

  void printHelloWorld() {
    class LocalClass {

      void print() {
        System.out.println("a = " + a);
      }
    }
    LocalClass localClass = new LocalClass();
    localClass.print(); // 여러번 호출 가능!
    localClass.print(); // 여러번 호출 가능!
  }

  public static void main(String[] args) {
//    new LocalClass(); // 컴파일 에러! 지역 변수와 유효 범위가 같기 때문에 밖에서 호출 불가능
  }
}

//  private class InnerClass {
//
//    void accessOuterField() {
//      new Annonymous() {
//        @Override
//        public void helloWorld() {
//          System.out.println("a = " + a); //바깥 인스턴스의 private 필드에 접근 가능하다.
//        }
//      };
//    }
//  }
//interface Annonymous {
//  void helloWorld();
//}

//  private class InnerClass {
//    void accessOuterField() {
//      OuterClass.this.a = 3; // 바깥 인스턴스의 private 필드에 접근 가능하다.
//    }
//  }

//  private static class InnerClass {
//    void accessOuterFieldI() {
//      OuterClass outerClass = new OuterClass();
//      outerClass.a = 3; // 바깥 클래스의 private 필드에 접근 가능하다.
//    }
//  }
