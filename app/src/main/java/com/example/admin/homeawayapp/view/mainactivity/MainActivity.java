package com.example.admin.homeawayapp.view.mainactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin.homeawayapp.R;
import com.example.admin.homeawayapp.adapter.EventsRecyclerViewAdapter;
import com.example.admin.homeawayapp.data.entities.Event;
import com.example.admin.homeawayapp.util.RecyclerItemClickListener;
import com.example.admin.homeawayapp.util.SearchQueryEvent;
import com.example.admin.homeawayapp.view.App;
import com.example.admin.homeawayapp.view.BaseActivity;
import com.example.admin.homeawayapp.view.detailsactivity.DetailsActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements MainActivityContract.View, RecyclerItemClickListener.OnRecyclerClickListener  {

    @Inject
    MainActivityPresenter presenter;
    @Inject
    SharedPreferences preferences;
    @BindView(R.id.rvSearchList)
    RecyclerView rvSearchList;
    private EventsRecyclerViewAdapter eventsRecyclerViewAdapter;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activateToolbar(false);
        setupDagger();
        setupRecyclerView();
    }

    @DebugLog
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @DebugLog
    @Override
    protected void onResume() {
        super.onResume();
        String queryResult = preferences.getString(SEATGEEK_QUERY, "");

        if(!queryResult.isEmpty())
            presenter.loadData(queryResult);
        else
            presenter.loadData("Texas Rangers");
    }

    @DebugLog
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @DebugLog
    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvSearchList.getContext(), layoutManager.getOrientation());
        rvSearchList.setLayoutManager(layoutManager);
        rvSearchList.addOnItemTouchListener(new RecyclerItemClickListener(this, rvSearchList, this));
        rvSearchList.setLayoutTransition(null);
        rvSearchList.addItemDecoration(dividerItemDecoration);
        eventsRecyclerViewAdapter = new EventsRecyclerViewAdapter(new ArrayList<Event>(), this);
        rvSearchList.setAdapter(eventsRecyclerViewAdapter);
    }

    private void setupDagger() {
        DaggerMainActivityComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
    }

    @DebugLog
    @Override
    public void showData(List<Event> events) {
        eventsRecyclerViewAdapter.loadNewData(events);
    }

    @Override
    public void showError(String error) {

    }

    @DebugLog
    @Override
    public void showComplete() {

    }

    @DebugLog
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSearchQueryEvent(SearchQueryEvent queryEvent) {
        presenter.loadData(queryEvent.getQueryText());
    }

    @DebugLog
    @Override
    public void onItemClick(View view, int position) {
        Timber.d("The event normal clicked is: " + eventsRecyclerViewAdapter.getEvent(position).toString());
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(SEATGEEK_EVENT , eventsRecyclerViewAdapter.getEvent(position));
        startActivity(intent);
    }

    @DebugLog
    @Override
    public void onItemLongClick(View view, int position) {
        Timber.d("The event long clicked is: " + eventsRecyclerViewAdapter.getEvent(position).toString());
    }
}
