package com.badawy.carservice.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.alphamovie.lib.AlphaMovieView;
import com.badawy.carservice.R;
import com.badawy.carservice.models.AboutUsDataModel;
import com.badawy.carservice.utils.Constants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

public class SplashScreenActivity extends AppCompatActivity {
    /**
     *
     * Created  by Ahmed Tarek 15/11/2019
     * Modified by Mahmoud Badawy 16/11/2019
     * ...
     **/


    // Splash Variables
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        hideSystemUI();
        setSplashScreen();

        //video view............... splash animation AHMED TAREK
        AlphaMovieView alphaMovieView = findViewById(R.id.splash_video);

        //build the video uri
        Uri uri=Uri.parse("android.resource://" +getPackageName() +
                "/" +R.raw.background_splash);

        alphaMovieView.setVideoFromUri(this,uri);


    }


    private void setSplashScreen() {

        // Time in MilliSeconds 1000 = 1 second
        int SPLASH_TIME_OUT = 3500;
        handler.postDelayed(runnable,SPLASH_TIME_OUT);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler!=null){
            handler.removeCallbacks(runnable);
        }
    }

    private void hideSystemUI() {

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}
