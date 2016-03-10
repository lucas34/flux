/**
 * Copyright
 */
package com.nelaupe.flux.plugins;

import android.util.Log;

import com.nelaupe.flux.lib.dispatcher.Dispatcher;

import rx.Subscription;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class Logger extends Plugin {

    @Override
    Subscription onRegister(Dispatcher dispatcher) {
        return dispatcher.raw().subscribe(event -> {
            Log.d("LOGGER", event.toString());
        });
    }

}
