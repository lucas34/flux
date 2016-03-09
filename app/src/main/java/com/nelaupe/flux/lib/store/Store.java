/**
 * Copyright
 */
package com.nelaupe.flux.lib.store;

import com.nelaupe.flux.lib.dispatcher.Dispatcher;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class Store {

    final Dispatcher dispatcher;

    protected Store(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

}
