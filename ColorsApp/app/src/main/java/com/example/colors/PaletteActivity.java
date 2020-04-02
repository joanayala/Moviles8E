package com.example.colors;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {

    //Variables
    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View vieColors = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        //Get Components ID's
        sbrRed = findViewById(R.id.sbrRed);
        sbrGreen = findViewById(R.id.sbrGreen);
        sbrBlue = findViewById(R.id.sbrBlue);
        sbrAlpha = findViewById(R.id.sbrAlpha);
        vieColors = findViewById(R.id.vieColors);

        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

    }

    //#############################################
    //MENUS
    //#############################################

    //This method lets us show the menu on mobile app
    //Note: Only in this activity
    //Note: This method has not actions.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //#############################################
    //SEEKBAR'S
    //#############################################

    //Notification that the progress level has changed.
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {
        int r = sbrRed.getProgress();
        int g = sbrGreen.getProgress();
        int b = sbrBlue.getProgress();
        int a = sbrAlpha.getProgress();

        int color = Color.argb(a,r,g,b);
        vieColors.setBackgroundColor(color);

        //Toast.makeText(this, "The new color is: "+a, Toast.LENGTH_SHORT).show();
    }

    //Notification that the user has started a touch gesture
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Toast.makeText(this, "The user has started a touch gesture", Toast.LENGTH_SHORT).show();
    }

    //Notification that the user has finished a touch
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Toast.makeText(this, "The user has finished a touch", Toast.LENGTH_SHORT).show();
    }
}
