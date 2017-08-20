package com.erickogi14gmail.rog.Service;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/16/2017.
 */

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<DaysPojo> modelList;

    public DaysAdapter(Context context, ArrayList<DaysPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public DaysAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_days_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DaysAdapter.MyViewHolder holder, int position) {
        DaysPojo daysPojo=modelList.get(position);
        holder.textViewDay.setText(daysPojo.getDay());
        holder.textViewDate.setText(daysPojo.getDate());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDay,textViewDate;
        public MyViewHolder(View itemView) {
            super(itemView);
            textViewDate=(TextView)itemView.findViewById(R.id.txtDate);
            textViewDay=(TextView)itemView.findViewById(R.id.txtDay);
        }
    }
}
