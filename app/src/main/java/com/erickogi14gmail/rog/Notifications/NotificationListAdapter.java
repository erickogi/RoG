package com.erickogi14gmail.rog.Notifications;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/22/2017.
 */

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.MyViewHolder> {
    Context context;
    private ArrayList<NotificationsPojo> modelList;

    public NotificationListAdapter(Context context, ArrayList<NotificationsPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public NotificationListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

           itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifications_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    NotificationsPojo notificationsPojo=modelList.get(position);
        holder.textView_list_title.setText(notificationsPojo.getNotification_title());
        holder.textView_list_message.setText(notificationsPojo.getNotification_message());
        holder.textView_list_date.setText(notificationsPojo.getNotification_date());
        holder.textView_list_department.setText(notificationsPojo.getNotification_department());
    }
    public void updateList(ArrayList<NotificationsPojo> list){
        modelList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_list_title,
                textView_list_message,
                textView_list_date,
                textView_list_department;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);

            textView_list_title = (TextView) itemView.findViewById(R.id.notification_title);
            textView_list_message = (TextView) itemView.findViewById(R.id.notification_message);
            textView_list_date = (TextView) itemView.findViewById(R.id.txt_date);
            textView_list_department= (TextView) itemView.findViewById(R.id.txt_department);
            imageView=(ImageView)itemView.findViewById(R.id.notification_image);

        }
    }
}
