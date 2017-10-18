package com.example.admin.homeawayapp.view.mainactivity;

import com.example.admin.homeawayapp.data.entities.SeatGeekEvents;
import com.example.admin.homeawayapp.view.BaseActivity;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import timber.log.Timber;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    Retrofit retrofit;
    MainActivityContract.View view;

    @Inject
    public MainActivityPresenter(Retrofit retrofit, MainActivityContract.View view){
        this.retrofit = retrofit;
        this.view = view;
        Timber.tag("MainActivityPresenter");
    }
    @Override
    public void loadData(String searchText) {
        Timber.d("loadData Starts, query string is: " + searchText);
        retrofit.create(SeatGeekService.class).observableEvents(searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<SeatGeekEvents>() {
                    @DebugLog
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @DebugLog
                    @Override
                    public void onNext(SeatGeekEvents value) {
                        Timber.d("List of events are " + value.getEvents().toString());
                        view.showData(value.getEvents());
                    }

                    @DebugLog
                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @DebugLog
                    @Override
                    public void onComplete() {

                    }
                });
    }

    private interface SeatGeekService {
        @GET(BaseActivity.SEATGEEK_PATH)
        Observable<SeatGeekEvents> observableEvents(@Query("q") String query);
    }
}
