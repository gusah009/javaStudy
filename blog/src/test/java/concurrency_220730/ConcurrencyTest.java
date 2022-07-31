package concurrency_220730;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConcurrencyTest {

  @Test
  void concurrencyTest() throws InterruptedException {
    int numberOfTimes = 10;
    double testWithMultiThreadTakeTime = testWithMultiThreadGetTakeTime(numberOfTimes);
    double testWithSingleThreadTakeTime = testWithSingleThreadGetTakeTime(numberOfTimes);
    Assertions.assertThat(testWithMultiThreadTakeTime).isLessThan(testWithSingleThreadTakeTime);
  }

  private double testWithMultiThreadGetTakeTime(int numberOfTimes) throws InterruptedException {
    long beforeTime = System.currentTimeMillis();
    concurrencyTestWithMultiThread(numberOfTimes);
    long afterTime = System.currentTimeMillis();
    double takeTime = (afterTime - beforeTime) / 1_000.0;
    System.out.println("test with Thread takeTime = " + takeTime);
    return takeTime;
  }

  private void concurrencyTestWithMultiThread(int numberOfTimes) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(10);
    CountDownLatch latch = new CountDownLatch(numberOfTimes);
    for (int i = 0; i < numberOfTimes; i++) {
      service.execute(() -> {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        latch.countDown();
      });
    }
    latch.await();
  }

  private double testWithSingleThreadGetTakeTime(int numberOfTimes) throws InterruptedException {
    long beforeTime = System.currentTimeMillis();
    concurrencyTestWithSingleThreads(numberOfTimes);
    long afterTime = System.currentTimeMillis();
    double takeTime = (afterTime - beforeTime) / 1_000.0;
    System.out.println("test with No Thread takeTime = " + takeTime);
    return takeTime;
  }

  private void concurrencyTestWithSingleThreads(int numberOfTimes) throws InterruptedException {
    for (int i = 0; i < numberOfTimes; i++) {
      Thread.sleep(1000);
    }
  }
}
