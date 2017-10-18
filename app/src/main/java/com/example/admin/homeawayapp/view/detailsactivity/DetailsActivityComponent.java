package com.example.admin.homeawayapp.view.detailsactivity;

import com.example.admin.homeawayapp.data.component.NetComponent;
import com.example.admin.homeawayapp.util.CustomScope;

import dagger.Component;

@CustomScope
@Component(dependencies = {NetComponent.class}, modules = {DetailsActivityModule.class})
public interface DetailsActivityComponent {
    void inject(DetailsActivity detailsActivity);
}
