package studyjava.hyeonmo.item31;

public class Main {

  public static void main(String[] args) {
    MyList<Super> superMyList = new MyList<>();
    superMyList.MyList(new MyList<Sub1>());

    MyList<Sub1> subList = new MyList<>();
    subList.copyAll(superMyList);
  }

}
