package ru.itis.benchmark.models;

import org.openjdk.jmh.infra.Blackhole;

public interface MyComponent {
  int doWork();

  int doWork(Blackhole blackhole);
}
