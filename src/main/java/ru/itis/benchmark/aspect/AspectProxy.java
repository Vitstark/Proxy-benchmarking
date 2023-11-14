package ru.itis.benchmark.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectProxy {

  private int counter = 0;

  @Pointcut("execution(public * ru.itis.benchmark.models.AopComponent.doWork(*))"
            + "|| execution(public * ru.itis.benchmark.models.AopComponent.doWork())")
  public void methodsForAspect() {}

  @Before("methodsForAspect()")
  public void aspect() throws Throwable {
  }
}
