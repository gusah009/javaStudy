package studyjava.hyeonmo.item13;

public class B extends A implements Cloneable {

  @Override
  public String toString() {
    return "B{" +
        "a=" + a + ", b=" + b +
        '}';
  }

  int b;

  public B(int a, int b) {
    super(a);
    this.b = b;
  }

  @Override
  public B clone() {
    return (B) super.clone();
  }
}
