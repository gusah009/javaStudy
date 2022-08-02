package studyjava.hyeonmo.item14;


class PointColorTest {

  public static void main(String[] args) {
    Point point = new Point(1, 2);
    PointColor pointColor = new PointColor(1, 2, "RED");

    System.out.println("point.compareTo(PointColor): " + point.compareTo(pointColor) + " == " + 0);

    try {
      System.out.println(pointColor.compareTo(point) + " == " + 0);
    } catch (ClassCastException e) {
      System.out.println("ClassCastException");
    }
  }
}