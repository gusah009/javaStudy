package studyjava.hyeonmo.item29;

public class Test1<E> {

  E[] things = (E[]) new Object[10];

  public E setAndGet(E e) {
    things[0] = e;
    return things[0];
  }
}
