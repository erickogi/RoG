package com.erickogi14gmail.rog.Events;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.erickogi14gmail.rog.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventsDetails extends AppCompatActivity {
    private ArrayList<EventsPojo> eventsPojo=new ArrayList<>();
    private int position;
    private TextView txtTitle,txtBy,txtDate,txtTime,txtPlace,txtDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_details);

        Intent intent=getIntent();
        position = intent.getIntExtra("dataposition", 0);
        eventsPojo = (ArrayList<EventsPojo>) intent.getSerializableExtra("data");





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(eventsPojo.get(position).getEvent_title());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               shareEvent(eventsPojo.get(position).getEvent_preview(),eventsPojo.get(position).getEvent_date(),eventsPojo.get(position).getEvent_time(),eventsPojo.get(position).getEvent_place());
            }
        });
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareEvent(eventsPojo.get(position).getEvent_preview(),eventsPojo.get(position).getEvent_date(),eventsPojo.get(position).getEvent_time(),eventsPojo.get(position).getEvent_place());
            }
        });
        txtTitle=(TextView)findViewById(R.id.event_title);
        txtDate=(TextView)findViewById(R.id.event_date);
        txtTime=(TextView)findViewById(R.id.event_time);
        txtPlace=(TextView)findViewById(R.id.event_place);
        txtDescription=(TextView)findViewById(R.id.event_description);

        txtTitle.setText(eventsPojo.get(position).getEvent_title());
        txtDate.setText(eventsPojo.get(position).getEvent_date());
        txtTime.setText(eventsPojo.get(position).getEvent_time());
        txtPlace.setText(eventsPojo.get(position).getEvent_place());
        txtDescription.setText(eventsPojo.get(position).getEvent_description());






    }
    private void shareEvent(String text,String date,String time,String place){
        Intent in = new Intent();
        in.setAction(Intent.ACTION_SEND);
        in.putExtra(Intent.EXTRA_TEXT, text+"\n On "+date+"\n At "+place+"\n "+time );
        in.setType("text/plain");
        startActivity(in);
    }
    private void openMaps(String address) {



        String strUri = "google.navigation:q="+address;
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

       intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

        startActivity(intent);
    }

    private void onAddEventCalendar(String date,String eventTitle,String preview,String location) throws ParseException {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");


        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = formatter.parse(date);
        Date endDate = null;

        long startTime = startDate.getTime();
        long endTime = startDate.getTime();


        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

        intent.putExtra(CalendarContract.Events.TITLE, eventTitle);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, preview);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location);


        startActivity(intent);
    }

    public void calendarEvent(View view) throws ParseException {
        onAddEventCalendar(eventsPojo.get(position).getEvent_date(),eventsPojo.get(position).getEvent_title(),eventsPojo.get(position).getEvent_preview(),eventsPojo.get(position).getEvent_place());

    }

    public void mapsEvent(View view) {

        openMaps("Ngong race Course Nairobi");
    }

}
