package studyjava.hyeonmo.item2;

//public class MyDate {
//
//  private static final Long DEFAULT_MONTH = 1L;
//  private static final Long DEFAULT_DAY = 1L;
//
//  private Long year;
//  private Long month;
//  private Long day;
//
//  public MyDate(Long year) {
//    this(year, DEFAULT_MONTH, DEFAULT_DAY);
//  }
//
//  public MyDate(Long year, Long month) {
//    this(year, month, DEFAULT_DAY);
//  }
//
//  public MyDate(Long year, Long month, Long day) {
//    this.year = year;
//    this.month = month;
//    this.day = day;
//  }
//}

// JavaBeans 패턴
//public class MyDate {
//
//  private static final Long DEFAULT_MONTH = 1L;
//  private static final Long DEFAULT_DAY = 1L;
//
//  private Long year  = -1L; // 필수!
//  private Long month =  0L; // 선택
//  private Long day   =  0L; // 선택
//
//  public MyDate() { }
//
//  public void setYear(long val)  {year = val;}
//  public void setMonth(long val) {month = val;}
//  public void setDay(long val)   {day = val;}
//
//  public static void main(String[] args) {
//    MyDate myDate = new MyDate();
//    myDate.setYear(2022L);
//    myDate.setMonth(6L);
//    myDate.setDay(22L);
//  }
//}

// 빌더 패턴
public class MyDate {

  private Long year;
  private Long month;
  private Long day;

  private MyDate(Builder builder) {
    this.year = builder.year;
    this.month = builder.month;
    this.day = builder.day;
  }

  public static class Builder {

    // 필수!
    private final Long year;

    // 선택
    private Long month;
    private Long day;

    public Builder(long year) {
      this.year = year;
    }

    public Builder month(long val) {
      this.month = val;
      return this;
    }

    public Builder day(long val) {
      this.day = val;
      return this;
    }

    public MyDate build() {
      return new MyDate(this);
    }
  }

  public static void main(String[] args) {
    MyDate onlyYear = new MyDate.Builder(2022L).build();
    MyDate YearAndMonth = new MyDate.Builder(2022L).month(6L).build();
    MyDate myDate = new Builder(2022L).month(6L).day(22L).build();
  }
}