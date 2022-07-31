package concurrency_220730;

import java.util.concurrent.TimeUnit;

public class ReadWriteProblem {

  private static final int TEST_THREAD = 20;

  public static void main(String[] args) {
    Count count = new Count();
    for (int i = 0; i < TEST_THREAD; i++) {
      if (i % 5 == 0) {
        new Thread(count::increaseVal).start();
      } else {
        final int finalI = i;
        new Thread(() -> System.out.println("#" + finalI + " : " + count.view()))
            .start();
      }
    }
  }

  static class Count {

    int val = 0;

    synchronized int view() {
      return val;
    }

    synchronized void increaseVal() {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException ignore) {
      }
      val++;
    }
  }
}
