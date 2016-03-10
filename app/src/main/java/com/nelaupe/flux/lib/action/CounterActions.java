/**
 * Copyright
 */
package com.nelaupe.flux.lib.action;

import com.nelaupe.flux.lib.action.events.OnDecrement;
import com.nelaupe.flux.lib.action.events.OnIncrement;
import com.nelaupe.flux.lib.dispatcher.Dispatcher;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class CounterActions {

    private static CounterActions instance;
    final Dispatcher dispatcher;

    CounterActions(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static CounterActions get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new CounterActions(dispatcher);
        }
        return instance;
    }

    public void increment() {
        dispatcher.post(new OnIncrement());
    }

    public void decrement() {
        dispatcher.post(new OnDecrement());
    }

}
