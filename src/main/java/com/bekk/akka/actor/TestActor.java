package com.bekk.akka.actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

import static akka.japi.pf.ReceiveBuilder.match;

public class TestActor extends AbstractActor {

    public static Props mkProps(ActorRef actorThisActorDependsOn) {
        return Props.create(TestActor.class, () -> new TestActor(actorThisActorDependsOn));
    }

    public TestActor(ActorRef actorThisActorDependsOn) {
        receive(match(TestMessage.class, msg -> System.out.println("Received message " + msg)).build());
    }

    public static class TestMessage {}
}
