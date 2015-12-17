package com.example.gabrielguedes.baseconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gabrielguedes.baseconverter.components.Display;
import com.example.gabrielguedes.baseconverter.components.FabBin;
import com.example.gabrielguedes.baseconverter.components.FabDec;
import com.example.gabrielguedes.baseconverter.components.FabHex;
import com.example.gabrielguedes.baseconverter.components.FabOct;
import com.example.gabrielguedes.baseconverter.components.FabPlus;

public class Main extends AppCompatActivity implements View.OnClickListener {
    private FabPlus fabPlus;
    private FabBin fabBin;
    private FabDec fabDec;
    private FabHex fabHex;
    private FabOct fabOct;

    private Display display;
    private MyThread threadAnimation;

    private Animations animations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        display = new Display((TextView)findViewById(R.id.display));

        animations = new Animations(getApplicationContext());

        fabBin = new FabBin((FloatingActionButton) findViewById(R.id.fab_bin));
        fabDec = new FabDec((FloatingActionButton) findViewById(R.id.fab_dec));
        fabHex = new FabHex((FloatingActionButton) findViewById(R.id.fab_hex));
        fabOct = new FabOct((FloatingActionButton) findViewById(R.id.fab_oct));

        fabPlus = new FabPlus(((FloatingActionButton) findViewById(R.id.fab_plus)),
                            fabBin,fabDec,fabHex,fabOct);

        fabPlus.getFab().setOnClickListener(this);
        fabBin.getFab().setOnClickListener(this);
        fabDec.getFab().setOnClickListener(this);
        fabHex.getFab().setOnClickListener(this);
        fabOct.getFab().setOnClickListener(this);

        fabBin.setAnimations(animations);
        fabDec.setAnimations(animations);
        fabHex.setAnimations(animations);
        fabOct.setAnimations(animations);

        ((ImageButton)findViewById(R.id.bt_clean)).setOnClickListener(this);
        ((ImageButton)findViewById(R.id.bt_backspace)).setOnClickListener(this);

        onAttachKeyBoardDec();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab_plus:
                if(!fabPlus.isOpen()){
                    threadAnimation = new MyThread(fabPlus);
                    threadAnimation.execute();
                }
                break;
            case R.id.fab_bin:
                onAttachKeyBoardBin();
                fabPlus.toClose(); threadAnimation.cancel(true);
                break;
            case R.id.fab_dec:
                onAttachKeyBoardDec();
                fabPlus.toClose();threadAnimation.cancel(true);
                break;
            case R.id.fab_hex:
                onAttachKeyBoardHex();
                fabPlus.toClose();threadAnimation.cancel(true);
                break;
            case R.id.fab_oct:
                onAttachKeyBoardOct();
                fabPlus.toClose();threadAnimation.cancel(true);
                break;
            case R.id.bt_clean:
                display.cleanDisplay();
                break;
            case R.id.bt_backspace:
                display.backspace();

        }
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

}
