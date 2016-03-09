/**
 * Copyright
 */
package com.nelaupe.flux.plugins;

import android.util.Log;

import com.nelaupe.flux.lib.dispatcher.Dispatcher;
import com.nelaupe.flux.lib.action.events.Event;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class Logger extends Plugin {

    @Override
    Subscription onRegister(Dispatcher dispatcher) {
        return dispatcher.raw().subscribe(new Action1<Event>() {
            @Override
            public void call(Event event) {
                Log.d("LOGGER", event.toString());
            }
        });
    }

}
