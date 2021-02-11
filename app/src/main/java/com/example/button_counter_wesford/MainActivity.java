package com.example.button_counter_wesford;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "owenWilson";
    private MediaPlayer wowPlayer, invertedWow, oopsBaby;
    private ImageView owenWilson;
    private TextView display;
    private Button addButton, subtractButton, resetButton;
    private int counter = 0;
    private Animation fadeOut;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) this.findViewById(R.id.display);

        display.setText(String.valueOf(counter));

        addButton = (Button) this.findViewById(R.id.add_button);
        subtractButton = (Button) this.findViewById(R.id.subtract_button);
        resetButton = (Button) this.findViewById(R.id.reset_button);

        addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        
        wowPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wowc);
        invertedWow = MediaPlayer.create(getApplicationContext(), R.raw.reversedwow);
        oopsBaby = MediaPlayer.create(getApplicationContext(), R.raw.oopsbaby);


    }

    //Save and restore info thanks to https://android.jlelse.eu/handling-orientation-changes-in-android-7072958c442a
    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counter", counter);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        counter = savedInstanceState.getInt("counter");
        display.setText(String.valueOf(counter));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_button:
                counter++;
                wowPlayer.seekTo(0);
                wowPlayer.start();

                break;
            case R.id.subtract_button:
                counter--;
                invertedWow.seekTo(0);
                invertedWow.start();

                break;
            case R.id.reset_button:
                counter = 0;
                oopsBaby.seekTo(0);
                oopsBaby.start();

                break;
        }
        display.setText(String.valueOf(counter));
    }


}
