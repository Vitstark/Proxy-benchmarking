package ru.itis.benchmark.state;

import java.lang.reflect.Method;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.benchmark.config.Config;
import ru.itis.benchmark.models.MyComponent;

@State(Scope.Benchmark)
public class ComponentWrapper {

  private static final ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(Config.class);

  public ApplicationContext context;
  public MyComponent component;
  public MyComponent dynamicProxy;
  public MyComponent cglibProxy;
  public MyComponent aopProxy;
  public Method method;
  public Method methodFor;

  public ComponentWrapper() {
    try {
      setUp();
    }
    catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  public void setUp() throws NoSuchMethodException {
    this.component = CONTEXT.getBean("nativeBean", MyComponent.class);
    this.dynamicProxy = CONTEXT.getBean("dynamicProxyBean", MyComponent.class);
    this.cglibProxy = CONTEXT.getBean("sglibProxyBean", MyComponent.class);
    this.aopProxy = CONTEXT.getBean("aopProxyBean", MyComponent.class);
    this.method = component.getClass().getMethod("doWork");
    this.methodFor = component.getClass().getMethod("doWork", Blackhole.class);
    System.out.println();
    System.out.println("native class: " + component.getClass().getName());
    System.out.println("dynamicProxy class: " + dynamicProxy.getClass().getName());
    System.out.println("cglibProxy class: " + cglibProxy.getClass().getName());
    System.out.println("aopPostCompileProxy class: " + aopProxy.getClass().getName());
  }
}
