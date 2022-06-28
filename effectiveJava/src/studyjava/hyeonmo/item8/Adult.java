package studyjava.hyeonmo.item8;

public class Adult {

  public static void main(String[] args) {
    try (Room myRoom = new Room(99)) {
      System.out.println("어른");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
