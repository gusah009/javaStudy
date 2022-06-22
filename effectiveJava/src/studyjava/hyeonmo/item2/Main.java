package studyjava.hyeonmo.item2;

public class Main {

  public static void main(String[] args) {
    LombokMyDate myDate = LombokMyDate.builder(2022) // year
        .year(33)
        .month(6)
        .day(22)
        .build();
    System.out.println("myDate = " + myDate);
  }
}
