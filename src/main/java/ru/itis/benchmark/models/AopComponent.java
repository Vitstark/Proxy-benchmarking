package ru.itis.benchmark.models;

import org.openjdk.jmh.infra.Blackhole;
import org.springframework.stereotype.Component;

import static ru.itis.benchmark.config.Config.ITER_COUNT;

@Component("aopProxyBean")
public class AopComponent implements MyComponent {
  int counter = 0;

  @Override
  public int doWork() {
    counter += counter == 0 ? 2 : 1;
    return counter;
  }

  @Override
  public int doWork(Blackhole blackhole) {
    for (int i = 0; i < ITER_COUNT; i++) {
      counter += i % 2 == 0 ? 2 : 1;
      blackhole.consume(i);
    }
    return counter;
  }
}
