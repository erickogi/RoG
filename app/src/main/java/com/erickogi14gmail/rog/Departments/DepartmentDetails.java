package com.erickogi14gmail.rog.Departments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.erickogi14gmail.rog.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/15/2017.
 */

public class DepartmentDetails extends Fragment {
    private View view;
    private BottomNavigationView bottomNavigationView ;
    ImageView imageCall,imageText,imageEmail;
    TextView textView;
    ArrayList<DepartmentPojo> departmentPojos;
    int pos;
    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }

    private void showViews() {
        bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.department_details,container,false);
        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation);
        hideViews();
        imageCall=(ImageView)view.findViewById(R.id.call);
        imageText=(ImageView)view.findViewById(R.id.chat);
        imageEmail=(ImageView)view.findViewById(R.id.email);
        textView=(TextView)view.findViewById(R.id.text);

        departmentPojos=Departments.departmentPojos;
        pos=Departments.pos;

        textView.setText(departmentPojos.get(pos).getText());


        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+departmentPojos.get(pos).getPhoneNo()));
                startActivity(callIntent);

            }
        });
        imageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("sms:"+departmentPojos.get(pos).getPhoneNo()));
               smsIntent.putExtra("sms_body","");
                startActivity(smsIntent);

            }
        });
        imageEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rec[]={departmentPojos.get(pos).getEmailAddress()};

                emailResultsToUser(getActivity(),"","","",rec,null,null);
            }
        });
        return view;
    }
    public static void emailResultsToUser(Activity activity,
                                          String subject,
                                          String bodyText,
                                          String chooserTitle,
                                          String[] toRecipients,
                                          String[] ccRecipients,
                                          String[] bccRecipients) {
        Intent mailIntent = new Intent();
        mailIntent.setAction(Intent.ACTION_SEND);
        mailIntent.setType("message/rfc822");
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        mailIntent.putExtra(Intent.EXTRA_TEXT, bodyText);

        if (toRecipients != null) {
            mailIntent.putExtra(Intent.EXTRA_EMAIL, toRecipients);
        }
        if (ccRecipients != null) {
            mailIntent.putExtra(Intent.EXTRA_CC, ccRecipients);
        }
        if (bccRecipients != null) {
            mailIntent.putExtra(Intent.EXTRA_BCC, bccRecipients);
        }
        if (chooserTitle == null) chooserTitle = "Send Email";
        activity.startActivity(Intent.createChooser(mailIntent, chooserTitle));
    }

}
