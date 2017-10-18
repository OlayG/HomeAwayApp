package com.example.admin.homeawayapp.view;

import android.app.Application;

import com.example.admin.homeawayapp.BuildConfig;
import com.example.admin.homeawayapp.data.component.DaggerNetComponent;
import com.example.admin.homeawayapp.data.component.NetComponent;
import com.example.admin.homeawayapp.data.module.AppModule;
import com.example.admin.homeawayapp.data.module.NetModule;

import timber.log.Timber;

public class App extends Application {

    public static final String SEATGEEK_BASE_URL = "https://api.seatgeek.com/2/";

    // https://api.seatgeek.com/2
    // /events
    // ?client_id=OTI5MTQwOXwxNTA4MjUzMTg3LjUy
    // &client_secret=ac773f0051b2f93a8568e57a55bf5bf25d9118106122b95a0298ebe029519040
    // &q=Texas+Ranger
    private NetComponent component;


    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger();
        setupTimber();
    }

    private void setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void setupDagger() {
        component = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(SEATGEEK_BASE_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return component;
    }
}
