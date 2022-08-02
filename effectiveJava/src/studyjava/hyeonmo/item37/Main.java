package studyjava.hyeonmo.item37;

import static studyjava.hyeonmo.item37.Main.FruitColor.RED;
import static studyjava.hyeonmo.item37.Main.FruitColor.YELLOW;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

  enum FruitColor {
    RED, YELLOW
  }

  public static void main(String[] args) {
    EnumMap<FruitColor, Set<String>> fruitsByFruitColor = new EnumMap<>(FruitColor.class);
    for (FruitColor fruitColor : FruitColor.values()) {
      fruitsByFruitColor.put(fruitColor, new HashSet<>());
    }
    fruitsByFruitColor.get(RED).add("apple");
    fruitsByFruitColor.get(RED).add("strawberry");
    fruitsByFruitColor.get(YELLOW).add("banana");

//    Set<String>[] fruitsByFruitColor = (Set<String>[]) new Set[FruitColor.values().length];
//    for (int i = 0; i < fruitsByFruitColor.length; i++) {
//      fruitsByFruitColor[i] = new HashSet<>();
//    }
//    fruitsByFruitColor[RED.ordinal()].add("apple");
//    fruitsByFruitColor[RED.ordinal()].add("strawberry");
//    fruitsByFruitColor[YELLOW.ordinal()].add("banana");
  }

}
