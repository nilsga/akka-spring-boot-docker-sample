package com.bekk.akka.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    @Bean
    ActorSystem actorSystem() {
        return ActorSystem.create("DemoAkka");
    }

    @Bean
    ActorRef otherActor() {
        return actorSystem().actorOf(OtherActor.mkProps());
    }

    @Bean
    ActorRef testActor() {
        return actorSystem().actorOf(TestActor.mkProps(otherActor()));
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("Starting the app");
        testActor().tell(new TestActor.TestMessage(), ActorRef.noSender());
    }
}
