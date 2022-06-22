package studyjava.hyeonmo.item2;

import lombok.Builder;

@Builder
public class LombokMyDate {

  private final int year;
  private int month;
  private int day;

  public static LombokMyDateBuilder builder(int year) {
    return new LombokMyDateBuilder().year(year);
  }
}
