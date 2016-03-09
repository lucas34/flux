/**
 * Copyright
 */
package com.nelaupe.flux.lib.dispatcher;

import com.nelaupe.flux.lib.action.events.Event;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class Bus {

    private final Subject<Event, Event> bus = new SerializedSubject<>(PublishSubject.<Event>create());

    public void post(Event o) {
        bus.onNext(o);
    }

    public Observable<Event> events() {
        return bus.asObservable();
    }

}