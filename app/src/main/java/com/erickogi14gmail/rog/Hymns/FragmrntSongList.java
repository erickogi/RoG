package com.erickogi14gmail.rog.Hymns;

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
 * Created by kimani kogi on 7/25/2017.
 */

public class FragmrntSongList extends Fragment {
    private View view;
    private ArrayList<HymnsPojo> hymnsPojo=new ArrayList<>();
   
    RecyclerView recyclerView;

    private SongAdapter songAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private BottomNavigationView bottomNavigationView ;

    private void setView(){
        getActivity().setTitle("Events");
        recyclerView=(RecyclerView)view.findViewById(R.id.notifications_recycleView);
        songAdapter=new SongAdapter(getContext(),populateList());
        songAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(songAdapter);
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

        view=inflater.inflate(R.layout.songs_fragment,container,false);
        getActivity().setTitle("Notices");
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

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));





        return view;
    }
    private ArrayList<HymnsPojo> populateList(){
        HymnsPojo hymnsPojo1=new HymnsPojo(1,1,"Praise To The Lord",lText);
        HymnsPojo hymnsPojo2=new HymnsPojo(2,2,"All Creatures Of God",lText);
        HymnsPojo hymnsPojo3=new HymnsPojo(3,3,"God Himself Is With Us",lText);
        HymnsPojo hymnsPojo4=new HymnsPojo(4,4,"Praise My Soul the King Of Heaven",lText);
        HymnsPojo hymnsPojo5=new HymnsPojo(5,5,"O worship the Lord",lText);
        HymnsPojo hymnsPojo6=new HymnsPojo(6,6,"We Gather Together",lText);
        HymnsPojo hymnsPojo7=new HymnsPojo(7,7,"The God Of Abraham Praise",lText);
        HymnsPojo hymnsPojo8=new HymnsPojo(8,8,"Joyful Joyful We adore Thee",lText);
        HymnsPojo hymnsPojo9=new HymnsPojo(9,9,"My Maker and My King",lText);
        for(int a=0;a<3;a++) {
            this.hymnsPojo.add(hymnsPojo1);
            this.hymnsPojo.add(hymnsPojo2);
            this.hymnsPojo.add(hymnsPojo3);
            this.hymnsPojo.add(hymnsPojo4);
            this.hymnsPojo.add(hymnsPojo5);
            this.hymnsPojo.add(hymnsPojo6);
            this.hymnsPojo.add(hymnsPojo7);
            this.hymnsPojo.add(hymnsPojo8);
            this.hymnsPojo.add(hymnsPojo9);
        }
        return this.hymnsPojo;



    }
    private String lText="c";

}
