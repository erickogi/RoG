package com.erickogi14gmail.rog.Sermons;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.utills.AudioPlayer;
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;
import com.erickogi14gmail.rog.utills.StaggeredHiddingScrollListener;
import com.erickogi14gmail.rog.utills.Webview;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/23/2017.
 */

public class FragmentSermonAudio extends Fragment {
    private View view;

    RecyclerView recyclerView;
    private ArrayList<TextSermonPojo> textSermonPojo=new ArrayList<>();
    private SermonAdapter sermonAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private void setView(){
        recyclerView=(RecyclerView)view.findViewById(R.id.notifications_recycleView);
        sermonAdapter=new SermonAdapter(getContext(),populateList(),"Audio");
        sermonAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sermonAdapter);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frgament_sermons,container,false);
        getActivity().setTitle("Audio Sermons");
        setView();

        recyclerView.setOnScrollListener(new StaggeredHiddingScrollListener() {

            @Override
            public void onHide() {

            }

            @Override
            public void onShow() {


            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),recyclerView,new RecyclerTouchListener.ClickListener(){

            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(),AudioPlayer.class);
                intent.putExtra("datapos", position);
                intent.putExtra("data", textSermonPojo);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }
    private ArrayList<TextSermonPojo> populateList(){
        textSermonPojo.clear();
        TextSermonPojo textSermonPojo1=new TextSermonPojo(1,"","Living in Christ","What does living in christ mean and how can we live in christ",lText,"","3/9/2017","Pst William Odibaye");
        TextSermonPojo textSermonPojo2=new TextSermonPojo(2,"","Armour Of Faith","How do we acquire this faith,what is faith, why do we need faith",lText,"","9/6/2017 ","Pst Goerge Ladini");
        TextSermonPojo textSermonPojo3=new TextSermonPojo(3,"","Living in Christ","What does living in christ mean and how can we live in christ",lText,"","3/9/2017","Pst William Odibaye");
        TextSermonPojo textSermonPojo4=new TextSermonPojo(4,"","Armour Of Faith","How do we acquire this faith,what is faith, why do we need faith",lText,"","9/6/2017 ","Pst Goerge Ladini");
        TextSermonPojo textSermonPojo5=new TextSermonPojo(5,"","Living in Christ","What does living in christ mean and how can we live in christ",lText,"","3/9/2017","Pst William Odibaye");
        TextSermonPojo textSermonPojo6=new TextSermonPojo(6,"","Armour Of Faith","How do we acquire this faith,what is faith, why do we need faith",lText,"","9/6/2017 ","Pst Goerge Ladini");
        TextSermonPojo textSermonPojo7=new TextSermonPojo(7,"","Living in Christ","What does living in christ mean and how can we live in christ",lText,"","3/9/2017","Pst William Odibaye");
        TextSermonPojo textSermonPojo8=new TextSermonPojo(8,"","Armour Of Faith","How do we acquire this faith,what is faith, why do we need faith",lText,"","9/6/2017 ","Pst Goerge Ladini");
        TextSermonPojo textSermonPojo9=new TextSermonPojo(9,"","Living in Christ","What does living in christ mean and how can we live in christ",lText,"","3/9/2017","Pst William Odibaye");
        this.textSermonPojo.add(textSermonPojo1);
        this.textSermonPojo.add(textSermonPojo2);
        this.textSermonPojo.add(textSermonPojo3);
        this.textSermonPojo.add(textSermonPojo4);
        this.textSermonPojo.add(textSermonPojo5);
        this.textSermonPojo.add(textSermonPojo6);
        this.textSermonPojo.add(textSermonPojo7);
        this.textSermonPojo.add(textSermonPojo8);
        this.textSermonPojo.add(textSermonPojo9);

        return this.textSermonPojo;



    }
    private String lText="In this method, the name of the csv file to be read is provided as a parameter ,using the BufferedReader class to read characters on the csv file . Using a while loop ,the whole file is read and the method split is used to split the strings using the pipe delimeter .\n" +
            "The elements are then added to an arraylist of type Pojo.\n" +
            "Then a for loop is used to go through each row while an if condition checks for the  condition at index 4 or column 5 (ie if the element at column five is G or C. Inserting the whole row to a database if it is and pushing the row to a new list to be sent as a message using activemq)\nIn this method, the name of the csv file to be read is provided as a parameter ,using the BufferedReader class to read characters on the csv file . Using a while loop ,the whole file is read and the method split is used to split the strings using the pipe delimeter .\n" +
            "The elements are then added to an arraylist of type Pojo.\n" +
            "Then a for loop is used to go through each row while an if condition checks for the  condition at index 4 or column 5 (ie if the element at column five is G or C. Inserting the whole row to a database if it is and pushing the row to a new list to be sent as a message using activemq)\n";

}
