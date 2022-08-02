package studyjava.hyeonmo.item14;

import java.util.Comparator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GoodPointColor implements Comparable<GoodPointColor> {

  Point point;
  String color;

  @Override
  public int compareTo(GoodPointColor o) {
    int result = point.compareTo(o.point);
    if (result == 0) {
      return color.compareTo(o.color);
    }
    return result;
  }
}
