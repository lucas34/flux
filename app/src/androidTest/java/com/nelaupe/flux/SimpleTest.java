/**
 * Copyright
 */
package com.nelaupe.flux;

import android.test.InstrumentationTestCase;

import com.nelaupe.flux.lib.action.CounterActions;
import com.nelaupe.flux.lib.dispatcher.Dispatcher;
import com.nelaupe.flux.lib.dispatcher.Bus;
import com.nelaupe.flux.lib.store.CounterState;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class SimpleTest extends InstrumentationTestCase {

    public void testFoo() {

        Dispatcher dispatcher = Dispatcher.get(new Bus());
        CounterActions actionsCreator = CounterActions.get(dispatcher);
        CounterState store = CounterState.get(dispatcher);

        actionsCreator.startTyping();
        assertTrue(store.getCounter());

        actionsCreator.stopTyping();
        assertFalse(store.getCounter());
    }

}
