package com.erickogi14gmail.rog.utills;

/**
 * Created by kimani kogi on 5/30/2017.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.erickogi14gmail.rog.Bible.Adapter;
import com.erickogi14gmail.rog.Bible.BiblePojo;
import com.erickogi14gmail.rog.Bible.DBOperation;
import com.erickogi14gmail.rog.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyWebViewClient extends WebViewClient {
    private Context context;
    private ArrayList<BiblePojo> biblePojo=new ArrayList<>();
    private Adapter adapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    DBOperation dbOperation;
    RecyclerView recyclerView;
    Dialog dialog;
    public MyWebViewClient(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (!url.isEmpty()) {
            try {
              // URL aURL = new URL(url);
                Log.d("urlk",url);
                String qs[] = url.split("##");
//
//                System.out.println("protocol = " + aURL.getProtocol());
//                System.out.println("authority = " + aURL.getAuthority());
//                System.out.println("host = " + aURL.getHost());
//                System.out.println("port = " + aURL.getPort());
//                System.out.println("path = " + aURL.getPath());
//                System.out.println("query = " + aURL.getQuery());
//                System.out.println("filename = " + aURL.getFile());
//                System.out.println("ref = " + aURL.getRef());
                openBible(Integer.valueOf(qs[1]),Integer.valueOf(qs[2]),Integer.valueOf(qs[3]));
               // onAddEventClicked(aURL.getPath(), aURL.getPath(), aURL.getQuery(), aURL.getQuery(), aURL.getRef());
            } catch (Exception e) {
                e.printStackTrace();
            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
    int cno=0;
    public void openBible(final int book, final int chapter, final int verse){
        int bkn=book;
        cno=chapter;
        dialog=new Dialog(context);
        dialog.setTitle(getBook(book)+" : " +chapter+" : "+verse);
        dialog.setContentView(R.layout.bible_dialog);
        recyclerView=(RecyclerView)dialog.findViewById(R.id.recycleView);
        dbOperation=new DBOperation(context);
        adapter = new Adapter(context, dbOperation.getList(book,chapter,verse));
        adapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(verse-1);

        Button buttonL=(Button)dialog.findViewById(R.id.left);
        Button buttonR=(Button)dialog.findViewById(R.id.right);

        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cno!=1) {
                    cno--;
                }
                adapter = new Adapter(context, dbOperation.getList(book,cno,verse));
                adapter.notifyDataSetChanged();
                dialog.setTitle(getBook(book)+" : " +cno);
                recyclerView.setAdapter(adapter);
            }
        });
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cno!=66) {
                    cno++;
                }
                adapter = new Adapter(context, dbOperation.getList(book,cno,verse));
                adapter.notifyDataSetChanged();
                dialog.setTitle(getBook(book)+" : " +cno);
                recyclerView.setAdapter(adapter);
            }
        });

        dialog.show();



    }
public String getBook(int no){
    String bk=null;
    if(no==1){
        bk="Genesis";
    }
    if(no==2){
        bk="Exodus";
    }
    if(no==3){
        bk="Leviticus";
    }
    if(no==4){
        bk="Numbers";
    }
    if(no==5){
        bk="Deutronomy";
    }
    return bk;
}






    public void onAddEventClicked(String start, String end, String title, String desc, String loc)
            throws ParseException {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");


        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = formatter.parse(start.substring(1));
        Date endDate = formatter.parse(end.substring(1));

        long startTime = startDate.getTime();
        long endTime = endDate.getTime();


        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        Log.d("stringtotle1", title);
        intent.putExtra(CalendarContract.Events.TITLE, title.replace("%20", " ").replace("title", " ").replace("=", " "));
        intent.putExtra(CalendarContract.Events.DESCRIPTION, desc);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, loc);


        context.startActivity(intent);
    }
}