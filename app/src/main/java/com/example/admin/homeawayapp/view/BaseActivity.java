package com.example.admin.homeawayapp.view;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.admin.homeawayapp.R;
import com.example.admin.homeawayapp.util.SearchQueryEvent;

import org.greenrobot.eventbus.EventBus;

import hugo.weaving.DebugLog;

/**
 * Created by Olay G on 10/16/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public static final String SEATGEEK_PATH = "events/";
    public static final String SEATGEEK_CLIENT_ID = "OTI5MTQwOXwxNTA4MjUzMTg3LjUy";
    public static final String SEATGEEK_CLIENT_SECRET = "ac773f0051b2f93a8568e57a55bf5bf25d9118106122b95a0298ebe029519040";
    public static final String SEATGEEK_QUERY = "SEATGEEK_QUERY";
    public static final String SEATGEEK_EVENT = "SEATGEEK_EVVENT";

    private SearchView searchView;


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());
        searchView.setSearchableInfo(searchableInfo);
        searchView.setIconified(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @DebugLog
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.onActionViewCollapsed();
                searchView.clearFocus();
                EventBus.getDefault().post(new SearchQueryEvent(query));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                EventBus.getDefault().post(new SearchQueryEvent(query));
                return true;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });
        return true;
    }
}
