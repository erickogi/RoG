package com.erickogi14gmail.rog.Prayer;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;
import com.erickogi14gmail.rog.utills.StaggeredHiddingScrollListener;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/14/2017.
 */

public class prayerMenu extends Fragment {
    RecyclerView recyclerView;
    Dialog dialog;
    FloatingActionButton fab;
    private View view;
    private ArrayList<prayerPojo> prayerPojo=new ArrayList<>();
    private prayerAdapter prayerAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private BottomNavigationView bottomNavigationView ;

    private void setView(){
       // getActivity().setTitle("Songs");
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        prayerAdapter=new prayerAdapter(getContext(),populateList());
        prayerAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(prayerAdapter);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.prayermenu,container,false);
        getActivity().setTitle("Prayer Menu");

        setView();

        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRequest();
            }
        });



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






        hideViewsB();
        return view;
    }
    private void hideViewsB() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));
       // fab.hide();


    }
    private void hideViews() {
       fab.hide();


    }

    private void showViews() {
       fab.show();

    }
    private void addRequest() {
        boolean anonymous=false;
        dialog=new Dialog(getContext());
        dialog.setTitle("Prayer Request");
        dialog.setContentView(R.layout.prayer_request_dialog);
        Button submit=(Button)dialog.findViewById(R.id.btnSubmit);
        Button cancel=(Button)dialog.findViewById(R.id.btnCancel);
        final EditText edtTitle=(EditText) dialog.findViewById(R.id.editTextTitle);
        final EditText edtMessage=(EditText) dialog.findViewById(R.id.editTextMessage);
        final TextView txtName=(TextView)dialog.findViewById(R.id.txt_name);
        final CheckBox checkBox=(CheckBox)dialog.findViewById(R.id.checkbox) ;

        final boolean finalAnonymous = anonymous;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtTitle.getText().toString().isEmpty()){
                     edtTitle.setError("Cannot be blank");
                }
                else if(edtMessage.getText().toString().isEmpty()){
                    edtMessage.setError("Cannot be blank");
                }
                else {

                    String title=edtTitle.getText().toString();
                    String message=edtMessage.getText().toString();
                    String name=txtName.getText().toString();



                    if(checkBox.isChecked()){

                        Toast.makeText(getContext(), ""+name+"\n"+title+"\n"+message+"\n"+ "Anonymous", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        Toast.makeText(getContext(), ""+name+"\n"+title+"\n"+message+"\n"+ name, Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });








        dialog.show();





    }

    private ArrayList<prayerPojo> populateList(){
        prayerPojo prayerPojo1=new prayerPojo(1,"Pray for my sick mum","please pray for my mum who is sick and hospitalized in Nairobi hospital","3/9/2017","Mark Mathew","","");
        prayerPojo prayerPojo2=new prayerPojo(2,"pray for my family","I wish to request that you pray for my and other families to be cemented in Gods love","9/6/2017","Anonymous","","");
        prayerPojo prayerPojo3=new prayerPojo(3,"pray for countries peace","The church wishes to urge the congregation to keep praying for peace in our country","3/9/2017","Church","","");
        prayerPojo prayerPojo4=new prayerPojo(4,"Lets Pray for the crusade","The church wishes to urge the congregation to keep praying for for the crusade","9/6/2017","Church","","");
        prayerPojo prayerPojo5=new prayerPojo(5,"Pray for our youths","The church wishes to urge the congregation to keep praying for for the youths in our church and country","3/9/2017","Church-Youth department","","");
        prayerPojo prayerPojo6=new prayerPojo(6,"Pray for the wedding of...","The church wishes to notify you on the wedding of on Mr John Mark and Eunice Njambi","9/6/2017","Church","","");
        prayerPojo prayerPojo7=new prayerPojo(7,"Prayer for the sick","The church wishes to urge the congregation to keep praying for the sick in our country","3/9/2017","Church","","");
        prayerPojo prayerPojo8=new prayerPojo(8,"Lets pray for the camp meeting","The church wishes to urge the congregation to keep praying for the camp meeting thats upcoming","9/6/2017","Church","","");
        prayerPojo prayerPojo9=new prayerPojo(9,"pray for the victims of war","The church wishes to urge the congregation to keep praying for peace in our country","3/9/2017","Church","","");
        this.prayerPojo.add(prayerPojo1);
        this.prayerPojo.add(prayerPojo2);
        this.prayerPojo.add(prayerPojo3);
        this.prayerPojo.add(prayerPojo4);
        this.prayerPojo.add(prayerPojo5);
        this.prayerPojo.add(prayerPojo6);
        this.prayerPojo.add(prayerPojo7);
        this.prayerPojo.add(prayerPojo8);
        this.prayerPojo.add(prayerPojo9);

        return this.prayerPojo;



    }
}
