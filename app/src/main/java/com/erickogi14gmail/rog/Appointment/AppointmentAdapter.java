package com.erickogi14gmail.rog.Appointment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/15/2017.
 */

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<AppointmentPojo> modelList;

    public AppointmentAdapter(Context context, ArrayList<AppointmentPojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_appointment, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(AppointmentAdapter.MyViewHolder holder, int position) {
        AppointmentPojo appointmentPojo=modelList.get(position);
        holder.txtDate.setText(appointmentPojo.getDay()+"\n"+appointmentPojo.getTime());
        holder.txtComment.setText((appointmentPojo.getComment()));
        holder.txtTo.setText(appointmentPojo.getTo());
        String status="null";

        switch (appointmentPojo.getStatus()){

            case 0:
                status="Rejected";
                break;
            case 1:
                status="Accepted";
                break;
            case 2:
                status="Pending";
                break;
            case 3:
                status="Re-adjusted";
                break;
            case 4:
                status="Past";
                break;
            default:
                status="Unkown";
                break;
        }
        holder.txtstatus.setText(status);


    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTo,txtDate,txtstatus,txtComment;


        public MyViewHolder(View itemView) {
            super(itemView);
            txtTo=(TextView)itemView.findViewById(R.id.appointment_to);
            txtDate=(TextView)itemView.findViewById(R.id.txt_date);
            txtstatus=(TextView)itemView.findViewById(R.id.txt_status);
            txtComment=(TextView)itemView.findViewById(R.id.appointment_comment);
        }
    }
}
