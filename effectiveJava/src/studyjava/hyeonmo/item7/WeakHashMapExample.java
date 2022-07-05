package studyjava.hyeonmo.item7;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapExample {

  public static void main(String[] args) {
    WeakHashMap<MyKey, MyValue> weakHashMap = new WeakHashMap<>();
    HashMap<MyKey, MyValue> map = new HashMap<>();

    MyKey keyA = new MyKey("keyA");
    MyKey keyB = new MyKey("keyB");
    MyKey keyC = new MyKey("keyC");

    MyValue valueA = new MyValue("valueA");
    MyValue valueB = new MyValue("valueB");
    MyValue valueC = new MyValue("valueC");

    map.put(keyA, valueA);
    map.put(keyB, valueB);
    map.put(keyC, valueC);

    //map.put(keyA, valueA);

    keyA = null;
    valueB.setValue("newValue");
    valueB = null;

    System.gc(); // 강제 가비지 컬렉터 실행

    map.keySet().stream().forEach(e -> System.out.println(e));
    map.values().stream().forEach(e -> System.out.println(e));

    System.out.println("==================");

    //map.keySet().stream().forEach(e -> System.out.println(e));
    //map.values().stream().forEach(e -> System.out.println(e));
  }
}

class MyKey {

  private String key;

  public MyKey(String key) {
    this.key = key;
  }

  public String toString() {
    return this.key;
  }
}

class MyValue {

  private String value;

  public MyValue(String value) {
    this.value = value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String toString() {
    return this.value;
  }
}
