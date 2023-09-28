package com.betrybe.agrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Application main class.
 */
@SpringBootApplication
@EnableJpaRepositories
public class AgrixApplication {

  public static void main(String[] args) {
    SpringApplication.run(AgrixApplication.class, args);
  }

}
