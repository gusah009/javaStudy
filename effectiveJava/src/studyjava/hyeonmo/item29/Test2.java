package studyjava.hyeonmo.item29;

public class Test2 {

  static Object[] thing = new Object[10];

  public <E> E setAndGet(E e) {
    thing[0] = e;
    return (E) thing[0];
  }
}
