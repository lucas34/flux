/**
 * Copyright
 */
package com.nelaupe.flux.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nelaupe.flux.R;
import com.nelaupe.flux.lib.dispatcher.Bus;
import com.nelaupe.flux.lib.dispatcher.Dispatcher;
import com.nelaupe.flux.lib.store.CounterState;

import rx.functions.Action1;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class Fragment2 extends Fragment implements Action1<CounterState.CounterUpdate> {

    private TextView state;
    private CounterState store;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Dispatcher dispatcher = Dispatcher.get(new Bus());
        store = CounterState.get(dispatcher);

        dispatcher.register(CounterState.CounterUpdate.class, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        state = (TextView) view.findViewById(R.id.state);

    }

    @Override
    public void call(CounterState.CounterUpdate storeUpdate) {
        state.setText(store.getCounter());
    }
}
