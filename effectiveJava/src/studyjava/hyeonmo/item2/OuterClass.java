package studyjava.hyeonmo.item2;

public class OuterClass {

  private int outerField;

  public OuterClass(
      PublicStaticInnerClass publicStaticInnerClass,
      PrivateStaticInnerClass privateStaticInnerClass,
      PublicInnerClass publicInnerClass,
      PrivateInnerClass privateInnerClass) {
    this.outerField = privateInnerClass.innerField;
    this.outerField = privateStaticInnerClass.innerField;
    this.outerField = publicInnerClass.innerField;
    this.outerField = privateInnerClass.innerField;
  }

  public static class PublicStaticInnerClass {

    private int innerField;

    public PublicStaticInnerClass(int _outerField) {
//      outerField = _outerField; // static필드가 아닌 필드에 접근 에러!
    }
  }

  private static class PrivateStaticInnerClass {

    private int innerField;

    public PrivateStaticInnerClass(int _outerField) {
//      outerField = _outerField; // static필드가 아닌 필드에 접근 에러!
    }
  }

  public class PublicInnerClass {

    private int innerField;

    public PublicInnerClass(int outerField) {
      OuterClass.this.outerField = outerField; // 이름이 겹치므로 정확하게 명시해 줘야 함
    }
  }

  private class PrivateInnerClass {

    private int innerField;

    public PrivateInnerClass(int outerField) {
      OuterClass.this.outerField = outerField; // 이름이 겹치므로 정확하게 명시해 줘야 함
    }
  }
}
