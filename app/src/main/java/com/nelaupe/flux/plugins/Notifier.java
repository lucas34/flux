/**
 * Copyright
 */
package com.nelaupe.flux.plugins;

import android.content.Context;
import android.widget.Toast;

import com.nelaupe.flux.lib.action.events.Event;
import com.nelaupe.flux.lib.action.events.OnDecrement;
import com.nelaupe.flux.lib.action.events.OnIncrement;
import com.nelaupe.flux.lib.dispatcher.Dispatcher;

import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class Notifier extends Plugin implements Action1<Event> {

    private Context context;

    public Notifier(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    Subscription onRegister(Dispatcher dispatcher) {
        return dispatcher.raw()
                .ofType(OnDecrement.class)
                .cast(Event.class)
                .mergeWith(dispatcher.raw().ofType(OnIncrement.class).cast(Event.class))
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void call(Event event) {
        Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show();
    }
}
