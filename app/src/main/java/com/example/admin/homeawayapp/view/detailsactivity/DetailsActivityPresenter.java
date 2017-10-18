package com.example.admin.homeawayapp.view.detailsactivity;

import javax.inject.Inject;

public class DetailsActivityPresenter implements DetailsActivityContract.Presenter {
    DetailsActivityContract.View view;

    @Inject
    public DetailsActivityPresenter(DetailsActivityContract.View view) {
        this.view = view;
    }
}
