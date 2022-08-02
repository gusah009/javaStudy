package studyjava.hyeonmo.item14;

import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point implements Comparable<Point> {

  public Integer x;
  public Integer y;

  @Override
  public int compareTo(Point o) {
    if (x.compareTo(o.x) == 0) {
      return y.compareTo(o.y);
    }
    return x.compareTo(o.x);
  }
}
