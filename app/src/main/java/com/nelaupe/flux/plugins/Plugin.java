/**
 * Copyright
 */
package com.nelaupe.flux.plugins;

import com.nelaupe.flux.lib.dispatcher.Dispatcher;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public abstract class Plugin {

    private CompositeSubscription _subscriptions;

    public Notifier register(Dispatcher dispatcher) {
        _subscriptions = new CompositeSubscription();
        _subscriptions.add(onRegister(dispatcher));
        return null;
    }

    abstract Subscription onRegister(Dispatcher dispatcher);

    public void unregister() {
        if (_subscriptions != null) {
            _subscriptions.unsubscribe();
        }
    }

}



