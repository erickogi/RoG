package com.erickogi14gmail.rog.chat;

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
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;
import com.erickogi14gmail.rog.utills.StaggeredHiddingScrollListener;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class ChatThreadFragment extends Fragment {
    private View view;
    private ArrayList<ChatPojo> chatPojo=new ArrayList<>();


    RecyclerView recyclerView;

    private ChatsAdapter chatsAdapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;



    void setView(){
        chatPojo=populateList();
        ArrayList<ChatPojo> chatPojos=new ArrayList<>();
        for(int i=0;i<chatPojo.size();i++){
            if(chatPojo.get(i).getGroup_id()==chatsListFragment.groupId){
               chatPojos.add(chatPojo.get(i)) ;
            }
        }
        getActivity().setTitle(chatsListFragment.groupName);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerChat);
        chatsAdapter=new ChatsAdapter(getActivity(),chatPojos);
        chatsAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(chatsAdapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chat_thread, container, false);
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



            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }
    private ArrayList<ChatPojo> populateList() {
        ChatPojo chatPojo1=new ChatPojo(1,1,0,"hello there","Eric Kimani");

        ChatPojo chatPojo2=new ChatPojo(1,1,0,"hello there","Eric Kimani");
        ChatPojo chatPojo3=new ChatPojo(1,1,1,"hello to how may i help you","John Ogechi");
        ChatPojo chatPojo4=new ChatPojo(3,1,0,"I need attorney advice","Eric Kimani");
        ChatPojo chatPojo5=new ChatPojo(2,1,1,"On what Specifically .I hope you have read our terms and conditions and service pricing","George Mwanza");
        ChatPojo chatPojo6=new ChatPojo(2,1,0,"Yes sure i have","Eric Kimani");
        ChatPojo chatPojo7=new ChatPojo(3,1,0,"My car was involved in an accident and am supposed to appear before a court on Monday","Eric Kimani");
        ChatPojo chatPojo8=new ChatPojo(3,1,0,"I need couching","Eric Kimani");
        ChatPojo chatPojo9=new ChatPojo(3,1,1,"For couching you should book a face to face appointment","William Ruto");
        ChatPojo chatPojo10=new ChatPojo(1,1,0,"Okay thank you i will do that","Eric Kimani");

        this.chatPojo.add(chatPojo1);
        this.chatPojo.add(chatPojo2);
        this.chatPojo.add(chatPojo3);
        this.chatPojo.add(chatPojo4);
        this.chatPojo.add(chatPojo5);
        this.chatPojo.add(chatPojo6);
        this.chatPojo.add(chatPojo7);
        this.chatPojo.add(chatPojo8);
        this.chatPojo.add(chatPojo9);
        this.chatPojo.add(chatPojo10);

        return this.chatPojo;


    }

}
