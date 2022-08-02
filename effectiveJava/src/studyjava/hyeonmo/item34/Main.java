package studyjava.hyeonmo.item34;

public class Main {

  public static void main(String[] args) {
    for (Fruit fruit : Fruit.values()) {
      System.out.println(fruit + "의 할인된 가격은 " + fruit.getDiscountedPrice() + "입니다.");
    }
  }

}
