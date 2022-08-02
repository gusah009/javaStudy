package studyjava.hyeonmo.item34;

import static studyjava.hyeonmo.item34.Fruit.Color.RED;
import static studyjava.hyeonmo.item34.Fruit.Color.YELLOW;

import java.time.LocalDate;

public enum Fruit {
  APPLE(1000, RED), BANANA(2000, YELLOW), STRAWBERRY(3000, RED);


  private final int price;
  private final int discountRate = 20;
  private final int discountedPrice;
  private final Color color; // 수정 됨!

  Fruit(int price, Color color) {
    this.price = price;
    this.discountedPrice = price * (100 - this.discountRate) / 100;
    this.color = color; // 수정 됨!
  }

  enum Color {
    RED {
      public LocalDate expirationDate(LocalDate time) {
        return time.plusDays(1); // 빨간색이라 하루!
      }
    },
    YELLOW {
      public LocalDate expirationDate(LocalDate time) {
        return time.plusDays(2); // 노랑색이라 이틀!
      }
    };

    public abstract LocalDate expirationDate(LocalDate time);
  }

  public int getDiscountedPrice() {
    return discountedPrice;
  }
//  public LocalDate expirationDate(LocalDate time) {
//    switch (this.color) {
//      case "Red" -> {
//        return time.plusDays(1); // 빨간색이라 하루!
//      }
//      case "Yellow" -> {
//        return time.plusDays(2); // 노랑색이라 이틀!
//      }
//    }
//    throw new AssertionError(this.color + "는 존재하지 않는 색깔입니다.");
//  }
//  APPLE(1000, "Red") {
//    public LocalDate expirationDate(LocalDate time) {
//      return time.plusDays(1); // 빨간색이라 하루!
//    }
//  },
//  BANANA(2000, "Yellow") {
//    public LocalDate expirationDate(LocalDate time) {
//      return time.plusDays(2); // 노랑색이라 이틀!
//    }
//  },
//  STRAWBERRY(3000, "Red") {
//    public LocalDate expirationDate(LocalDate time) {
//      return time.plusDays(1); // 빨간색이라 하루!
//    }
//  };
//
//  public abstract LocalDate expirationDate(LocalDate time);
}
