package studyjava.hyeonmo.item10;

public class StringEquals {

  public static void main(String[] args) {
    String stringPoolStr1 = "mo";
    String stringPoolStr2 = "mo";
    String heapStr1 = new String("mo");
    String heapStr2 = new String("mo");

    System.out.println(stringPoolStr1 == stringPoolStr2); // true
    System.out.println(stringPoolStr1 == heapStr1); // false
    System.out.println(heapStr1 == heapStr2); // false

    System.out.println(stringPoolStr1.equals(stringPoolStr2)); // true
    System.out.println(stringPoolStr1.equals(heapStr1)); // true
    System.out.println(heapStr1.equals(heapStr2)); // true
  }
}
