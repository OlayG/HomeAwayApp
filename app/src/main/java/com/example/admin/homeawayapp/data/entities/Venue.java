
package com.example.admin.homeawayapp.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Venue implements Parcelable {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("has_upcoming_events")
    @Expose
    private Boolean hasUpcomingEvents;
    @SerializedName("name_v2")
    @Expose
    private String nameV2;
    @SerializedName("num_upcoming_events")
    @Expose
    private Integer numUpcomingEvents;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("extended_address")
    @Expose
    private String extendedAddress;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("display_location")
    @Expose
    private String displayLocation;

    protected Venue(Parcel in) {
        city = in.readString();
        url = in.readString();
        nameV2 = in.readString();
        slug = in.readString();
        postalCode = in.readString();
        name = in.readString();
        state = in.readString();
        address = in.readString();
        extendedAddress = in.readString();
        timezone = in.readString();
        country = in.readString();
        displayLocation = in.readString();
    }

    public static final Creator<Venue> CREATOR = new Creator<Venue>() {
        @Override
        public Venue createFromParcel(Parcel in) {
            return new Venue(in);
        }

        @Override
        public Venue[] newArray(int size) {
            return new Venue[size];
        }
    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
    }

    public String getNameV2() {
        return nameV2;
    }

    public void setNameV2(String nameV2) {
        this.nameV2 = nameV2;
    }

    public Integer getNumUpcomingEvents() {
        return numUpcomingEvents;
    }

    public void setNumUpcomingEvents(Integer numUpcomingEvents) {
        this.numUpcomingEvents = numUpcomingEvents;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExtendedAddress() {
        return extendedAddress;
    }

    public void setExtendedAddress(String extendedAddress) {
        this.extendedAddress = extendedAddress;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(city);
        parcel.writeString(url);
        parcel.writeString(nameV2);
        parcel.writeString(slug);
        parcel.writeString(postalCode);
        parcel.writeString(name);
        parcel.writeString(state);
        parcel.writeString(address);
        parcel.writeString(extendedAddress);
        parcel.writeString(timezone);
        parcel.writeString(country);
        parcel.writeString(displayLocation);
    }
}
