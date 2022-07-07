package studyjava.hyeonmo.item13;

import lombok.AllArgsConstructor;

public class A {

  public A(int a) {
    this.a = a;
  }

  int a;

  public A clone() {
    return new A(a);
  }
}
