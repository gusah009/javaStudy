package studyjava.hyeonmo.item1;

public class AlienDate implements Date {

  private Long year;
  private Long month;
  private Long day;

  public AlienDate(Long year, Long month, Long day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }
}
