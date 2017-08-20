package com.erickogi14gmail.rog.Bible;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/28/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private ArrayList<BiblePojo> modelList;

    public Adapter(Context context, ArrayList<BiblePojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bible, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
        BiblePojo biblePojo=modelList.get(position);
        holder.textViewT.setText(biblePojo.getT());
        holder.textViewCV.setText(String.valueOf(biblePojo.getC())+" : "+String.valueOf(biblePojo.getV()));

        BibleRead bibleRead=new BibleRead();
        holder.textViewB.setText(bibleRead.bookName(biblePojo.getB()));


    }

    @Override
    public int getItemCount() {
        try {
            return modelList.size();
        }catch (Exception m){
            return  0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewT,textViewB,textViewCV;
        public MyViewHolder(View itemView) {
            super(itemView);
            textViewT=(TextView)itemView.findViewById(R.id.text);
            textViewB=(TextView)itemView.findViewById(R.id.textB);
            textViewCV=(TextView)itemView.findViewById(R.id.textCV);
        }
    }
}
