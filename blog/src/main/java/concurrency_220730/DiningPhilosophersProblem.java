package concurrency_220730;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersProblem {

  public static void main(String[] args) {

    Philosopher a = new Philosopher("A", 0);
    Philosopher b = new Philosopher("B", 1);
    Philosopher c = new Philosopher("C", 2);
    Philosopher d = new Philosopher("D", 3);
    Philosopher e = new Philosopher("E", 4);

    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(a);
    exec.execute(b);
    exec.execute(c);
    exec.execute(d);
    exec.execute(e);
  }

  static class Fork {

    Lock lock = new ReentrantLock();

    public void useFork() {
      lock.lock();
    }

    public void unUseFork() {
      lock.unlock();
    }
  }

  static class Table {

    public static final List<Fork> forks = new ArrayList<>();

    static {
      forks.add(new Fork());
      forks.add(new Fork());
      forks.add(new Fork());
      forks.add(new Fork());
      forks.add(new Fork());
    }
  }

  static class Philosopher implements Runnable {

    public static final Semaphore semaphore = new Semaphore(4); // 총 철학자 수인 5를 넘어서면 안됨.
    private String name;
    private int number;

    public Philosopher(String name, int number) {
      this.name = name;
      this.number = number;
    }

    public void think() {
      print(name + " thinking ...");
    }

    public void eat() {
      print(name + " eating ... yum-yum-yum");
    }

    public void takeFork(int i) {

      print(name + " attemp to take (" + i + ") fork ...");

      Fork fork = Table.forks.get(i);
      fork.useFork();

      print(name + " take (" + i + ") fork now!");
    }

    public void putFork(int i) {

      print(name + " put (" + i + ") fork down ...");

      Fork fork = Table.forks.get(i);
      fork.unUseFork();
    }

    @Override
    public void run() {
      while (true) {
        try {
          semaphore.acquire();
          think();
          takeFork(this.number);
          takeFork((this.number + 1) % 5);
          eat();
          putFork(this.number);
          putFork((this.number + 1) % 5);
          semaphore.release();
        } catch (InterruptedException e) {
          System.out.println("Interrupt Occured!!");
        }
      }
    }

    private void print(String s) {
      System.out.println(s);
    }
  }
}
