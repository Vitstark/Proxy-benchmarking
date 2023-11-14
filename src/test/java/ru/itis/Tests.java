package ru.itis;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.*;

public class Tests {
  private final int N = 100_000_000;
  private Map<Integer, Integer> map = new TreeMap<>();
  private long startNanoTime;

  @BeforeEach
  public void start() {
    startNanoTime = System.currentTimeMillis();
  }

  @AfterEach
  public void end() {
    System.out.println(System.currentTimeMillis() - startNanoTime);
  }

//  @Test
//  public void test() throws InterruptedException {
//    for (int i = 0; i < N; i++) {
//      map.put(i, i);
//    }
//    System.out.println("Filled");
//    System.gc();
//    System.out.println("Awake");
//    for (int i = N - 1; i >= 10; i--) {
//      map.remove(i);
//    }
//    System.out.println("Cleared, size: " + map.size());
//    System.gc();
//    map.clear();
//  }
}
