package com.example.admin.homeawayapp.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event implements Parcelable {

    @SerializedName("short_title")
    @Expose
    private String shortTitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("datetime_local")
    @Expose
    private String datetimeLocal;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("announce_date")
    @Expose
    private String announceDate;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("visible_until_utc")
    @Expose
    private String visibleUntilUtc;
    @SerializedName("taxonomies")
    @Expose
    private List<Taxonomy> taxonomies = null;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("datetime_tbd")
    @Expose
    private Boolean datetimeTbd;
    @SerializedName("time_tbd")
    @Expose
    private Boolean timeTbd;
    @SerializedName("performers")
    @Expose
    private List<Performer> performers = null;
    @SerializedName("is_open")
    @Expose
    private Boolean isOpen;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("datetime_utc")
    @Expose
    private String datetimeUtc;
    @SerializedName("date_tbd")
    @Expose
    private Boolean dateTbd;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;

    protected Event(Parcel in) {
        shortTitle = in.readString();
        title = in.readString();
        datetimeLocal = in.readString();
        type = in.readString();
        announceDate = in.readString();
        url = in.readString();
        venue = in.readParcelable(getClass().getClassLoader());
        visibleUntilUtc = in.readString();
        datetimeUtc = in.readString();
        createdAt = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatetimeLocal() {
        return datetimeLocal;
    }

    public void setDatetimeLocal(String datetimeLocal) {
        this.datetimeLocal = datetimeLocal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVisibleUntilUtc() {
        return visibleUntilUtc;
    }

    public void setVisibleUntilUtc(String visibleUntilUtc) {
        this.visibleUntilUtc = visibleUntilUtc;
    }

    public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Boolean getDatetimeTbd() {
        return datetimeTbd;
    }

    public void setDatetimeTbd(Boolean datetimeTbd) {
        this.datetimeTbd = datetimeTbd;
    }

    public Boolean getTimeTbd() {
        return timeTbd;
    }

    public void setTimeTbd(Boolean timeTbd) {
        this.timeTbd = timeTbd;
    }

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
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

    public String getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(String datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public Boolean getDateTbd() {
        return dateTbd;
    }

    public void setDateTbd(Boolean dateTbd) {
        this.dateTbd = dateTbd;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Event{" +
                "shortTitle='" + shortTitle + '\'' +
                ", title='" + title + '\'' +
                ", datetimeLocal='" + datetimeLocal + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", venue=" + venue +
                ", announceDate='" + announceDate + '\'' +
                ", url='" + url + '\'' +
                ", visibleUntilUtc='" + visibleUntilUtc + '\'' +
                ", taxonomies=" + taxonomies +
                ", stats=" + stats +
                ", datetimeTbd=" + datetimeTbd +
                ", timeTbd=" + timeTbd +
                ", performers=" + performers +
                ", isOpen=" + isOpen +
                ", score=" + score +
                ", popularity=" + popularity +
                ", datetimeUtc='" + datetimeUtc + '\'' +
                ", dateTbd=" + dateTbd +
                ", createdAt='" + createdAt + '\'' +
                ", links=" + links +
                '}' + "\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(shortTitle);
        parcel.writeString(title);
        parcel.writeString(datetimeLocal);
        parcel.writeString(type);
        parcel.writeString(announceDate);
        parcel.writeString(url);
        parcel.writeParcelable(venue, i);
        parcel.writeString(visibleUntilUtc);
        parcel.writeString(datetimeUtc);
        parcel.writeString(createdAt);
    }
}
