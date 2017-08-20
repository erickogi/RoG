package com.erickogi14gmail.rog.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class ChatsListAdapter extends RecyclerView.Adapter<ChatsListAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ChatsListPojo> modelList;

    public ChatsListAdapter(Context context, ArrayList<ChatsListPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
  ChatsListPojo chatsListPojo=modelList.get(position);
        holder.txtSenderName.setText(chatsListPojo.getSender_name());
        holder.txtNoOfMessages.setText("("+String.valueOf(chatsListPojo.getChats_no())+")");
        holder.txtSenderLastMessage.setText(chatsListPojo.getSender_message());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtSenderName,txtSenderLastMessage,txtNoOfMessages;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtSenderName=(TextView)itemView.findViewById(R.id.txtName);
            txtNoOfMessages=(TextView)itemView.findViewById(R.id.txtMessageNo);
            txtSenderLastMessage=(TextView)itemView.findViewById(R.id.txtLastMessage);
        }
    }
}
