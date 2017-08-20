package com.erickogi14gmail.rog.Departments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ScrollView;

import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/15/2017.
 */

public class Departments extends Fragment implements View.OnClickListener {
    private View view;
    public static ArrayList<DepartmentPojo> departmentPojos;
    private Fragment fragment = null;
    private BottomNavigationView bottomNavigationView ;
    private ScrollView scrollView;
    private CardView  elders,secretary,treasurer,decon,sabbath,personal,family,health,communication,youths,pathfinders,women,amo,music,comunity;

    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }

    private void showViews() {
        bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.departments_list,container,false);
        departmentPojos=populate();
        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation);

        scrollView=(ScrollView)getActivity().findViewById(R.id.scrollView);
        hideViews();
        getActivity().setTitle("Departments");
        elders=(CardView)view.findViewById(R.id.elders_card);
        secretary=(CardView)view.findViewById(R.id.secretary_card);
       decon=(CardView)view.findViewById(R.id.decons_card);
        treasurer=(CardView)view.findViewById(R.id.treasurer_card);
        sabbath=(CardView)view.findViewById(R.id.sabbath_card);
        personal=(CardView)view.findViewById(R.id.PersonalMinistries_card);
        family=(CardView)view.findViewById(R.id.family_card);
        health=(CardView)view.findViewById(R.id.health_card);
        communication=(CardView)view.findViewById(R.id.communication_card);
        youths=(CardView)view.findViewById(R.id.youths_card);
        pathfinders=(CardView)view.findViewById(R.id.pathfinders_card);
        women=(CardView)view.findViewById(R.id.womens_card);
        amo=(CardView)view.findViewById(R.id.amo_card);
        music=(CardView)view.findViewById(R.id.music_card);
        comunity=(CardView)view.findViewById(R.id.community_card);

        elders.setOnClickListener(this);
        secretary.setOnClickListener(this);
        treasurer.setOnClickListener(this);
        decon.setOnClickListener(this);
        sabbath.setOnClickListener(this);
        personal.setOnClickListener(this);
        family.setOnClickListener(this);
        health.setOnClickListener(this);
        communication.setOnClickListener(this);
        youths.setOnClickListener(this);
        pathfinders.setOnClickListener(this);
        amo.setOnClickListener(this);
        women.setOnClickListener(this);
        music.setOnClickListener(this);
        comunity.setOnClickListener(this);

        return view;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    static int pos=0;
    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.elders_card:
             pos=0;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.secretary_card:
             pos=1;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.treasurer_card:
             pos=2;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.decons_card:
             pos=3;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.sabbath_card:
             pos=4;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.PersonalMinistries_card:
             pos=5;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.family_card:
             pos=6;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.health_card:
             pos=7;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.communication_card:
             pos=8;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.youths_card:
             pos=9;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.pathfinders_card:
             pos=10;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.womens_card:
             pos=11;
             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.amo_card:
             pos=12;

             fragment = new DepartmentDetails();
             setUpView();
             break;
         case R.id.music_card:
             pos=13;
             fragment = new DepartmentDetails();
             setUpView();

             break;
         case R.id.community_card:
             pos=14;
             fragment = new DepartmentDetails();
             setUpView();
             break;


     }
        //popOutFragments();

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
    private ArrayList<DepartmentPojo> populate(){
        ArrayList<DepartmentPojo> departmentPojos=new ArrayList<>();
        DepartmentPojo departmentPojoElders=new DepartmentPojo("0714406984","COMING SOON…","erickogi14@gmail.com");
        DepartmentPojo departmentPojoSec=new DepartmentPojo("0714406984","COMING SOON…","erickogi14@gmail.com");
        DepartmentPojo departmentPojoTre=new DepartmentPojo("0714406984","The treasurer is called to do both an important task and sacred work.  The treasurer can greatly encourage faithfulness in the returning of tithe and deepen the spirit of liberality on the part of the church members.\n" +
                "\n" +
                "The church treasurer is the custodian of all church funds which are basically divided into:\n" +
                "\n" +
                "1. Conference/mission/field funds\n" +
                "\n" +
                "2. Local church funds\n" +
                "\n" +
                "3. Funds belonging to the auxiliary organizations of the local church","erickogi14@gmail.com");
        DepartmentPojo departmentPojoDecon=new DepartmentPojo("0714406984","The role of the deacon of the church is to assist the church in any way possible.\n" +
                "\n" +
                "The deacon, like the elder, is an elected and ordained role. The deacon’s primary roles are the assistance in running of services, the visitation of members, the care of the sick and the maintenance of church property. The deacons are also intimately involved in:\n" +
                "\n" +
                "Evangelism\n" +
                "Ministry\n" +
                "Healing\n" +
                "Praying for the Sick\n" +
                "Assisting the Poor and the Needy\n" +
                "Meaningful Community Impact\n" +
                "Men’s Ministries\n" +
                "And much more!","erickogi14@gmail.com");
        DepartmentPojo departmentPojoSabbath=new DepartmentPojo("0714406984","Coming soon","erickogi14@gmail.com");
        DepartmentPojo departmentPojoPersoanl=new DepartmentPojo("0714406984","The Personal Ministries Department provides resources and trains church members to unite their efforts with the ministry and church officers in the final proclamation of the gospel of salvation in Christ. The aim of the department is to enlist every member in active soul-winning service for God.\n" +
                "\n" +
                "Personal Ministries Leader \n" +
                "\n" +
                "The Personal Ministries leader is elected by the church to lead in training and directing the church in active outreach (missionary) service and is chairperson of the Personal Ministries Council. It is the leader’s duty to present to the church, in the monthly Sabbath Personal Ministries service and in the church business meetings, a report on the total outreach (missionary) activities of the church","erickogi14@gmail.com");
        DepartmentPojo departmentPojofam=new DepartmentPojo("0714406984","The over-arching objective of Family Ministries is to strengthen the family as a discipling center. The family was established by divine creation as the fundamental human institution. It is the primary setting in which values are learned and the capacity for close relationships with God and with other human beings is developed.\n" +
                "\n" +
                "Family Ministries is a ministry of grace which acknowledges as normative the biblical teachings relating to the family and holds high God’s ideals for family living. At the same time, it brings an understanding of the brokenness experienced by individuals and families in a fallen world. Thus Family Ministries seeks to enable families to stretch toward divine ideals, while at the same time ever extending the good news of God’s saving grace and the promise of growth possible through the indwelling Spirit.\n" +
                "\n" +
                "Family Ministries focuses on people in relationship. It is concerned with the needs of married couples, parents and children, the family needs of singles and all members of the wider family circle as they pass through life’s predictable stages and contends with unexpected changes in their lives.","erickogi14@gmail.com");
        DepartmentPojo departmentPojoHelth=new DepartmentPojo("0714406984","COMING SOON…","erickogi14@gmail.com");
        DepartmentPojo departmentPojocom=new DepartmentPojo("0714406984","Building bridges of hope” is the mission statement of the Seventh-day Adventist Church’s Communication Department. We work toward this goal by reaching out to diverse church audiences — both internally and externally — through many avenues of communication. Creating informative and intuitive web sites, updating social media sites, and writing news stories and press releases are some of the ways we share our message. Through our work, we foster a clearer image of the church, its mission, activities and witness, so that many will become followers of Christ and members of His church.","erickogi14@gmail.com");
        DepartmentPojo departmentPojoyouth=new DepartmentPojo("0714406984","COMING SOON…","erickogi14@gmail.com");
        DepartmentPojo departmentPojopath=new DepartmentPojo("0714406984","COMING SOON…","erickogi14@gmail.com");
        DepartmentPojo departmentPojowomen=new DepartmentPojo("0714406984","COMING SOON…","erickogi14@gmail.com");
        DepartmentPojo departmentPojoamo=new DepartmentPojo("0714406984","Coming soon","erickogi14@gmail.com");
        DepartmentPojo departmentPojomusic=new DepartmentPojo("0714406984","The Mt. Vernon Seventh-day Adventist Music Ministry Department is committed to fulfill the following:\n" +
                "·         Utilizing sacred music to give glory to God and enhance the worship experience.\n" +
                "·         Utilizing sacred music to create a heavenly and spirit filled atmosphere.\n" +
                "·         Utilizing sacred music to create a spiritual and emotional balance.\n" +
                "·         Utilizing sacred music in preparation of the spoken word.\n" +
                "·         Utilizing the entire sacred music genre to meet the needs of the diverse congregation.\n" +
                "Therefore the Mt. Vernon Seventh-day Adventist Music Ministry Department will continue to:\n" +
                "Praise God in his sanctuary: praise him in the firmament of his power….praise him with the sound of the trumpet: praise him with the psaltery and harp…praise him with stringed instruments and organs…Let everything that hath breath praise the Lord.”-  Psalms 150\n" +
                "The Music Ministry Department consists of: Tabernacle Choir, Voices of Youth Singers, Voices of Praise Singers, Ladies Chorale, Men Ensemble, New Creation, MV Praise, and various vocalists and musicians dedicated to utilize their talents for the glory and honor of God.","erickogi14@gmail.com");
        DepartmentPojo departmentPojocommunity=new DepartmentPojo("0714406984","COMING SOON…","erickogi14@gmail.com");
        departmentPojos.add(departmentPojoElders);
        departmentPojos.add(departmentPojoSec);
        departmentPojos.add(departmentPojoTre);
        departmentPojos.add(departmentPojoDecon);
        departmentPojos.add(departmentPojoSabbath);
        departmentPojos.add(departmentPojoPersoanl);
        departmentPojos.add(departmentPojofam);
        departmentPojos.add(departmentPojoHelth);
        departmentPojos.add(departmentPojocom);
        departmentPojos.add(departmentPojoyouth);
        departmentPojos.add(departmentPojopath);
        departmentPojos.add(departmentPojowomen);
        departmentPojos.add(departmentPojoamo);
        departmentPojos.add(departmentPojomusic);
        departmentPojos.add(departmentPojocommunity);



        return departmentPojos;

    }
}
