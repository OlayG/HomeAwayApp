package com.example.admin.homeawayapp.data.component;

import com.example.admin.homeawayapp.data.module.AppModule;
import com.example.admin.homeawayapp.view.App;

import dagger.Component;

@Component( modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);
}
