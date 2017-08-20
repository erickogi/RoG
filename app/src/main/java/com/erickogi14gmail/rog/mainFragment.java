package com.erickogi14gmail.rog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.erickogi14gmail.rog.Appointment.AppointmentFragment;
import com.erickogi14gmail.rog.Bible.Bible;
import com.erickogi14gmail.rog.Departments.Departments;
import com.erickogi14gmail.rog.Hymns.FragmrntSongList;
import com.erickogi14gmail.rog.Prayer.prayerMenu;
import com.erickogi14gmail.rog.Sermons.Sermons;
import com.erickogi14gmail.rog.Service.Service;
import com.erickogi14gmail.rog.chat.Chat;
import com.erickogi14gmail.rog.utills.Webview;

/**
 * Created by kimani kogi on 7/21/2017.
 */

public class mainFragment extends Fragment {
    static View view;
    private Fragment fragment = null;
    CardView openAbout, openSermons, openHymns, openServices, openBible, openAppointments, openPrayers, openDepartments, openChats, openTodaysThought;
    NestedScrollView scrollview;
    BottomNavigationView bottomNavigationView;
    TextView txtTitle, txtPreview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));

    }

    private void showViews() {
        bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        //  mFabButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        getActivity().setTitle("Church App");
        scrollview = (NestedScrollView) view.findViewById(R.id.scrollView);
        bottomNavigationView = (BottomNavigationView) getActivity().findViewById(R.id.bottom_navigation);

        scrollview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    hideViews();
                } else {
                    showViews();
                }
            }
        });


        openAbout = (CardView) view.findViewById(R.id.openAbout);
        openSermons = (CardView) view.findViewById(R.id.openSermons);
        openHymns = (CardView) view.findViewById(R.id.openHyms);
        openServices = (CardView) view.findViewById(R.id.openServicesShedules);
        openBible = (CardView) view.findViewById(R.id.openBible);
        openAppointments = (CardView) view.findViewById(R.id.openAppointment);
        openPrayers = (CardView) view.findViewById(R.id.openPrayer);
        openDepartments = (CardView) view.findViewById(R.id.openDepartments);
        openChats = (CardView) view.findViewById(R.id.openChats);
        openTodaysThought = (CardView) view.findViewById(R.id.todays_thought);

        txtTitle = (TextView) view.findViewById(R.id.todays_thought_title);
        txtPreview = (TextView) view.findViewById(R.id.todays_thought_preview);


        openTodaysThought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Webview.class);
                intent.putExtra("isToday", true);
                intent.putExtra("title", txtTitle.getText());
                intent.putExtra("preview", txtPreview.getText());

                startActivity(intent);

            }
        });


        openAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "About", Toast.LENGTH_SHORT).show();
            }
        });
        openSermons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Sermons.class));
            }
        });
        openHymns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity.isMain=false;
                popOutFragments();
                fragment = new FragmrntSongList();
                setUpView();
            }
        });
        openServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popOutFragments();
                fragment = new Service();
                setUpView();
            }
        });
        openBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popOutFragments();
                fragment=new Bible();
                setUpView();
            }
        });
        openAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popOutFragments();
                fragment = new AppointmentFragment();
                setUpView();
            }
        });
        openPrayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popOutFragments();
                fragment=new prayerMenu();
                setUpView();
            }
        });
        openDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popOutFragments();
                fragment = new Departments();
                setUpView();
            }
        });
        openChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Chat.class));
            }
        });


        return view;

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
