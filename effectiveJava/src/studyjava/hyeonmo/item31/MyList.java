package studyjava.hyeonmo.item31;

public class MyList<E> {

  private static final int MAX = 10;
  public E[] elements = (E[]) new Object[MAX];

  void MyList(MyList<? extends E> e) {
    System.arraycopy(e.elements, 0, this.elements, 0, MAX);
  }

  void copyAll(MyList<? super E> e) {
    System.arraycopy(this.elements, 0, e.elements, 0, MAX);
  }
}
