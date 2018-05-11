package com.ichigohoshimiya.frontoffice;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class AlertActivity extends AppCompatActivity {
    Button clickA3, clickA6, clickA7;
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        clickA3 = (Button) findViewById(R.id.a3);
        clickA6 = (Button) findViewById(R.id.a6);
        clickA7 = (Button) findViewById(R.id.a7);
        videoView = (VideoView) findViewById(R.id.video_view);
        mediaController = new MediaController(this);
    }

    public void a3(View v){
        String videoPath = "android.resource://com.ichigohoshimiya.frontoffice/" + R.raw.cloud;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }

    public void a6(View v){
        String videoPath = "android.resource://com.ichigohoshimiya.frontoffice/" + R.raw.cloud_1;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }

    public void a7(View v){
        String videoPath = "android.resource://com.ichigohoshimiya.frontoffice/" + R.raw.cloud_2;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
}
