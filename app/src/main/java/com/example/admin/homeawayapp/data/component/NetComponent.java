package com.example.admin.homeawayapp.data.component;

import android.content.SharedPreferences;

import com.example.admin.homeawayapp.data.module.AppModule;
import com.example.admin.homeawayapp.data.module.NetModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component( modules = {AppModule.class, NetModule.class} )
public interface NetComponent {

    Retrofit retrofit();
    SharedPreferences preferences();
    Gson gson();
}
