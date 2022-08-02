package studyjava.hyeonmo.item36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Main {

  enum Test {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
  }

  public static void main(String[] args) {
    long hashSetResult = 0;
    long enumSetResult = 0;

    List<Test> testList = new ArrayList<>(Arrays.stream(Test.values()).toList());
    for (int i = 0; i < 1000; i++) {
      Collections.shuffle(testList);
      int randomSliceIndex = new Random().nextInt(Test.values().length);
      List<Test> testSubList1 = testList.subList(0, randomSliceIndex);
      List<Test> testSubList2 = testList.subList(randomSliceIndex, Test.values().length);
      hashSetResult += getHashSetTakeTime(testSubList1, testSubList2);
      enumSetResult += getEnumSetTakeTime(testSubList1, testSubList2);
    }
    System.out.println("hashSetResult = " + hashSetResult / 1000.0 + "ms");
    System.out.println("enumSetResult = " + enumSetResult / 1000.0 + "ms");
  }

  private static long getHashSetTakeTime(List<Test> testSubList1, List<Test> testSubList2) {
    HashSet<Test> hashSet1 = new HashSet<>(testSubList1);
    HashSet<Test> hashSet2 = new HashSet<>(testSubList2);
    long startTime = System.nanoTime();
    hashSet1.addAll(hashSet2);
    long finishTime = System.nanoTime();
    return finishTime - startTime;
  }

  private static long getEnumSetTakeTime(List<Test> testSubList1, List<Test> testSubList2) {
    EnumSet<Test> enumSet1 = EnumSet.noneOf(Test.class);
    enumSet1.addAll(testSubList1);
    EnumSet<Test> enumSet2 = EnumSet.noneOf(Test.class);
    enumSet1.addAll(testSubList1);
    long startTime = System.nanoTime();
    enumSet1.addAll(enumSet2);
    long finishTime = System.nanoTime();
    return finishTime - startTime;
  }
}
