package studyjava.hyeonmo.item32;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    okTest("와우", "이게", "되네");
  }

  static <T> void okTest(T a, T b, T c) {
    System.out.println(test(List.of(a, b, c))); // [와우, 이게, 되네]
    return;
  }

  static <T> List<? extends T> test(List<? extends T> args) {
    return args;
  }

//  public static void main(String[] args) {
//    List<String> intList1 = new ArrayList<>();
//    test(intList1);
//  }
//
//  static void test(List<String>... stringLists) {
//    Object[] objects = stringLists;
//    objects[0] = List.of(1);
//    String s = stringLists[0].get(0); // ClassCastException
//  }
}


