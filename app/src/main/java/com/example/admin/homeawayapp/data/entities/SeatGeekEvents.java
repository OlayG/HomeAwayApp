
package com.example.admin.homeawayapp.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeatGeekEvents {

    @SerializedName("events")
    @Expose
    private List<Event> events = null;
    @SerializedName("in_hand")
    @Expose
    private InHand inHand;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public InHand getInHand() {
        return inHand;
    }

    public void setInHand(InHand inHand) {
        this.inHand = inHand;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
