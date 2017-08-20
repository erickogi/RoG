package com.erickogi14gmail.rog.Bible;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.utills.RecyclerTouchListener;
import com.erickogi14gmail.rog.utills.StaggeredHiddingScrollListener;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/14/2017.
 */

public class BookMarks extends Fragment {
    private View view;
    private Fragment fragment = null;

    Dialog dialog;
    RecyclerView recyclerView;
    private ArrayList<BiblePojo> biblePojo ;
    private Adapter adapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    DBOperation dbOperation;
    FloatingActionButton fab;
    final BibleRead bibleRead=new BibleRead();




    private void setView(){

        dbOperation=new DBOperation(getContext());
        biblePojo=dbOperation.getBookMarksList();
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        adapter=new Adapter(getContext(),biblePojo);
        adapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.prayermenu,container,false);
        getActivity().setTitle("BookMarks");
        setView();
        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment=new Bible();
                popOutFragments();
                setUpView();
            }
        });

        recyclerView.setOnScrollListener(new StaggeredHiddingScrollListener() {

            @Override
            public void onHide() {
            fab.hide();
            }

            @Override
            public void onShow() {
             fab.show();

            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),recyclerView,new RecyclerTouchListener.ClickListener(){

            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, final int position) {
                dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.long_press_bookmark);
             //   dialog.setTitle("Actions");
                TextView txtDelete = (TextView) dialog.findViewById(R.id.delete);
                TextView txtShare = (TextView) dialog.findViewById(R.id.share);
                TextView txtCopy = (TextView) dialog.findViewById(R.id.copy);

                txtDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(dbOperation.deleteBookMark(biblePojo.get(position).getId())){
                            dialog.dismiss();
                            setView();
                            Toast.makeText(getContext(), "Deleted .", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            dialog.dismiss();
                            Toast.makeText(getContext(), "Error Deleting.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                txtShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareEvent(bibleRead.bookName(biblePojo.get(position).getB()) + ":" + "" + biblePojo.get(position).getC() + ":" + biblePojo.get(position).getV() + "\n" + biblePojo.get(position).getT().toString());
                        dialog.dismiss();
                    }
                });
                txtCopy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        copyText(bibleRead.bookName(biblePojo.get(position).getB()) + ":" + "" + biblePojo.get(position).getC() + ":" + biblePojo.get(position).getV() + "\n" + biblePojo.get(position).getT().toString());
                        dialog.dismiss();
                    }
                });
                dialog.show();





            }
        }));
        return view;
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
    private void shareEvent(String text) {
        Intent in = new Intent();
        in.setAction(Intent.ACTION_SEND);
        in.putExtra(Intent.EXTRA_TEXT, text);
        in.setType("text/plain");
        startActivity(in);
    }

    private void copyText(String text) {
        ClipboardManager clip = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("verse", text);
        clip.setPrimaryClip(clipData);
        Toast.makeText(getContext(), "Copied To Clipboard .", Toast.LENGTH_SHORT).show();
    }
}
