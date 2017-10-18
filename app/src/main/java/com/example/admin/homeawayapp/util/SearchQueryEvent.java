package com.example.admin.homeawayapp.util;

public class SearchQueryEvent {

    final String queryText;

    public SearchQueryEvent(String queryText) {
        this.queryText = queryText;
    }

    public String getQueryText() {
        return queryText;
    }
}
