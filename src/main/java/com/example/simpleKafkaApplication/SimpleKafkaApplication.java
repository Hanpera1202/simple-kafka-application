package com.example.simpleKafkaApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleKafkaApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SimpleKafkaApplication.class);

    @Autowired
    SimpleKafkaConsumer simpleKafkaConsumer;

    public static void main( String[] args ) {
        SpringApplication.run(SimpleKafkaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Thread kafkaConsumerThread = new Thread(() -> {
            simpleKafkaConsumer.runSingleWorker();
        });

        kafkaConsumerThread.start();
    }

}
