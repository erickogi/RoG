package com.erickogi14gmail.rog.Events;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;
import com.erickogi14gmail.rog.utills.StaggeredHiddingScrollListener;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/23/2017.
 */

public class EventsFragment extends Fragment {
    private View view;
    
    RecyclerView recyclerView;
    private ArrayList<EventsPojo> eventsPojo=new ArrayList<>();
    private EventsListAdapter eventsListAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private BottomNavigationView bottomNavigationView ;

    private void setView(){
        recyclerView=(RecyclerView)view.findViewById(R.id.notifications_recycleView);
        eventsListAdapter=new EventsListAdapter(getContext(),populateList());
        eventsListAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(eventsListAdapter);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }

    private void showViews() {
        bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_notifications,container,false);
        getActivity().setTitle("Events");
        setView();
        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation);
        recyclerView.setOnScrollListener(new StaggeredHiddingScrollListener() {

            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();

            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),recyclerView,new RecyclerTouchListener.ClickListener(){

            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(), EventsDetails.class);
                intent.putExtra("dataposition", position);
                intent.putExtra("data", eventsPojo);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        
        return view;
    }
    private ArrayList<EventsPojo> populateList(){
        EventsPojo eventsPojo1=new EventsPojo(1,"Wedding Ceremony","","The church wishes to invite you to the wedding of on Mr John Mark and Eunice Njambi","3/9/2017","2PM-6PM","Church Grounds",lText);
        EventsPojo eventsPojo2=new EventsPojo(2,"Youths And Children Seminar","","You are invited to attend a youths seminar and retreat for your spiritual growth socialization and fun","9/6/2017 ","8AM-6PM","Ngong Retreat Center",lText);
        EventsPojo eventsPojo3=new EventsPojo(3,"Wedding Ceremony","","The church wishes to invite you to the wedding of on Mr John Mark and Eunice Njambi","3/9/2017","2PM-6PM","Church Grounds",lText);
        EventsPojo eventsPojo4=new EventsPojo(4,"Youths And Children Seminar","","You are invited to attend a youths seminar and retreat for your spiritual growth socialization and fun","9/6/2017 ","8AM-6PM","Ngong Retreat Center",lText);
        EventsPojo eventsPojo5=new EventsPojo(5,"Wedding Ceremony","","The church wishes to invite you to the wedding of on Mr John Mark and Eunice Njambi","3/9/2017","2PM-6PM","Church Grounds",lText);
        EventsPojo eventsPojo6=new EventsPojo(6,"Youths And Children Seminar","","You are invited to attend a youths seminar and retreat for your spiritual growth socialization and fun","9/6/2017 ","8AM-6PM","Ngong Retreat Center",lText);
        EventsPojo eventsPojo7=new EventsPojo(7,"Wedding Ceremony","","The church wishes to invite you to the wedding of on Mr John Mark and Eunice Njambi","3/9/2017","2PM-6PM","Church Grounds",lText);
        EventsPojo eventsPojo8=new EventsPojo(8,"Youths And Children Seminar","","You are invited to attend a youths seminar and retreat for your spiritual growth socialization and fun","9/6/2017 ","8AM-6PM","Ngong Retreat Center",lText);
        EventsPojo eventsPojo9=new EventsPojo(9,"Wedding Ceremony","","The church wishes to invite you to the wedding of on Mr John Mark and Eunice Njambi","3/9/2017","2PM-6PM","Church Grounds",lText);
        this.eventsPojo.add(eventsPojo1);
        this.eventsPojo.add(eventsPojo2);
        this.eventsPojo.add(eventsPojo3);
        this.eventsPojo.add(eventsPojo4);
        this.eventsPojo.add(eventsPojo5);
        this.eventsPojo.add(eventsPojo6);
        this.eventsPojo.add(eventsPojo7);
        this.eventsPojo.add(eventsPojo8);
        this.eventsPojo.add(eventsPojo9);

        return this.eventsPojo;



    }
    private String lText="In this method, the name of the csv file to be read is provided as a parameter ,using the BufferedReader class to read characters on the csv file . Using a while loop ,the whole file is read and the method split is used to split the strings using the pipe delimeter .\n" +
            "The elements are then added to an arraylist of type Pojo.\n" +
            "Then a for loop is used to go through each row while an if condition checks for the  condition at index 4 or column 5 (ie if the element at column five is G or C. Inserting the whole row to a database if it is and pushing the row to a new list to be sent as a message using activemq)\nIn this method, the name of the csv file to be read is provided as a parameter ,using the BufferedReader class to read characters on the csv file . Using a while loop ,the whole file is read and the method split is used to split the strings using the pipe delimeter .\n" +
            "The elements are then added to an arraylist of type Pojo.\n" +
            "Then a for loop is used to go through each row while an if condition checks for the  condition at index 4 or column 5 (ie if the element at column five is G or C. Inserting the whole row to a database if it is and pushing the row to a new list to be sent as a message using activemq)\n";
}
