package com.erickogi14gmail.rog.Hymns;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/25/2017.
 */

public class SongAdapter  extends RecyclerView.Adapter<SongAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<HymnsPojo> modelList;

    public SongAdapter(Context context, ArrayList<HymnsPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public SongAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongAdapter.MyViewHolder holder, int position) {
     HymnsPojo hymnsPojo=modelList.get(position);
        holder.txtSongNo.setText(String.valueOf(hymnsPojo.getHymn_no()));
        holder.txtSongTitle.setText(hymnsPojo.getHymn_title());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtSongNo,txtSongTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtSongNo=(TextView)itemView.findViewById(R.id.song_no);
            txtSongTitle=(TextView)itemView.findViewById(R.id.song_title);


        }
    }
}
