package com.erickogi14gmail.rog.Service;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.webkit.WebSettings;

import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.utills.MyWebViewClient;
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;
import com.erickogi14gmail.rog.utills.StaggeredHiddingScrollListener;
import com.erickogi14gmail.rog.utills.TouchyWebView;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/16/2017.
 */

public class Service extends Fragment {
    static RecyclerView.LayoutManager mLayoutManager;
    RecyclerView recyclerView;
    Dialog dialog;
    FloatingActionButton fab;
    private View view;
    static View viewSource;
    private ArrayList<DaysPojo> daysPojo=new ArrayList<>();
    private DaysAdapter daysAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private BottomNavigationView bottomNavigationView ;
    private TouchyWebView webView;

    private void setView(){
        // getActivity().setTitle("Songs");
        daysPojo=populateList();
        recyclerView=(RecyclerView)view.findViewById(R.id.horizontal_recyclerView);
        daysAdapter=new DaysAdapter(getContext(),daysPojo);
        daysAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(daysAdapter);
        webView=(TouchyWebView)view.findViewById(R.id.webView);

        set(daysPojo.get(0).getContent());

    }

    private ArrayList<DaysPojo> populateList() {
        ArrayList<DaysPojo> daysPojo =new ArrayList<>();
        DaysPojo daysPoo1=new DaysPojo(0,"Sunday","","No content Available Yet");
        DaysPojo daysPoo2=new DaysPojo(1,"Monday","","No content Available Yet");
        DaysPojo daysPoo3=new DaysPojo(2,"Tuesday","","No content Available Yet");
        DaysPojo daysPoo4=new DaysPojo(3,"Wednesday","","No content Available Yet");
        DaysPojo daysPoo5=new DaysPojo(4,"Thursday","","No content Available Yet");
        DaysPojo daysPoo6=new DaysPojo(5,"Friday","","No content Available Yet");
        DaysPojo daysPoo7=new DaysPojo(6,"Saturday","","No content Available Yet");

        daysPojo.add(daysPoo1);
        daysPojo.add(daysPoo2);
        daysPojo.add(daysPoo3);
        daysPojo.add(daysPoo4);
        daysPojo.add(daysPoo5);
        daysPojo.add(daysPoo6);
        daysPojo.add(daysPoo7);




        return daysPojo;

    }
    public void set(String htmlFilename) {

        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);


       // AssetManager mgr = getBaseContext().getAssets();
        // InputStream in = mgr.open(htmlFilename, AssetManager.ACCESS_BUFFER);
        // final String htmlContentInStringFormat = StreamToString(in);
        // in.close();

        webView.loadDataWithBaseURL(null, null, null, null, null);
        webView.loadDataWithBaseURL(null, htmlFilename, "text/html", "utf-8", null);
//            webView.setWebViewClient(new WebViewClient() {
//
//
//
//            });
        webView.setWebViewClient(new MyWebViewClient(getContext()));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.services_fragment,container,false);
        getActivity().setTitle("Services");

        setView();






        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation);
        recyclerView.setOnScrollListener(new StaggeredHiddingScrollListener() {

            @Override
            public void onHide() {
               // hideViews();
            }

            @Override
            public void onShow() {
              //  showViews();

            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),recyclerView,new RecyclerTouchListener.ClickListener(){

            @Override
            public void onClick(View view, int position) {
                if (viewSource != null) {
                    viewSource.setBackgroundColor(Color.WHITE);
                }
                viewSource = view;
                view.setBackgroundColor(Color.rgb(255, 144, 64));
                set(daysPojo.get(position).getContent()+" For : "+daysPojo.get(position).getDay());
               // view.setBackgroundColor(Color.rgb(255, 144, 64));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        hideViews();




       // hideViewsB();
        return view;
    }
    private void hideViewsB() {

        // fab.hide();


    }
    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }
    private void showViews() {
       // fab.show();

    }

}
