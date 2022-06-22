package studyjava.hyeonmo.item1;

public interface Date {

  public static Date of(Long year, Long month, Long day) {
    if (1 <= month && month <= 12) {
      return MyDate.of(year, month, day);
    } else {
      return new AlienDate(year, month, day);
    }
  }
}
