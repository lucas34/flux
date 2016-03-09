/**
 * Copyright
 */
package com.nelaupe.flux.lib.store;

import com.nelaupe.flux.lib.dispatcher.Dispatcher;
import com.nelaupe.flux.lib.action.events.Event;
import com.nelaupe.flux.lib.action.events.OnDecrement;
import com.nelaupe.flux.lib.action.events.OnIncrement;

import rx.functions.Action1;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class CounterState extends Store {

    private static CounterState instance;
    private int counter;

    protected CounterState(Dispatcher dispatcher) {
        super(dispatcher);
        init();
    }

    public static CounterState get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new CounterState(dispatcher);
        }
        return instance;
    }

    private void init() {

        dispatcher.register(OnIncrement.class, new Action1<OnIncrement>() {
            @Override
            public void call(OnIncrement onStartTyping) {
                counter++;
                notifyUi();
            }
        });

        dispatcher.register(OnDecrement.class, new Action1<OnDecrement>() {
            @Override
            public void call(OnDecrement onFinishTyping) {
                counter--;
                notifyUi();
            }
        });
    }

    public String getCounter() {
        return String.valueOf(counter);
    }

    public void notifyUi() {
        dispatcher.post(new CounterUpdate());
    }

    public static class CounterUpdate extends Event {

        @Override
        public String toString() {
            return "Counter state updated";
        }
    }

}
