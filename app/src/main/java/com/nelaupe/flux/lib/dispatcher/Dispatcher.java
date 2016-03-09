/**
 * Copyright
 */
package com.nelaupe.flux.lib.dispatcher;

import com.nelaupe.flux.lib.action.events.Event;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class Dispatcher {
    private final Bus bus;
    private static Dispatcher instance;

    public static Dispatcher get(Bus bus) {
        if (instance == null) {
            instance = new Dispatcher(bus);
        }
        return instance;
    }

    Dispatcher(Bus bus) {
        this.bus = bus;
    }

    public <T> Subscription register(Class<T> klass, Action1<T> action1) {
        return bus.events().ofType(klass).subscribe(action1);
    }

    public Observable<Event> raw() {
        return bus.events();
    }

    public void post(final Event event) {
        bus.post(event);
    }

}