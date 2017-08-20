package com.erickogi14gmail.rog.utills;

import android.content.Intent;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

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

public class VideoPlayer extends AppCompatActivity {
    private int position;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    private ArrayList<TextSermonPojo> textSermonPojo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        position = intent.getIntExtra("datapos", 0);
        textSermonPojo = (ArrayList<TextSermonPojo>) intent.getSerializableExtra("data");
        getSupportActionBar().setTitle(textSermonPojo.get(position).getSermon_title());
        set("trial.htm");
//
    }

    public void play(View view) {
        VideoView vd=(VideoView)findViewById(R.id.videoView);
        vd.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.min);//for online use the url in videopath
        MediaController md=new MediaController(this);
        md.setAnchorView(vd);
        vd.setMediaController(md);

        vd.start();
        view.setVisibility(View.INVISIBLE);


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
            htmlWebView.setWebViewClient(new MyWebViewClient(this));
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
