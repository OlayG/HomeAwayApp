package com.example.admin.homeawayapp.view.detailsactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.homeawayapp.R;
import com.example.admin.homeawayapp.data.entities.Event;
import com.example.admin.homeawayapp.view.App;
import com.example.admin.homeawayapp.view.BaseActivity;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import timber.log.Timber;

public class DetailsActivity extends AppCompatActivity implements DetailsActivityContract.View {

    private static final String MY_LIKES = "MY_LIKES";
    @Inject
    DetailsActivityPresenter presenter;
    @Inject
    SharedPreferences preferences;
    @Inject
    Gson gson;
    Event event;
    List<Event> likedEvents;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvVenue)
    TextView tvVenue;
    @BindView(R.id.tvDateTime)
    TextView tvDateTime;
    @BindView(R.id.ivPhoto)
    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        setupDagger();
        activateToolbar(true);
        event = getIntent().getParcelableExtra(BaseActivity.SEATGEEK_EVENT);
        Timber.d("The event is " + event.toString());
        tvTitle.setText(event.getTitle());
        tvVenue.setText(event.getVenue().getDisplayLocation());
        tvDateTime.setText(event.getDatetimeLocal());
        Glide.with(this).load(R.drawable.no_image).into(ivPhoto);
    }

    public void activateToolbar(boolean enableHome) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            Toolbar toolbar = findViewById(R.id.toolbar);

            if (toolbar != null) {
                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();
            }
        }

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(enableHome);
        }
    }


    @DebugLog
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_fav:
                Timber.d("Favorite button has been hit");
                return true;
            case R.id.action_settings:
                Timber.d("Settings button has been hit");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupDagger() {
        DaggerDetailsActivityComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .detailsActivityModule(new DetailsActivityModule(this))
                .build().inject(this);
    }


}
