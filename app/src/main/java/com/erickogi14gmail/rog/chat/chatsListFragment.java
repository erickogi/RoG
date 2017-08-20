package com.erickogi14gmail.rog.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;
import com.erickogi14gmail.rog.utills.StaggeredHiddingScrollListener;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class chatsListFragment extends Fragment {
    private View view;
    private Fragment fragment = null;
    private ArrayList<ChatsListPojo> chatsListPojo=new ArrayList<>();

    RecyclerView recyclerView;

    private ChatsListAdapter chatsListAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    static int groupId;
    static String groupName;
   

    private void setView(){
        getActivity().setTitle("Chats");
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        chatsListAdapter=new ChatsListAdapter(getContext(),populateList());
        chatsListAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(chatsListAdapter);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chat_list_fragment, container, false);
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
             //   Chat.isMain=false;
                groupId=chatsListPojo.get(position).getChat_id();
                groupName=chatsListPojo.get(position).getSender_name();
                //popOutFragments();
                fragment = new ChatThreadFragment();
                setUpView();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }
    private ArrayList<ChatsListPojo> populateList() {
        chatsListPojo.clear();
        ChatsListPojo chatsListPojo=new ChatsListPojo(1,4,"Youths","Okay thank you i will do that");
        ChatsListPojo chatsListPojo1=new ChatsListPojo(2,2,"Church-General","Next sabbath we are to submit our pledges if am not wrong");
        ChatsListPojo chatsListPojo3=new ChatsListPojo(3,4,"Camp Meeting organizing ","i think monday we can meet");
        this.chatsListPojo.add(chatsListPojo);
        this.chatsListPojo.add(chatsListPojo1);
        this.chatsListPojo.add(chatsListPojo3);
        return this.chatsListPojo;
    }
    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
        }

    }
    void popOutFragments(){
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        for(int i=0;i<fragmentManager.getBackStackEntryCount();i++){
            fragmentManager.popBackStack();
        }
    }









}
