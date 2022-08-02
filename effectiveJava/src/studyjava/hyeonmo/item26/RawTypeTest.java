package studyjava.hyeonmo.item26;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RawTypeTest {

  public static void main(String[] args) {
    List<List<String>> stringTwoPhase = new ArrayList<>();
    stringTwoPhase.add(List.of("ABC", "DEF"));
    safeAdd(stringTwoPhase);
  }

  private static void safeAdd(List<?> list) {
    Object o = list.get(0);
    System.out.println("o = " + o);
  }
}

//  private static void unsafeAdd(List list, Object o) {
//    list.add(o);
//  }

//  public static void main(String[] args) {
//    List<IPhone> IPhoneList = new ArrayList<>();
//    IPhoneList.add(new GalaxyPhone());
//
//    for (Object next : IPhoneList) {
//      IPhone iPhone = (IPhone) next;
//      iPhone.airDrop();
//    }
//  }
