package com.erickogi14gmail.rog.Bible;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;

import java.util.ArrayList;

public class BibleRead extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<BiblePojo> biblePojo = new ArrayList<>();
    private Adapter adapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    Dialog dialog;
    DBOperation dbOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                f();
//            }
//        });
        fab.hide();


        Intent intent = getIntent();
        int verseNo = intent.getIntExtra("datapos", 1);
        biblePojo = (ArrayList<BiblePojo>) intent.getSerializableExtra("data");
        // int book=intent.getIntExtra("data",null);
        // int chapterNo=intent.getIntExtra("bookChapter",1);
        // int verseNo=intent.getIntExtra("bookVerse",1);


        try {
            recyclerView = (RecyclerView) findViewById(R.id.recycleView);
            adapter = new Adapter(getApplicationContext(), biblePojo);
            adapter.notifyDataSetChanged();
            mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(mStaggeredLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
            recyclerView.scrollToPosition(verseNo - 1);


        } catch (Exception m) {
            m.printStackTrace();

        }
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, final int position) {
                dialog = new Dialog(BibleRead.this);
                dialog.setContentView(R.layout.long_press_verse);
               // dialog.setTitle("Actions");
                TextView txtBookmark = (TextView) dialog.findViewById(R.id.bookmark);
                TextView txtShare = (TextView) dialog.findViewById(R.id.share);
                TextView txtCopy = (TextView) dialog.findViewById(R.id.copy);

                txtBookmark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dbOperation = new DBOperation(BibleRead.this);

                        if (dbOperation.insertBookMark(biblePojo.get(position))) {
                            dialog.dismiss();
                            Toast.makeText(BibleRead.this, "Verse Added To BookMarks", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("abo",biblePojo.get(position).getT());
                            dialog.dismiss();
                            Toast.makeText(BibleRead.this, "Error Adding To BookMarks", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                txtShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareEvent(bookName(biblePojo.get(position).getB()) + ":" + "" + biblePojo.get(position).getC() + ":" + biblePojo.get(position).getV() + "\n" + biblePojo.get(position).getT().toString());
                        dialog.dismiss();
                    }
                });
                txtCopy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        copyText(bookName(biblePojo.get(position).getB()) + ":" + "" + biblePojo.get(position).getC() + ":" + biblePojo.get(position).getV() + "\n" + biblePojo.get(position).getT().toString());
                        dialog.dismiss();
                    }
                });
                dialog.show();


//                BiblePojo biblePojo=new BiblePojo();
//                biblePojo.setId(1);
//                biblePojo.setB(1);
//                biblePojo.setC(1);
//                biblePojo.setV(1);


            }
        }));


    }

    public String bookName(int id) {
        String bk = "";
        if (id == 1) {
            bk = "Genesis";
        }
        if (id == 2) {
            bk = "Exodus";
        }
        if (id == 3) {
            bk = "Leviticus";
        }
        if (id == 4) {
            bk = "Numbers";
        }
        if (id == 5) {
            bk = "Deutronomy";
        }
        if (id == 6) {
            bk = "Joshua";
        }
        if (id == 7) {
            bk = "Judges";
        }
        if (id == 8) {
            bk = "Ruth";
        }
        if (id == 9) {
            bk = "1 Samuel";
        }
        if (id == 10) {
            bk = "2 Samuel";
        }
        if (id == 11) {
            bk = "1 Kings";
        }
        if (id == 12) {
            bk = "2 Kings";
        }
        if (id == 13) {
            bk = "1 Chronicles";
        }
        if (id == 14) {
            bk = "2 Chronicles";
        }
        if (id == 15) {
            bk = "Ezra";
        }
        if (id == 16) {
            bk = "Nehemiah";
        }
        if (id == 17) {
            bk = "Esther";
        }
        if (id == 18) {
            bk = "Job";
        }
        if (id == 19) {
            bk = "Psalms";
        }
        if (id == 20) {
            bk = "Proverbs";
        }
        if (id == 21) {
            bk = "Ecclesiastes";
        }
        if (id == 22) {
            bk = "Songs of Solomon";
        }
        if (id == 23) {
            bk = "Isaiah";
        }
        if (id == 24) {
            bk = "Jeremiah";
        }
        if (id == 25) {
            bk = "Lamentations";
        }
        if (id == 26) {
            bk = "Ezekiel";
        }
        if (id == 27) {
            bk = "Daniel";
        }
        if (id == 28) {
            bk = "Hosea";
        }
        if (id == 29) {
            bk = "Joel";
        }
        if (id == 30) {
            bk = "Amos";
        }
        if (id == 31) {
            bk = "Obadiah";
        }
        if (id == 32) {
            bk = "Jonah";
        }
        if (id == 33) {
            bk = "Micah";
        }
        if (id == 34) {
            bk = "Nahum";
        }
        if (id == 35) {
            bk = "Habakkuk";
        }
        if (id == 36) {
            bk = "Zephaniah";
        }
        if (id == 37) {
            bk = "Haggai";
        }
        if (id == 38) {
            bk = "Zechariah";
        }
        if (id == 39) {
            bk = "Malachi";
        }
        if (id == 40) {
            bk = "Mathew";
        }
        if (id == 41) {
            bk = "Mark";
        }
        if (id == 42) {
            bk = "Luke";
        }
        if (id == 43) {
            bk = "John";
        }
        if (id == 44) {
            bk = "Acts";
        }
        if (id == 45) {
            bk = "Romans";
        }
        if (id == 46) {
            bk = "1 Corinthians";
        }
        if (id == 47) {
            bk = "2 Corithians";
        }
        if (id == 48) {
            bk = "Galatians";
        }
        if (id == 49) {
            bk = "Ephesians";
        }
        if (id == 50) {
            bk = "Philippians";
        }
        if (id == 51) {
            bk = "Colossians";
        }
        if (id == 52) {
            bk = "1 Thessalonians";
        }
        if (id == 53) {
            bk = "2 Thessalonians";
        }
        if (id == 54) {
            bk = "1 Timothy";
        }
        if (id == 55) {
            bk = "2 Timothy";
        }
        if (id == 56) {
            bk = "Titus";
        }
        if (id == 57) {
            bk = "Philemon";
        }
        if (id == 58) {
            bk = "Hebrews";
        }
        if (id == 59) {
            bk = "James";
        }
        if (id == 60) {
            bk = "1 Peter";
        }
        if (id == 61) {
            bk = "2 Peter";
        }
        if (id == 62) {
            bk = "1 John";
        }
        if (id == 63) {
            bk = "2 John";
        }
        if (id == 64) {
            bk = "3 John";
        }
        if (id == 65) {
            bk = "June";
        }
        if (id == 66) {
            bk = "Revalation";
        }
        return bk;
    }

    private void shareEvent(String text) {
        Intent in = new Intent();
        in.setAction(Intent.ACTION_SEND);
        in.putExtra(Intent.EXTRA_TEXT, text);
        in.setType("text/plain");
        startActivity(in);
    }

    private void copyText(String text) {
        ClipboardManager clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("verse", text);
        clip.setPrimaryClip(clipData);
        Toast.makeText(this, "Copied To Clipboard .", Toast.LENGTH_SHORT).show();
    }


    public void f() {
        boolean m = false;
//       new Thread(new Runnable() {
//           @Override
//           public void run() {
        try {
            Log.d("pppp", "gtd");
            // if( fill()){

            //  }
        } catch (Exception ml) {
            ml.printStackTrace();
        }


//           }
//       }).start();
    }


}
