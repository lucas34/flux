package com.nelaupe.flux;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nelaupe.flux.lib.dispatcher.Bus;
import com.nelaupe.flux.lib.dispatcher.Dispatcher;
import com.nelaupe.flux.plugins.Logger;
import com.nelaupe.flux.plugins.Notifier;

public class MainActivity extends AppCompatActivity {

    private Notifier toaster;
    private Dispatcher dispatcher;
    private Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dispatcher = Dispatcher.get(new Bus());

        logger = new Logger();
        toaster = new Notifier(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toaster.register(dispatcher);
        logger.register(dispatcher);
    }


    @Override
    protected void onPause() {
        toaster.unregister();
        logger.unregister();
        super.onPause();
    }

}
