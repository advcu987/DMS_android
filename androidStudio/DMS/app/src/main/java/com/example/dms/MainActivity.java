package com.example.dms;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private Button StartButton = null;
    private VideoView videoView = null;
    private SurfaceHolder holder = null;
    private Camera camera = null;
    private static final String TAG = "Video";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            camera = Camera.open();
            camera.lock();
        } catch(RuntimeException re) {
            Log.v(TAG, "Could not initialize the Camera");
            re.printStackTrace();
        }

        videoView = (VideoView) this.findViewById(R.id.simpleVideoView);
        holder = videoView.getHolder();
        holder.addCallback((SurfaceHolder.Callback) this);


    }
}