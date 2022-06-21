package java.hyeonmo.item1;

public class MyDate implements Date {

  private static final Long NOW_YEAR = 2022L;
  private static final Long NOW_MONTH = 6L;
  private static final Long NOW_DAY = 21L;

  private static final MyDate UNIX_TIME = new MyDate(1970L, 1L, 1L);

  private Long year;
  private Long month;
  private Long day;

//  public MyDate() {
//    this.year = NOW_YEAR;
//    this.month = NOW_MONTH;
//    this.day = NOW_DAY;
//  }

  private MyDate() {
  }

  private MyDate(Long year, Long month, Long day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

//  public MyDate(Long year, Long month, Long day) {
//    this.year = year;
//    this.month = month;
//    this.day = day;
//  }

  public static MyDate now() {
    MyDate nowDate = new MyDate();
    nowDate.year = NOW_YEAR;
    nowDate.month = NOW_MONTH;
    nowDate.day = NOW_DAY;
    return nowDate;
  }

  public static MyDate getUnixTime() {
    return UNIX_TIME;
  }

  public static MyDate of(Long year, Long month, Long day) {
    return new MyDate(year, month, day);
  }

//  public static void main(String[] args) {
//    MyDate unixTime = new MyDate(1970L, 1L, 1L);
//  }

  public static void main(String[] args) {
    MyDate unixTime = MyDate.getUnixTime();
  }
}
