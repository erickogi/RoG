package com.erickogi14gmail.rog.Appointment;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.erickogi14gmail.rog.R;

import java.util.Calendar;

/**
 * Created by kimani kogi on 8/16/2017.
 */

public class NewAppointment extends Fragment implements View.OnClickListener{
    private View view;
    private BottomNavigationView bottomNavigationView ;
    TextView textViewDate,textViewTime;
    Spinner spinner;
    EditText editTextComment;
    Button buttonSubmit,buttonCancel;
    private int mYear,mMonth,mDay,mHour,mMinute, cl;
    private Fragment fragment = null;
    private String to[]={"Choose Recipient","Rev. Mark Kim","Elder Mwangi","Pastor Mwan","Pastor Kingori"};

    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }

    private void showViews() {
        bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.new_appointment_dialog,container,false);
        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation);
        spinner=(Spinner)view.findViewById(R.id.spinnerTo);
        ArrayAdapter<String> simpleAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,to);
        spinner.setAdapter(simpleAdapter);
        textViewDate=(TextView)view.findViewById(R.id.txtDate);
        textViewTime=(TextView)view.findViewById(R.id.txtTime);
        buttonCancel=(Button)view.findViewById(R.id.btnCancel);
        buttonSubmit=(Button)view.findViewById(R.id.btnSubmit);

        textViewTime.setOnClickListener(this);
        textViewDate.setOnClickListener(this);

        buttonSubmit.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);

        hideViews();
        getActivity().setTitle("New Appointment");


        return view;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtDate:
                datePicker();
                break;
            case  R.id.txtTime:
                timePicker();
                break;
            case R.id.btnCancel:
                popOutFragments();
                fragment = new AppointmentFragment();
                setUpView();
                break;
            case R.id.btnSubmit:
                popOutFragments();
                fragment = new AppointmentFragment();
                setUpView();
                break;

        }
    }
    public void datePicker(){
        final Calendar c=Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay=c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),

                new DatePickerDialog.OnDateSetListener() {



                    @Override

                    public void onDateSet(DatePicker view, int year,

                                          int monthOfYear, int dayOfMonth) {



                        textViewDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);



                    }

                }, mYear, mMonth, mDay);

        datePickerDialog.show();
    }
    public void timePicker(){

        // Get Current Time

        final Calendar c = Calendar.getInstance();

        mHour = c.get(Calendar.HOUR_OF_DAY);

        mMinute = c.get(Calendar.MINUTE);




        // Launch Time Picker Dialog

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),

                new TimePickerDialog.OnTimeSetListener() {



                    @Override

                    public void onTimeSet(TimePicker view, int hourOfDay,

                                          int minute) {
                         String AM_PM;
                        if(hourOfDay<12){
                            AM_PM="AM";
                        }else {
                            AM_PM="PM";
                        }


                        textViewTime.setText(hourOfDay + ":" +  minute+"  "+AM_PM);

                    }

                }, mHour, mMinute, false);

        timePickerDialog.show();
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
}
