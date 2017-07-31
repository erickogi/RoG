package com.erickogi14gmail.rog;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.erickogi14gmail.rog.Events.EventsFragment;
import com.erickogi14gmail.rog.Notifications.FragmentNotifications;
import com.erickogi14gmail.rog.Sermons.FragmentSermons;
import com.mikepenz.actionitembadge.library.ActionItemBadge;

public class MainActivity extends AppCompatActivity {
   static Fragment fragment=null;
    static boolean isMain=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragment=new mainFragment();
        setUpView();

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
                                fragment=new mainFragment();


                                break;

                            case R.id.action_notices:
                               // isMain=false;
                                fragment=new FragmentNotifications();

                                break;

                            case R.id.action_events:
                               // isMain=false;
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(getFragmentManager().getBackStackEntryCount()==0){
           super.onBackPressed();
        }
        else

            getFragmentManager().popBackStack();

    }
}
