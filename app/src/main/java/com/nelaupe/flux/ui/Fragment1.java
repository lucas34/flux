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
import com.nelaupe.flux.lib.action.CounterActions;
import com.nelaupe.flux.lib.dispatcher.Bus;
import com.nelaupe.flux.lib.dispatcher.Dispatcher;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    private int counter;
    private TextView state;
    private CounterActions actions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        counter = 0;
        Dispatcher dispatcher = Dispatcher.get(new Bus());
        actions = CounterActions.get(dispatcher);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        state = (TextView) view.findViewById(R.id.state);

        view.findViewById(R.id.increment).setOnClickListener(this);
        view.findViewById(R.id.decrement).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.increment: {
                counter++;
                state.setText(String.valueOf(counter));
                actions.increment();
                break;
            }

            case R.id.decrement: {
                counter--;
                state.setText(String.valueOf(counter));
                actions.decrement();
                break;
            }
        }
    }
}
