package com.erickogi14gmail.rog.Appointment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
 * Created by kimani kogi on 8/14/2017.
 */

public class AppointmentFragment extends Fragment {
    private View view;
    private Fragment fragment = null;
    private BottomNavigationView bottomNavigationView ;
    private ArrayList<AppointmentPojo> appointmentPojo;
    private AppointmentAdapter appointmentAdapter;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    Dialog dialog;
    FloatingActionButton fab;

    private void setView(){
        // getActivity().setTitle("Songs");
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        appointmentAdapter=new AppointmentAdapter(getContext(),populateList());
        appointmentAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(appointmentAdapter);
    }

    private ArrayList<AppointmentPojo> populateList() {
        ArrayList<AppointmentPojo> appointPojo=new ArrayList<>();
        AppointmentPojo appointmentpojo=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",1);
        AppointmentPojo appointmentpojo1=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",0);
        AppointmentPojo appointmentpojo2=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",1);
        AppointmentPojo appointmentpojo3=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",3);
        AppointmentPojo appointmentpojo4=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",1);
        AppointmentPojo appointmentpojo5=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",0);
        AppointmentPojo appointmentpojo6=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",2);
        AppointmentPojo appointmentpojo7=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",2);
        AppointmentPojo appointmentpojo8=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",1);
        AppointmentPojo appointmentpojo9=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",3);
        AppointmentPojo appointmentpojo10=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",0);
        AppointmentPojo appointmentpojo11=new AppointmentPojo(1,"12/10/2017","9:30 AM","Rev Mwaniki James","Marriage Counsel Appointment request for my new family",1);


    appointPojo.add(appointmentpojo);
        appointPojo.add(appointmentpojo1);
        appointPojo.add(appointmentpojo2);
        appointPojo.add(appointmentpojo3);
        appointPojo.add(appointmentpojo4);
        appointPojo.add(appointmentpojo5);
        appointPojo.add(appointmentpojo6);
        appointPojo.add(appointmentpojo7);
        appointPojo.add(appointmentpojo8);
        appointPojo.add(appointmentpojo9);
        appointPojo.add(appointmentpojo10);
        appointPojo.add(appointmentpojo11);

        return appointPojo;

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

        view=inflater.inflate(R.layout.prayermenu,container,false);
        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation);
        setView();

        hideViews();
        getActivity().setTitle("Appointments");

        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popOutFragments();
                fragment = new NewAppointment();
                setUpView();
            }
        });
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

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }

    private void addAppointment() {
      //  DialogFragment newFragment = new DateTimeDialogFragment();
      //  newFragment.show(getActivity().getFragmentManager(), "timePicker");

    }
    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment)
                    .addToBackStack(null).commit();
        }

    }
    void popOutFragments(){
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        for(int i=0;i<fragmentManager.getBackStackEntryCount();i++){
            fragmentManager.popBackStack();
        }
    }


}
