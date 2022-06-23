package studyjava.hyeonmo.item3;

// public static final 필드 방식의 싱글턴
//public class MyDate {
//
//  public static final MyDate INSTANCE = new MyDate();
//
//  private MyDate() {} // private 생성자
//
//  public long getNextMonth() {...}
//}

// 정적 팩터리 메서드 방식의 싱글턴Permalink
//public class MyDate {
//
//  private static final MyDate INSTANCE = new MyDate();
//  private MyDate() {} // private 생성자
//  public static MyDate getInstance() { return INSTANCE; }
//
//  public long getNextMonth() {...}
//}

// 열거 타입 방식의 싱글턴
//public enum MyDate {
//  BIRTHDAY, HAPPY_DAY;
//
//  public long getNextMonth() {...}
//}