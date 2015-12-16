package com.example.gabrielguedes.baseconverter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

    private MyThread threadAnimation;

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
        ((ImageButton)findViewById(R.id.bt_backspace)).setOnClickListener(this);

        onAttachKeyBoardDec();

        threadAnimation = new MyThread();

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab_plus:
                if(!isFabOpen){
                    threadAnimation = new MyThread();
                    threadAnimation.execute();
                }
                break;
            case R.id.fab_bin:
                onAttachKeyBoardBin();
                closeFab(); threadAnimation.cancel(true);
                break;
            case R.id.fab_dec:
                onAttachKeyBoardDec();
                closeFab();threadAnimation.cancel(true);
                break;
            case R.id.fab_hex:
                onAttachKeyBoardHex();
                closeFab();threadAnimation.cancel(true);
                break;
            case R.id.fab_oct:
                onAttachKeyBoardOct();
                closeFab();threadAnimation.cancel(true);
                break;
            case R.id.bt_clean:
                display.cleanDisplay();
                break;
            case R.id.bt_backspace:
                display.backspace();

        }
    }

    private void animationFabPlus(){

        if(isFabOpen){
           closeFab();
        }
        else{
            openFab();
        }
    }

    private void openFab(){
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

    private void closeFab(){
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

    private FragmentTransaction beginTransaction(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_in, R.anim.fragment_out);
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

    private class MyThread extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params){

            animationFabPlus();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            animationFabPlus();
        }
    }

}
