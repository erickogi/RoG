package com.erickogi14gmail.rog.Bible;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibleRead extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<BiblePojo> biblePojo=new ArrayList<>();
    private Adapter adapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fill();
            }
        });


        Intent intent =getIntent();
        int book=intent.getIntExtra("bookNo",1);
        int chapterNo=intent.getIntExtra("bookChapter",1);
        int verseNo=intent.getIntExtra("bookVerse",1);



        DBOperation dbOperation=new DBOperation(getApplicationContext());


        try {
            recyclerView = (RecyclerView) findViewById(R.id.recycleView);
            adapter = new Adapter(getApplicationContext(), dbOperation.getList());
            adapter.notifyDataSetChanged();
            mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(mStaggeredLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);


        }
        catch (Exception m){
            m.printStackTrace();
           // fill();
        }
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,recyclerView,new RecyclerTouchListener.ClickListener(){

            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }
    public String ReadFromfile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
            Toast.makeText(BibleRead.this, "e"+e, Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
                Toast.makeText(BibleRead.this, "e2"+e2, Toast.LENGTH_SHORT).show();
            }
        }
        return returnString.toString();
    }


    public void fill() {
        String query=   ReadFromfile("INSERT1.txt",getApplicationContext());

        DBOperation dbOperation=new DBOperation(getApplicationContext());
        if(dbOperation.insert(query)){
            Toast.makeText(this, "ddd", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "ffff", Toast.LENGTH_SHORT).show();


    }

}
