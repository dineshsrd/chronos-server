package com.scheduler.chronos;

import org.springframework.boot.SpringApplication;

public class TestChronosServerApplication {

    public static void main(String[] args) {
        SpringApplication.from(ChronosServerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
