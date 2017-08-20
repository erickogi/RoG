package com.erickogi14gmail.rog.Prayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/14/2017.
 */

public class prayerAdapter extends RecyclerView.Adapter<prayerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<prayerPojo> modelList;

    public prayerAdapter(Context context, ArrayList<prayerPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public prayerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.prayer_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(prayerAdapter.MyViewHolder holder, int position) {
        prayerPojo prayerPojo=modelList.get(position);
        holder.textView_list_title.setText(prayerPojo.getPrayer_request_title());
        holder.textView_list_message.setText(prayerPojo.getPrayer_request_text());
        holder.textView_list_date.setText(prayerPojo.getPrayer_request_date());
        holder.textView_list_name.setText(prayerPojo.getPrayer_request_name());

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_list_title,
                textView_list_message,
                textView_list_date,
                textView_list_name;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView_list_title = (TextView) itemView.findViewById(R.id.prayer_title);
            textView_list_message = (TextView) itemView.findViewById(R.id.prayer_message);
            textView_list_date = (TextView) itemView.findViewById(R.id.txt_date);
            textView_list_name= (TextView) itemView.findViewById(R.id.txt_name);
            imageView=(ImageView)itemView.findViewById(R.id.prayer_image);
        }
    }
}
