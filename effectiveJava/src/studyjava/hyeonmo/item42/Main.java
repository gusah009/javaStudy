package studyjava.hyeonmo.item42;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    FilterEverything.filter(integers, i -> (Integer) i < 3);
    System.out.println(integers);
  }
}
