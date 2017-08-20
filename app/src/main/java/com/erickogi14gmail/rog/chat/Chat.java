package com.erickogi14gmail.rog.chat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.erickogi14gmail.rog.R;

public class Chat extends AppCompatActivity {
    private static Fragment fragment = null;
    static  boolean isMain=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //popOutFragments();
        fragment=new chatsListFragment();

        setUpView();
        
//        recyclerView=(RecyclerView)findViewById(R.id.recyclerChat);
//        chatsAdapter=new ChatsAdapter(Chat.this,populateList());
//        chatsAdapter.notifyDataSetChanged();
//        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(mStaggeredLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(chatsAdapter);


    }
    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
        }

    }
    void popOutFragments(){
        FragmentManager fragmentManager=this.getSupportFragmentManager();
        for(int i=0;i<fragmentManager.getBackStackEntryCount();i++){
            fragmentManager.popBackStack();
        }
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()==0) {
            super.onBackPressed();
        }
        else{
           getFragmentManager().popBackStack();
        }

    }
}
