package com.example.admin.homeawayapp.view.mainactivity;

import com.example.admin.homeawayapp.util.CustomScope;

import dagger.Module;
import dagger.Provides;

@Module
class MainActivityModule {
    private final MainActivityContract.View view;

    public MainActivityModule(MainActivityContract.View view) {
        this.view = view;
    }

    @Provides
    @CustomScope
    MainActivityContract.View providesMainActivityContractView() {
        return view;
    }
}
