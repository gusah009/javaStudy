package studyjava.hyeonmo.item15;

public class StaticArr {

  private static final Thing[] PRIVATE_VALUES = {new Thing(1), new Thing(2), new Thing(3)};

  public static final Thing[] values() {
    return PRIVATE_VALUES.clone();
  }
}
