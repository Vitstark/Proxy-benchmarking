package ru.itis.benchmark;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import ru.itis.benchmark.state.ComponentWrapper;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
public class Benchs {
//  @Benchmark
//  public void benchNative(Blackhole blackhole, ComponentWrapper componentWrapper) {
//    blackhole.consume(componentWrapper.component.doWork());
//  }
//
//  @Benchmark
//  public void benchDynamic(Blackhole blackhole, ComponentWrapper componentWrapper) {
//    blackhole.consume(componentWrapper.dynamicProxy.doWork());
//  }
//
//  @Benchmark
//  public void benchCgLib(Blackhole blackhole, ComponentWrapper componentWrapper) {
//    blackhole.consume(componentWrapper.cglibProxy.doWork());
//  }
//
  @Benchmark
  public void benchAop(Blackhole blackhole, ComponentWrapper componentWrapper) {
    blackhole.consume(componentWrapper.aopProxy.doWork());
  }
//
//  @Benchmark
//  public void invokeReflection(Blackhole blackhole, ComponentWrapper componentWrapper)
//      throws InvocationTargetException, IllegalAccessException {
//    blackhole.consume(componentWrapper.method.invoke(componentWrapper.component));
//  }
//
//
//
//  @Benchmark
//  public void benchNativeFor(Blackhole blackhole, ComponentWrapper componentWrapper) {
//    blackhole.consume(componentWrapper.component.doWork(blackhole));
//  }
//
//  @Benchmark
//  public void benchDynamicFor(Blackhole blackhole, ComponentWrapper componentWrapper) {
//    blackhole.consume(componentWrapper.dynamicProxy.doWork(blackhole));
//  }
//
//  @Benchmark
//  public void benchCgLibFor(Blackhole blackhole, ComponentWrapper componentWrapper) {
//    blackhole.consume(componentWrapper.cglibProxy.doWork(blackhole));
//  }
//
  @Benchmark
  public void benchAopFor(Blackhole blackhole, ComponentWrapper componentWrapper) {
    blackhole.consume(componentWrapper.aopProxy.doWork(blackhole));
  }
//
//  @Benchmark
//  public void invokeReflectionFor(Blackhole blackhole, ComponentWrapper componentWrapper)
//      throws InvocationTargetException, IllegalAccessException {
//    blackhole.consume(componentWrapper.methodFor.invoke(componentWrapper.component, blackhole));
//  }
}
