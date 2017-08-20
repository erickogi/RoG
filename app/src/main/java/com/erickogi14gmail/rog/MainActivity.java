package com.erickogi14gmail.rog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.erickogi14gmail.rog.Bible.BiblePojo;
import com.erickogi14gmail.rog.Bible.DBOperation;
import com.erickogi14gmail.rog.Bible.JsonParser;
import com.erickogi14gmail.rog.Events.EventsFragment;
import com.erickogi14gmail.rog.Notifications.FragmentNotifications;
import com.erickogi14gmail.rog.volley.IResult;
import com.erickogi14gmail.rog.volley.VolleyService;
import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity  {
   static Fragment fragment=null;
    static IResult mResultCallback = null;
    static VolleyService mVolleyService;
    static  ArrayList<BiblePojo> biblePojos;
    int a=0;

   static MenuItem item;
    BottomNavigationView bottomNavigationView;
    DBOperation dbOperation;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVolleyCallback();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        fragment=new mainFragment();
        dbOperation=new DBOperation(this);
       // setUpView();

            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();
       // }

        BottomNavigationView bottomNavigationView = (BottomNavigationView)

                findViewById(R.id.bottom_navigation);

        Menu bmenu=bottomNavigationView.getMenu();

        MenuItem itemNotices=bmenu.getItem(1);
        BitmapDrawable iconBitmapNotices = (BitmapDrawable) itemNotices.getIcon();
        ActionItemBadge.update(this, itemNotices, iconBitmapNotices, ActionItemBadge.BadgeStyles.GREEN, 7);

        bottomNavigationView.setOnNavigationItemSelectedListener(



                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override

                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.action_sermons:
                               // isMain=true;
                                popOutFragments();
                                fragment=new mainFragment();


                                break;

                            case R.id.action_notices:
                               // isMain=false;
                                popOutFragments();
                                fragment=new FragmentNotifications();

                                break;

                            case R.id.action_events:
                               // isMain=false;
                                popOutFragments();
                                fragment=new EventsFragment();

                                break;



                        }


                        setUpView();

                        return true;

                    }

                });

    }



     void setUpView(){
        if(fragment!=null){
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).addToBackStack(null).commit();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item=menu.findItem(R.id.action_add_bible);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

//        if(check()){
//            Toast.makeText(this, "Bible Present", Toast.LENGTH_SHORT).show();
//        }
       // else {

       //     dio();
//            new Thread(new Runnable() {

//                @Override
 //               public void run() {
//          while(a<66) {
//
//           try {
//
//               Thread.sleep(10000);
//               System.gc();
//               } catch (InterruptedException e) {
//              e.printStackTrace();
//              }
//
//          }
//                }
//            }).start();
//            if(a==65){
//                progressDialog.dismiss();
//                  Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
//            }
           // progressDialog.dismiss();
         //   Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        }


           // if(fill()){
           //     Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
           // }
          //  return true;
        //}

        return super.onOptionsItemSelected(item);
    }
public void dio(){
if(a<66) {
    Back b = new Back();
    b.execute(String.valueOf(a + 1));
}
    else {
    Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
    if(progressDialog.isShowing()){
        progressDialog.dismiss();

    }
    }
    }

    @Override
    public void onBackPressed() {

        if(this.getFragmentManager().getBackStackEntryCount()==0){
           super.onBackPressed();
        }
        else
            getFragmentManager().popBackStack();

        showViews();


    }
    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }
    private void showViews() {
        bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

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
//            Toast.makeText(BibleRead.this, "e"+e, Toast.LENGTH_SHORT).show();
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
                //       Toast.makeText(BibleRead.this, "e2"+e2, Toast.LENGTH_SHORT).show();
            }
        }
        return returnString.toString();
    }
    public boolean fill() {
        // String names[]={"Genesis.txt","Exodus.txt","Leviticus.txt","Numbers.txt","Deutronomy.txt"};
        String names="INSERT1.txt";
        for (int am = 0; am < 1; am++) {
            String query = ReadFromfile(names, getApplicationContext());
            Log.d("GTk","hhhhhh"+query);
            DBOperation dbOperation = new DBOperation(getApplicationContext());

            //  String qs[] = query.split("||");

            //  for (int a = 0; a < qs.length; a++) {
            if (dbOperation.insert(query)) {
                // return  true;
                Log.d("GTk","DONE");

            }
            else{
                Log.d("GTk","NOT DONE");
            }

            // }


        }
        return  true;
    }
    private boolean check(){
        return dbOperation.getList(66, 22, 1) != null;
    }
    int noAt=1;
    private void downLoad(int no){


            requestDataContent("http://erickogi.co.ke/ca/api/v1/?action=get_bible&b="+no, 1);




    }
    public boolean toDb(final ArrayList<BiblePojo> biblePojo){
        final boolean[] s = {false};

                 new Thread(new Runnable() {

                     @Override
                     public void run() {
                         for (final BiblePojo b : biblePojo) {

                             s[0] = dbOperation.insertBible(b);

                         }
//                         try {
//                            // Thread.sleep(2000);
//                         } catch (InterruptedException e) {
//                             e.printStackTrace();
//                         }
                     }
                 }).start();
        if(s[0]){
            a++;
        }
        return s[0];
    }
    void initVolleyCallback() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, String response) {

             //static  ArrayList<BiblePojo> biblePojos = new ArrayList<>();

                if (requestType.equals("get_data")) {
                    biblePojos = JsonParser.parseData(response);
                    toDb(biblePojos);

                }


            }

            @Override
            public void notifyError(String requestType, VolleyError error) {
                try {
                    toast("Network Error");
                    error.printStackTrace();
//                    swipe_refresh_layout.setRefreshing(false);
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                } catch (Exception cont) {
                    cont.printStackTrace();
                }

            }
        };
    }
    public void requestDataContent(String uri, final int position) {

      //  positionClicked = position;
        mVolleyService = new VolleyService(mResultCallback, this);
        mVolleyService.getDataVolley("get_data", uri);

    }
    public void toast(String msg) {
        StyleableToast st = new StyleableToast(this, msg, Toast.LENGTH_SHORT);
        st.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        st.setTextColor(getResources().getColor(R.color.colorIcons));
        st.setIcon(R.drawable.ic_error_outline_white_24dp);

        st.setMaxAlpha();
        st.show();

    }
HashMap<Integer,String> books=new HashMap<>();
private class Back extends  AsyncTask<String,Void,String>{

    @Override
    protected void onPostExecute(String s) {
       super.onPostExecute(s);

        Toast.makeText(MainActivity.this, ""+a, Toast.LENGTH_SHORT).show();
        a++;
        dio();

    }

    @Override
    protected String doInBackground(String... params) {
        HashMap <Integer,String>books=new HashMap<>();
        {
            int book = Integer.valueOf(params[0]);
            final boolean[] success = {false};
            while (book < 67) {


                StringRequest stringRequest = new StringRequest(Request.Method.GET, params[0],
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response != null || !response.isEmpty()) {
                                    success[0] = true;


                                    biblePojos = JsonParser.parseData(response);
                                    toDb(biblePojos);


                                } else {

                                    success[0] = false;
                                }

                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {


                            }
                        });
                RetryPolicy policy = new DefaultRetryPolicy(600000, 10, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest).setRetryPolicy(policy);
            }
            book++;
        }
        return null;

    }
}





















    void popOutFragments(){
        FragmentManager fragmentManager=this.getSupportFragmentManager();
        for(int i=0;i<fragmentManager.getBackStackEntryCount();i++){
            fragmentManager.popBackStack();
        }
    }

   // public class  Do extends AsyncTask<URL,In>
}
