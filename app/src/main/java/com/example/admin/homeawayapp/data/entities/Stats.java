
package com.example.admin.homeawayapp.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("highest_price")
    @Expose
    private Object highestPrice;
    @SerializedName("average_price")
    @Expose
    private Object averagePrice;
    @SerializedName("listing_count")
    @Expose
    private Object listingCount;
    @SerializedName("lowest_price_good_deals")
    @Expose
    private Object lowestPriceGoodDeals;
    @SerializedName("lowest_price")
    @Expose
    private Object lowestPrice;

    public Object getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Object highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Object getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Object averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Object getListingCount() {
        return listingCount;
    }

    public void setListingCount(Object listingCount) {
        this.listingCount = listingCount;
    }

    public Object getLowestPriceGoodDeals() {
        return lowestPriceGoodDeals;
    }

    public void setLowestPriceGoodDeals(Object lowestPriceGoodDeals) {
        this.lowestPriceGoodDeals = lowestPriceGoodDeals;
    }

    public Object getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Object lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

}
