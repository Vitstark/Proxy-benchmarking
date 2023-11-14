package ru.itis.benchmark.state;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.benchmark.config.Config;

public class ContextState {
  public static final ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(Config.class);
}
