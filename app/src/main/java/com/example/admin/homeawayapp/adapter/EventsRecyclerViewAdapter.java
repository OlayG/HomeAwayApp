package com.example.admin.homeawayapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.homeawayapp.R;
import com.example.admin.homeawayapp.data.entities.Event;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.EventsViewHolder> {
    private List<Event> events;
    private Context context;

    public EventsRecyclerViewAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @DebugLog
    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_cardview_item, parent, false);
        return new EventsViewHolder(view);
    }

    @DebugLog
    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        Event event = events.get(position);

        holder.tvTitle.setText(event.getTitle());
        holder.tvVenue.setText(event.getVenue().getDisplayLocation());
        holder.tvDateTime.setText(event.getDatetimeLocal());

        Glide.with(context).load(R.drawable.no_image).into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    @DebugLog
    public void loadNewData(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @DebugLog
    public Event getEvent(int position){
        return ((events != null) && (events.size() != 0) ? events.get(position) : null);
    }

    static class EventsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvVenue)
        TextView tvVenue;
        @BindView(R.id.tvDateTime)
        TextView tvDateTime;
        @BindView(R.id.ivPhoto)
        ImageView ivPhoto;

        public EventsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
