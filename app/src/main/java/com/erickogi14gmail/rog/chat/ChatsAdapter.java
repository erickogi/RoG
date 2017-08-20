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

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ChatPojo> modelList;
    private int viewType;

    public ChatsAdapter(Context context, ArrayList<ChatPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ChatsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        if (viewType == 1){
            this.viewType=viewType;
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item_message_friend, parent, false);
    }
        else{
            this.viewType=viewType;
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item_message_user, parent, false);

        }
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatsAdapter.MyViewHolder holder, int position) {
    ChatPojo chatPojo=modelList.get(position);

        holder.txtMessage.setText(chatPojo.getMessage_text());
        String name=null;
        if(this.viewType==1){
            name=chatPojo.getFrom_name();
        }
        else {
            name="Me";
        }
        holder.txtSender.setText(name);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return modelList.get(position).getFromid();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtMessage,txtSender;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtSender=(TextView)itemView.findViewById(R.id.textFROM);
            txtMessage=(TextView)itemView.findViewById(R.id.textContent);
        }
    }
}
