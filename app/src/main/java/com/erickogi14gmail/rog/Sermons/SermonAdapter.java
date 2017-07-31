package com.erickogi14gmail.rog.Sermons;

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
 * Created by kimani kogi on 7/23/2017.
 */

public class SermonAdapter extends RecyclerView.Adapter<SermonAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<TextSermonPojo> modelList;
    private String type;

    public SermonAdapter(Context context, ArrayList<TextSermonPojo> modelList,String type) {
        this.context = context;
        this.modelList = modelList;
        this.type=type;
    }

    @Override
    public SermonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        if(type.equals("Text")) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_sermon_list, parent, false);
        }else if(type.equals("Audio")){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_sermon_list, parent, false);
        }
        else{
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_sermon_list, parent, false);

        }
        return new SermonAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SermonAdapter.MyViewHolder holder, int position) {
        TextSermonPojo textSermonPojo=modelList.get(position);
        holder.txtSermonTitle.setText(textSermonPojo.getSermon_title());
        holder.txtSermonPreview.setText(textSermonPojo.getSermon_preview());
        holder.txtSermonBy.setText(textSermonPojo.getSermon_by());
        holder.txtSermonDate.setText(textSermonPojo.getSermon_date());


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtSermonTitle,txtSermonPreview,txtSermonDate,txtSermonBy;
        ImageView imageView;



        public MyViewHolder(View itemView) {
            super(itemView);
            txtSermonTitle=(TextView)itemView.findViewById(R.id.sermon_title);
            txtSermonPreview=(TextView)itemView.findViewById(R.id.sermon_description);
            txtSermonDate=(TextView)itemView.findViewById(R.id.sermon_date);
            txtSermonBy=(TextView)itemView.findViewById(R.id.sermon_by);
            imageView=(ImageView)itemView.findViewById(R.id.sermon_image);

        }
    }
}
