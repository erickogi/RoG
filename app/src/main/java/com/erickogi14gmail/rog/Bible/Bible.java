package com.erickogi14gmail.rog.Bible;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.erickogi14gmail.rog.R;

/**
 * Created by kimani kogi on 7/30/2017.
 */

public class Bible extends Fragment {
    private View view;
    LinearLayout locate,search,bookmarks,settings;
    private BottomNavigationView bottomNavigationView ;
    Dialog dialog;


    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }

    private void showViews() {
        bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_bible,container,false);
        getActivity().setTitle("Bible");
        locate=(LinearLayout) view.findViewById(R.id.openLocate);
        search=(LinearLayout) view.findViewById(R.id.openSearch);
        bookmarks=(LinearLayout) view.findViewById(R.id.openBookmarks);
        settings=(LinearLayout) view.findViewById(R.id.openSettings);

        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation);
        hideViews();

        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocate();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch("");
            }
        });
        bookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookmarks();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
        return view;

    }

    public void openLocate(){
        String testament[]={"Old Testament","New Testament"};
        String books[]={"Genesis","Exodus","Leviticus","Numbers","Deuteronomy"};
        dialog=new Dialog(getContext());
        dialog.setTitle("Locate");
        dialog.setContentView(R.layout.locatediolog);
        Button btnCancel=(Button)dialog.findViewById(R.id.btn_cancel) ;
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        Button btnOkay=(Button)dialog.findViewById(R.id.btn_okay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(new Intent(getActivity(),BibleRead.class));
            }});
        Spinner spinnerTestament=(Spinner)dialog.findViewById(R.id.spinnerTestament);
        Spinner spinnerBook=(Spinner)dialog.findViewById(R.id.spinnerBook);
        Spinner spinnerChapter=(Spinner)dialog.findViewById(R.id.spinnerChapter);
        Spinner spinnerVerse=(Spinner)dialog.findViewById(R.id.spinnerVerse);

        ArrayAdapter<String> simpleAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,testament);
        spinnerTestament.setAdapter(simpleAdapter);

        ArrayAdapter<String> simpleAdapterB=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,books);
        spinnerBook.setAdapter(simpleAdapterB);




        dialog.show();

    }
    public void openSearch(String textToSearch){

    }
    public void openBookmarks(){

    }
    public void openSettings(){

    }
}
