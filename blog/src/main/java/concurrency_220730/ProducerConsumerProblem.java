package concurrency_220730;

public class ProducerConsumerProblem {

  public static void main(String[] args) {
    Channel c = new Channel();
    Producer p1 = new Producer(c, 1);
    Consumer c1 = new Consumer(c, 1);
    p1.start();
    c1.start();
  }

  static class Channel {

    private int data;
    private boolean available = false;

    public synchronized int get() {
      while (!available) {
        try {
          wait();
        } catch (InterruptedException ignored) {
        }
      }
      available = false;
      notifyAll();
      return data;
    }

    public synchronized void put(int value) {
      while (available) {
        try {
          wait();
        } catch (InterruptedException ignored) {
        }
      }
      data = value;
      available = true;
      notifyAll();
    }
  }

  static class Consumer extends Thread {

    private final Channel channel;
    private final int number;

    public Consumer(Channel c, int number) {
      channel = c;
      this.number = number;
    }

    @Override
    public void run() {
      int value = 0;
      for (int i = 0; i < 5; i++) {
        value = channel.get();
        System.out.println("get #" + this.number + " get: " + value);
      }
    }
  }

  static class Producer extends Thread {

    private final Channel channel;
    private final int number;

    public Producer(Channel c, int number) {
      channel = c;
      this.number = number;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        channel.put(i);
        System.out.println("put #" + this.number + " put: " + i);
        try {
          sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
      }
    }
  }

}
