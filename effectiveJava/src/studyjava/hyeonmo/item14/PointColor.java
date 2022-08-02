package studyjava.hyeonmo.item14;

public class PointColor extends Point implements Comparable<Point> {

  public String color;

  public PointColor(Integer x, Integer y, String color) {
    super(x, y);
    this.color = color;
  }

  @Override
  public int compareTo(Point o) {
    int result = super.compareTo(o);
    if (result == 0) {
      return color.compareTo(((PointColor) o).color);
    }
    return result;
  }
}
