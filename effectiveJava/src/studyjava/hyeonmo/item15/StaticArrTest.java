package studyjava.hyeonmo.item15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class StaticArrTest {

  @Test
  public void main(String[] args) {
    StaticArr staticArr = new StaticArr();
    StaticArr staticArr2 = new StaticArr();

    Thing[] values = staticArr.values();
    values[0].setA(4);

    System.out.println("staticArr2 = " + staticArr2);
  }

}