package com.erickogi14gmail.rog.Bible;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.volley.IResult;
import com.erickogi14gmail.rog.volley.VolleyService;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kimani kogi on 7/30/2017.
 */

public class Bible extends Fragment {
    private View view;
    LinearLayout locate,search,bookmarks,settings;
    private BottomNavigationView bottomNavigationView ;
    Dialog dialog;
    private Fragment fragment = null;
    boolean newT=false;
    DBOperation dbOperation=new DBOperation(getContext());
    static IResult mResultCallback = null;
    static VolleyService mVolleyService;
    static  ArrayList<BiblePojo> biblePojos;
    static ProgressDialog progressDialog;


    private void hideViews() {
        bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }

    private void showViews() {
        bottomNavigationView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_bible,container,false);
        initVolleyCallback();
        getActivity().setTitle("Bible");
        locate=(LinearLayout) view.findViewById(R.id.openLocate);
        search=(LinearLayout) view.findViewById(R.id.openSearch);
        bookmarks=(LinearLayout) view.findViewById(R.id.openBookmarks);
        settings=(LinearLayout) view.findViewById(R.id.openSettings);

        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation);
        hideViews();

        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocate();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new Dialog(getContext());
                dialog.setTitle("Bible Search");
                dialog.setContentView(R.layout.bible_search);
                Button submit=(Button)dialog.findViewById(R.id.btnSubmit);
                Button cancel=(Button)dialog.findViewById(R.id.btnCancel);
                final EditText edtSearch=(EditText) dialog.findViewById(R.id.editTextSearch);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edtSearch.getText().toString().isEmpty()){
                            edtSearch.setError("Field Cannot be Empty");
                        }else{
                            openSearch(edtSearch.getText().toString());
                        }
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();






            }
        });
        bookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookmarks();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
        return view;

    }

    public void openLocate(){
        final DBOperation dbOperation=new DBOperation(getContext());
        String testament[]={"Old Testament","New Testament"};
        final String booksO[]={"Genesis","Exodus","Leviticus","Numbers","Deuteronomy","Joshua","Judges","Ruth","1 Samuel","2 Samuel","1 Kings","2 Kings",
        "1 Chronicles","2 Chronicles","Ezra","Nehemiah","Esther","Job","Psalms","Proverbs","Ecclesiastes","Songs Of Solomon","Isaiah","Jeremiah",
        "Lamentations","Ezekiel","Daniel","Hosea","Joel","Amos","Obadiah","Jonah","Micah","Nahum","Habakkuk","Zephaniah","Haggai","Zechariah","Malachi"};
        final String booksN[]={"Mathew","Mark","Luke","John","Acts","Romans","1 Corinthians","2 Corinthians",
                "Galatians","Ephesians","Philippians","Colossians","1 Thessalonians","2 Thessalonians","1 Timothy","2 Timothy","Titus","Philemon" ,
                "Hebrew","James","1 peter","2 Peter","1 John","2 John","3 John","Jude","Revelation"};
        dialog=new Dialog(getContext());

        dialog.setContentView(R.layout.locatediolog);
        Button btnCancel=(Button)dialog.findViewById(R.id.btn_cancel) ;
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        Button btnOkay=(Button)dialog.findViewById(R.id.btn_okay);
        Spinner spinnerTestament=(Spinner)dialog.findViewById(R.id.spinnerTestament);
        final Spinner spinnerBook=(Spinner)dialog.findViewById(R.id.spinnerBook);
        final Spinner spinnerChapter=(Spinner)dialog.findViewById(R.id.spinnerChapter);
        final Spinner spinnerVerse=(Spinner)dialog.findViewById(R.id.spinnerVerse);

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),BibleRead.class);
                intent.putExtra("data", dbOperation.getList(bookNo(spinnerBook.getSelectedItem().toString()),spinnerChapter.getSelectedItemPosition()+1,spinnerVerse.getSelectedItemPosition()+1));
               // intent.putExtra("bookChapter",spinnerChapter.getSelectedItemPosition()+1);
                intent.putExtra("datapos",spinnerVerse.getSelectedItemPosition()+1);
                startActivity(intent);dialog.dismiss();}});

        try {

            spinnerTestament.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(parent.getItemAtPosition(position).toString().equalsIgnoreCase("Old Testament")){
                        newT=false;
                        ArrayAdapter<String> simpleAdapterB=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,booksO);
                        spinnerBook.setAdapter(simpleAdapterB);
                    }
                    else if(parent.getItemAtPosition(position).toString().equalsIgnoreCase("New Testament")){
                        newT=true;
                        ArrayAdapter<String> simpleAdapterB=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,booksN);
                        spinnerBook.setAdapter(simpleAdapterB);
                    }


                    else{

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            spinnerBook.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    int no;
                        if(newT){
                            no= dbOperation.getChapters(position+1+39);
                        }
                    else {
                            no= dbOperation.getChapters(position+1);
                        }

                    //Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
                    String items[]=new String[no];
                    for(int a=0;a<no;a++){
                        items[a]=String.valueOf(a+1);
                    }
                    ArrayAdapter<String> simpleAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,items);
                    spinnerChapter.setAdapter(simpleAdapter);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
             spinnerChapter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    int no;
                    if(newT){no=dbOperation.getVerses(spinnerBook.getSelectedItemPosition()+1+39,Integer.valueOf(spinnerChapter.getSelectedItem().toString()));

                    }else {
                        no=dbOperation.getVerses(spinnerBook.getSelectedItemPosition()+1,Integer.valueOf(spinnerChapter.getSelectedItem().toString()));

                    }
                    String items[]=new String[no];
                    for(int a=0;a<no;a++){
                        items[a]=String.valueOf(a+1);
                    }

                    ArrayAdapter<String> simpleAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,items);
                    spinnerVerse.setAdapter(simpleAdapter);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ArrayAdapter<String> simpleAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,testament);
            spinnerTestament.setAdapter(simpleAdapter);
        }catch (Exception a){
            Log.d("spinnerError",a.toString());
        }






        dialog.show();

    }
    public void openSearch(String textToSearch){
    DBOperation dbOperation=new DBOperation(getContext());
        ArrayList<BiblePojo> data = new ArrayList<>();
           data=    dbOperation.getBibleSearch(textToSearch);
       // if(!biblePojos.isEmpty()){
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            Log.d("polo",""+data);
            Intent intent = new Intent(getActivity(), BibleRead.class);
            intent.putExtra("data", data);
            intent.putExtra("datapos", 1);
            startActivity(intent);

            //  }
            //  else{
        }catch (Exception m) {
            m.printStackTrace();
            Toast.makeText(getContext(), "Not text Found", Toast.LENGTH_LONG).show();
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }

       // }

    }
    public void openBookmarks(){
      fragment=new BookMarks();
        //popOutFragments();
        setUpView();
    }
    public void openSettings(){
        dialog=new Dialog(getContext());
        dialog.setContentView(R.layout.bible_settings);
        TextView txtAdd= (TextView) dialog.findViewById(R.id.add);
        TextView txtRemove = (TextView) dialog.findViewById(R.id.invalidate);



        txtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (addBible()) {
                    dialog.dismiss();

                } else {

                    dialog.dismiss();
                    Toast.makeText(getContext(), "Error Adding To Bible", Toast.LENGTH_SHORT).show();
                }

            }

            private boolean addBible() {
                boolean results=false;
                if(check()) Toast.makeText(getContext(), "Bible Already Availabe", Toast.LENGTH_SHORT).show();
                else {
                    progressDialog = new ProgressDialog(getContext());
                    progressDialog.setCancelable(false);
                    progressDialog.setMessage("Downloading content.....");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setMax(66);

                    progressDialog.setIndeterminate(false);
                  //  progressDialog.show();
                 // for(int a=0;a<66;a++){
                      progressDialog.setProgress(8);
                      Back back=new Back();
                      back.execute("1");
                    // downLoad(a);
                 }
               // }
                return true;
            }
        });
        txtRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBOperation dbOperation=new DBOperation(getContext());
                if(dbOperation.deleteBible()){dialog.dismiss();
                Toast.makeText(getContext(), "DB Cleared", Toast.LENGTH_SHORT).show();}
                else {Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();}}
        });
           dialog.show();
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

    private boolean check(){
//        if(dbOperation.getList(66,22,1)==null){
//            return false;
//        }
//        else
            return false;
    }
    int noAt=1;
    private void downLoad(int no){


        requestDataContent("http://erickogi.co.ke/ca/api/v1/?action=get_bible&b="+no, 1);




    }
    int a=0;
    public boolean toDb(final ArrayList<BiblePojo> biblePojo){
        final boolean[] s = {false};

//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
                for ( int a=0;a<biblePojo.size();a++) {
try {
    if (dbOperation.insertBible(biblePojo.get(a))) {
        Log.d("logods",""+biblePojo.get(a).getB());
        s[0] = true;
    } else {
        s[0] = false;
    }
}catch (NullPointerException m){

}

                }
//                         try {
//                            // Thread.sleep(2000);
//                         } catch (InterruptedException e) {
//                             e.printStackTrace();
//                         }
//            }
//        }).start();
        if(s[0]){
            a++;
        }
        return s[0];
    }
    void initVolleyCallback() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, String response) {

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


        mVolleyService = new VolleyService(mResultCallback, getContext());
        mVolleyService.getDataVolley("get_data", uri);

    }
    public void toast(String msg) {
        StyleableToast st = new StyleableToast(getContext(), msg, Toast.LENGTH_SHORT);
        st.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        st.setTextColor(getResources().getColor(R.color.colorIcons));
        st.setIcon(R.drawable.ic_error_outline_white_24dp);

        st.setMaxAlpha();
        st.show();

    }

    private class Back extends AsyncTask<String,Void,Integer> {
        /**
         * Runs on the UI thread after {@link #publishProgress} is invoked.
         * The specified values are the values passed to {@link #publishProgress}.
         *
         * @param values The values indicating progress.
         * @see #publishProgress
         * @see #doInBackground
         */
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);
             if(s==66) {

                    Toast.makeText(getContext(), "Done" + a, Toast.LENGTH_SHORT).show();
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                }

            else{

                    if (progressDialog.isShowing()) {
                        progressDialog.setProgress(s/60*100);
                    }

            }


        }

        @Override
        protected Integer doInBackground(String... params) {
            HashMap<Integer,Integer> books=new HashMap<>();

            int a;
            {


                int book = Integer.valueOf(params[0]);
                final boolean[] success = {false};
                final DBOperation dbOperation = new DBOperation(getContext());
                for ( a = 1; a < 67; a++) {
                    final boolean[] s = {false};
                    if(!books.containsValue(a)){
                        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://erickogi.co.ke/ca/api/v1/?action=get_bible&b=" + a,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        if (response != null || !response.isEmpty()) {
                                            success[0] = true;
                                            // dbOperation=new DBOperation(getContext());
                                            try {

                                                biblePojos = JsonParser.parseData(response);
                                                Log.d("logods", biblePojos.get(0).getT());
                                                for (int a = 0; a < biblePojos.size(); a++) {
                                                    // try {
                                                    // Log.d("logods", "inserted" + biblePojos.get(a).getB() + "  " + biblePojos.get(a).getV());
// Log.d("logods", "Notinserted" + biblePojos.get(a).getB() + "  " + biblePojos.get(a).getV());
                                                    s[0] = dbOperation.insertBible(biblePojos.get(a));
                                                    //  }catch (NullPointerException m){

                                                    //  }

                                                }
                                             //   toDb(biblePojos);
                                            } catch (NullPointerException p) {
                                                p.printStackTrace();
                                            }

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
                        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                        requestQueue.add(stringRequest).setRetryPolicy(policy);




                        if(s[0]){
                            books.put(a,a);
                        }

                    }



                }
//                if(books.size()>=65){
//                       succes=true;
//            }
//                else {
//                    succes=false;
//                }

                book++;
            }
            return a;
        }
    }

    public int bookNo(String book){

        if(book.equalsIgnoreCase("Genesis")){
            return 1;
        }
        if(book.equalsIgnoreCase("Exodus")){
            return 2;
        }
        if(book.equalsIgnoreCase("Leviticus")){
            return 3;
        }
        if(book.equalsIgnoreCase("Numbers")){
            return 4;
        }
        if(book.equalsIgnoreCase("Deuteronomy")){
            return 5;
        }
        if(book.equalsIgnoreCase("Joshua")){
            return 6;
        }
        if(book.equalsIgnoreCase("Judges")){
            return 7;
        }
        if(book.equalsIgnoreCase("Ruth")){
            return 8;
        }
        if(book.equalsIgnoreCase("1 Samuel")){
            return 9;
        }
        if(book.equalsIgnoreCase("2 Samuel")){
            return 10;
        }
        if(book.equalsIgnoreCase("1 Kings")){
            return 11;
        }
        if(book.equalsIgnoreCase("2 Kings")){
            return 12;
        }
        if(book.equalsIgnoreCase("1 Chronicles")){
            return 13;
        }
        if(book.equalsIgnoreCase("2 Chronicles")){
            return 14;
        } if(book.equalsIgnoreCase("Ezra")){
            return 15;
        } if(book.equalsIgnoreCase("Nehemiah")){
            return 16;
        }
        if(book.equalsIgnoreCase("Esther")){
            return 17;
        }
        if(book.equalsIgnoreCase("Job")){
            return 18;
        }
        if(book.equalsIgnoreCase("Psalms")){
            return 19;
        }
        if(book.equalsIgnoreCase("Proverbs")){
            return 20;
        }
        if(book.equalsIgnoreCase("Ecclesiastes")){
            return 21;
        } if(book.equalsIgnoreCase("Songs Of Solomon")){
            return 22;
        } if(book.equalsIgnoreCase("Isaiah")){
            return 23;
        }
        if(book.equalsIgnoreCase("Jeremiah")){
            return 24;
        }
        if(book.equalsIgnoreCase("Lamentations")){
            return 25;
        }
        if(book.equalsIgnoreCase("Ezekiel")){
            return 26;
        }
        if(book.equalsIgnoreCase("Daniel")){
            return 27;
        }
        if(book.equalsIgnoreCase("Hosea")){
            return 28;
        } if(book.equalsIgnoreCase("Joel")){
            return 29;
        }
        if(book.equalsIgnoreCase("Amos")){
            return 30;
        }
        if(book.equalsIgnoreCase("Obadiah")){
            return 31;
        }
        if(book.equalsIgnoreCase("Jonah")){
            return 32;
        }
        if(book.equalsIgnoreCase("Micah")){
            return 33;
        }
        if(book.equalsIgnoreCase("Nahum")){
            return 34;
        }
        if(book.equalsIgnoreCase("Habakkuk")){
            return 35;
        }
        if(book.equalsIgnoreCase("Zephaniah")){
            return 36;
        }
        if(book.equalsIgnoreCase("Haggai")){
            return 37;
        }
        if(book.equalsIgnoreCase("Zechariah")){
            return 38;
        }
        if(book.equalsIgnoreCase("Malachi")){
            return 39;
        }
        if(book.equalsIgnoreCase("Mathew")){
            return 40;
        }
        if(book.equalsIgnoreCase("Mark")){
            return 41;
        }
        if(book.equalsIgnoreCase("Luke")){
            return 42;
        }
        if(book.equalsIgnoreCase("John")){
            return 43;
        }
        if(book.equalsIgnoreCase("Acts")){
            return 44;
        }
        if(book.equalsIgnoreCase("Romans")){
            return 45;
        }
        if(book.equalsIgnoreCase("1 Corinthians")){
            return 46;
        } if(book.equalsIgnoreCase("2 Corinthians")){
            return 47;
        } if(book.equalsIgnoreCase("Galatians")){
            return 48;
        }
        if(book.equalsIgnoreCase("Ephesians")){
            return 49;
        }
        if(book.equalsIgnoreCase("Philippians")){
            return 50;
        }
        if(book.equalsIgnoreCase("Colossians")){
            return 51;
        }
        if(book.equalsIgnoreCase("1 Thessalonians")){
            return 52;
        }
        if(book.equalsIgnoreCase("2 Thessalonians")){
            return 53;
        } if(book.equalsIgnoreCase("1 Timothy")){
            return 54;
        } if(book.equalsIgnoreCase("2 Timothy")){
            return 55;
        }
        if(book.equalsIgnoreCase("Titus")){
            return 56;
        }
        if(book.equalsIgnoreCase("Philemon")){
            return 57;
        }
        if(book.equalsIgnoreCase("Hebrew")){
            return 58;
        }
        if(book.equalsIgnoreCase("James")){
            return 59;
        }
        if(book.equalsIgnoreCase("1 Peter")){
            return 60;
        } if(book.equalsIgnoreCase("2 Peter")){
            return 61;
        }
        if(book.equalsIgnoreCase("1 John")){
            return 62;
        }
        if(book.equalsIgnoreCase("2 John")){
            return 63;
        }
        if(book.equalsIgnoreCase("3 John")){
            return 64;
        }
        if(book.equalsIgnoreCase("Jude")){
            return 65;
        }
        if(book.equalsIgnoreCase("Revalation")){
            return 66;
        }




    return  0;



    }
}
