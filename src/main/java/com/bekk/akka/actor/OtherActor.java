package com.bekk.akka.actor;

import akka.actor.AbstractActor;
import akka.actor.Props;

import static akka.japi.pf.ReceiveBuilder.matchAny;

public class OtherActor extends AbstractActor {

    public static Props mkProps() {
        return Props.create(OtherActor.class);
    }

    public OtherActor() {
        receive(matchAny(System.out::println).build());
    }
}
