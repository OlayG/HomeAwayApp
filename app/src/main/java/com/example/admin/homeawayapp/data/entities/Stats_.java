
package com.example.admin.homeawayapp.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats_ {

    @SerializedName("event_count")
    @Expose
    private Integer eventCount;

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

}
