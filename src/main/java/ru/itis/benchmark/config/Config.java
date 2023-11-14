package ru.itis.benchmark.config;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.itis.benchmark.models.MyComponent;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
    "ru.itis.benchmark.aspect",
    "ru.itis.benchmark.models"
})
public class Config {

  public static final Integer ITER_COUNT = 10_000;

  @Bean
  public MyComponent dynamicProxyBean(@Qualifier("nativeBean") MyComponent myComponent) {
    return (MyComponent) Proxy.newProxyInstance(myComponent.getClass().getClassLoader(),
        myComponent.getClass().getInterfaces(),
        (proxy, method, args) -> method.invoke(myComponent, args));
  }

  @Bean
  public MyComponent sglibProxyBean(@Qualifier("nativeBean") MyComponent myComponent) {
    return (MyComponent) Enhancer.create(myComponent.getClass().getInterfaces()[0],
        new MethodInterceptor() {
          @Override
          public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
              throws Throwable {
            return method.invoke(myComponent, args);
          }
        });
  }
}
