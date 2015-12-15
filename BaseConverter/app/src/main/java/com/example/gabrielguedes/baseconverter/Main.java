package com.example.gabrielguedes.baseconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gabrielguedes.baseconverter.components.Display;

public class Main extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fabPlus;
    private FloatingActionButton fabBin;
    private FloatingActionButton fabDec;
    private FloatingActionButton fabHex;
    private FloatingActionButton fabOct;

    private Animation fabOpen, fabClose;

    private boolean isFabOpen = false;

    private Display display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        display = new Display((TextView)findViewById(R.id.display));


        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);

        fabPlus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fabBin = (FloatingActionButton) findViewById(R.id.fab_bin);
        fabDec = (FloatingActionButton) findViewById(R.id.fab_dec);
        fabHex = (FloatingActionButton) findViewById(R.id.fab_hex);
        fabOct = (FloatingActionButton) findViewById(R.id.fab_oct);

        fabPlus.setOnClickListener(this);
        fabBin.setOnClickListener(this);
        fabDec.setOnClickListener(this);
        fabHex.setOnClickListener(this);
        fabOct.setOnClickListener(this);

        ((ImageButton)findViewById(R.id.bt_clean)).setOnClickListener(this);

        onAttachKeyBoardDec();

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab_plus:
                animationFabPlus();
                break;
            case R.id.fab_bin:
                onAttachKeyBoardBin();
                animationFabPlus();
                break;
            case R.id.fab_dec:
                onAttachKeyBoardDec();
                animationFabPlus();
                break;
            case R.id.fab_hex:
                onAttachKeyBoardHex();
                animationFabPlus();
                break;
            case R.id.fab_oct:
                onAttachKeyBoardOct();
                animationFabPlus();
                break;
            case R.id.bt_clean:
                display.cleanDisplay();

        }
    }

    private void animationFabPlus(){

        if(isFabOpen){
            fabBin.startAnimation(fabClose);
            fabDec.startAnimation(fabClose);
            fabHex.startAnimation(fabClose);
            fabOct.startAnimation(fabClose);

            fabBin.setClickable(false);
            fabDec.setClickable(false);
            fabHex.setClickable(false);
            fabOct.setClickable(false);

            fabPlus.animate().x(Constants.FAB_TRANSLATE_TO_RIGHT);

            isFabOpen = false;
        }
        else{
            fabPlus.animate().x(Constants.FAB_TRANSLATE_TO_LEFT).
                    withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            fabBin.startAnimation(fabOpen);
                            fabDec.startAnimation(fabOpen);
                            fabHex.startAnimation(fabOpen);
                            fabOct.startAnimation(fabOpen);

                            fabBin.setClickable(true);
                            fabDec.setClickable(true);
                            fabHex.setClickable(true);
                            fabOct.setClickable(true);
                        }
                    });
            isFabOpen = true;
        }
    }

    private FragmentTransaction beginTransaction(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        return ft;
    }

    private void onAttachKeyBoardHex(){
        FragmentTransaction ft = beginTransaction();
        ft.replace(R.id.area_buttons,KeyBoardHex.newInstance(display));
        ft.commit();
    }

    private void onAttachKeyBoardBin(){
        FragmentTransaction ft = beginTransaction();
        ft.replace(R.id.area_buttons,KeyBoardBin.newInstance(display));
        ft.commit();
    }

    private void onAttachKeyBoardDec(){
        FragmentTransaction ft = beginTransaction();
        ft.replace(R.id.area_buttons,KeyBoardDec.newInstance(display));
        ft.commit();
    }

    private void onAttachKeyBoardOct(){
        FragmentTransaction ft = beginTransaction();
        ft.replace(R.id.area_buttons,KeyBoardOct.newInstance(display));
        ft.commit();
    }
}
