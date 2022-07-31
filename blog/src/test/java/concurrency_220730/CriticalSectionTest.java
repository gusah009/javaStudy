package concurrency_220730;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

public class CriticalSectionTest {

  @Test
  void criticalSectionTest() throws InterruptedException {
    int numberOfTimes = 1000;
    ExecutorService service = Executors.newFixedThreadPool(10);
    CountDownLatch latch = new CountDownLatch(numberOfTimes);
    Counter counter = new Counter();
    for (int i = 0; i < numberOfTimes; i++) {
      service.execute(() -> {
        for (int j = 0; j < numberOfTimes; j++) {
          counter.count += 1;
        }
        latch.countDown();
      });
    }
    latch.await();
    System.out.println("counter.count = " + counter.count); // 311517
    assertThat(counter.count).isNotEqualTo(numberOfTimes * numberOfTimes);
  }

  private class Counter {

    int count = 0;
  }
}
