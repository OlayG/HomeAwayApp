package com.example.admin.homeawayapp.view.mainactivity;


import com.example.admin.homeawayapp.data.component.NetComponent;
import com.example.admin.homeawayapp.util.CustomScope;

import dagger.Component;

@CustomScope
@Component( dependencies = {NetComponent.class}, modules = {MainActivityModule.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
