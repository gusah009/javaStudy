package studyjava.hyeonmo.item8;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {

  private static final Cleaner cleaner = Cleaner.create();

  private static class State implements Runnable {

    int numJunkPiles; // 방(Room) 안의 쓰레기 수

    public State(int numJunkPiles) {
      this.numJunkPiles = numJunkPiles;
    }

    // close 메소드나 cleaner가 호출한다.
    @Override
    public void run() {
      System.out.println("방 청소");
      numJunkPiles = 0;
    }
  }

  //방의 상태. cleanable와 공유한다.
  private final State state;

  // cleanable 객체. 수거 대상이 되면 방을 청소한다.
  private final Cleaner.Cleanable cleanable;

  public Room(int numJunkPiles) {
    this.state = new State(numJunkPiles);
    this.cleanable = cleaner.register(this, state);
  }

  @Override
  public void close() throws Exception {
    cleanable.clean();
  }
}
