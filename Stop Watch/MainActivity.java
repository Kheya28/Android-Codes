package com.example.stop_watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int seconds=0;
    public boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();

    }
    public void onClickStart(View view){
        running = true;
    }
    public void onClickStop(View view){
        running = false;
    }
    public void onClickReset(View view){
        running = false;
        seconds =0;
    }
    public  void runTimer(){
        final TextView timeView=(TextView)findViewById(R.id.text);
        final Handler handler =new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours =seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs = seconds%60;
                String time= String.format("%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);

                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }


}
