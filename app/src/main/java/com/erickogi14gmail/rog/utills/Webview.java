package com.erickogi14gmail.rog.utills;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.erickogi14gmail.rog.Events.EventsPojo;
import com.erickogi14gmail.rog.R;
import com.erickogi14gmail.rog.Sermons.TextSermonPojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Webview extends AppCompatActivity {
    private int position;
    private ArrayList<TextSermonPojo> textSermonPojo;
    private String preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();
        if(intent.getBooleanExtra("isToday",false)){
          String title=  intent.getStringExtra("title");
           preview=   intent.getStringExtra("preview");
            getSupportActionBar().setTitle(title);
            set("trial.htm");
        }
        else {
            position = intent.getIntExtra("datapos", 0);
            textSermonPojo = (ArrayList<TextSermonPojo>) intent.getSerializableExtra("data");
            getSupportActionBar().setTitle(textSermonPojo.get(position).getSermon_title());
            set("trial.htm");
            preview = textSermonPojo.get(position).getSermon_preview();

        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              shareEvent(preview);
            }
        });
    }
    private void shareEvent(String text){
        Intent in = new Intent();
        in.setAction(Intent.ACTION_SEND);
        in.putExtra(Intent.EXTRA_TEXT, text );
        in.setType("text/plain");
        startActivity(in);
    }
    public void set(String htmlFilename){
        WebView htmlWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);


        AssetManager mgr = getBaseContext().getAssets();
        try {
            InputStream in = mgr.open(htmlFilename, AssetManager.ACCESS_BUFFER);
            final   String htmlContentInStringFormat = StreamToString(in);
            in.close();

            htmlWebView.loadDataWithBaseURL(null,null,null,null,null);
            htmlWebView.loadDataWithBaseURL(null, htmlContentInStringFormat, "text/html", "utf-8", null);
            htmlWebView.setWebViewClient(new WebViewClient() {



            });
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }
    public static String StreamToString(InputStream in) throws IOException {
        if(in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }

}
