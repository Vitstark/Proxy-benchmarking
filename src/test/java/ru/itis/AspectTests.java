package ru.itis;

import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.benchmark.config.Config;
import ru.itis.benchmark.models.MyComponent;

public class AspectTests {
  private static final int N = 100_000;
  private static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
  private static MyComponent component;
  private static long start;
  private static long time;

  @BeforeAll
  public static void beforeAll() {
    component = context.getBean(MyComponent.class);
    System.out.println(component.getClass().getName());
  }

  @BeforeEach
  public void start() {
    start = System.nanoTime() / 1000;
  }

//  @Test
//  @RepeatedTest(N)
//  public void test() {
//    component.doWork();
//  }

  @AfterEach
  public void end() {
    time += System.nanoTime() / 1000 - start;
  }

  @AfterAll
  public static void afterAll() {
    System.out.printf("avg time = %d%n", time / N);
  }
}
