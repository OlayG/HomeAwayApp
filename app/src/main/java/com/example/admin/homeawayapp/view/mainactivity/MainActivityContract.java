package com.example.admin.homeawayapp.view.mainactivity;


import com.example.admin.homeawayapp.data.entities.Event;

import java.util.List;

public interface MainActivityContract {

    interface View  {

        void showData(List<Event> events);
        void showError(String error);
        void showComplete();

    }

    interface Presenter {

        void loadData(String searchText);
    }
}
