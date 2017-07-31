package com.erickogi14gmail.rog.Events;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.erickogi14gmail.rog.Notifications.NotificationsPojo;
import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/23/2017.
 */

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<EventsPojo> modelList;

    public EventsListAdapter(Context context, ArrayList<EventsPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public EventsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_list, parent, false);
        return new EventsListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventsPojo eventsPojo=modelList.get(position);
        holder.txtTitle.setText(eventsPojo.getEvent_title());
        holder.txtPreview.setText(eventsPojo.getEvent_preview());
        holder.txtDate.setText(eventsPojo.getEvent_date());
        holder.txtTime.setText(eventsPojo.getEvent_time());
        holder.txtPlace.setText(eventsPojo.getEvent_place());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtPreview,txtDate,txtTime,txtPlace;
        ImageView imageView;
        public MyViewHolder(View itemView) {


            super(itemView);
            txtTitle=(TextView)itemView.findViewById(R.id.event_title);
            txtPreview=(TextView)itemView.findViewById(R.id.event_preview);
            txtDate=(TextView)itemView.findViewById(R.id.event_date);
            txtTime=(TextView)itemView.findViewById(R.id.event_time);
            txtPlace=(TextView)itemView.findViewById(R.id.event_place);
            imageView=(ImageView)itemView.findViewById(R.id.event_image);

        }
    }
}
