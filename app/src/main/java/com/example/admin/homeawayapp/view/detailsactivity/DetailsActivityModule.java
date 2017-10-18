package com.example.admin.homeawayapp.view.detailsactivity;

import com.example.admin.homeawayapp.util.CustomScope;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsActivityModule {
    private final DetailsActivityContract.View view;

    public DetailsActivityModule(DetailsActivityContract.View view) {
        this.view = view;
    }

    @Provides
    @CustomScope
    DetailsActivityContract.View presentsDetailsActivityContractView() {
        return view;
    }
}
