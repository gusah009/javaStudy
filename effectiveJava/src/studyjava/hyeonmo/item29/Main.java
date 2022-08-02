package studyjava.hyeonmo.item29;

public class Main {

  public static void main(String[] args) {
    Test1<Integer> test1 = new Test1<>();
    Integer test1Result = test1.setAndGet(3);
    System.out.println("test1Result = " + test1Result);

    Test2 test2 = new Test2();
    Integer test2Result = test2.setAndGet(3);
    System.out.println("test2Result = " + test2Result);
  }
}
