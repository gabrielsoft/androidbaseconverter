package com.example.gabrielguedes.baseconverter.gui_and_action;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gabrielguedes.baseconverter.R;
import com.example.gabrielguedes.baseconverter.components.Display;
import com.example.gabrielguedes.baseconverter.components.FabBin;
import com.example.gabrielguedes.baseconverter.components.FabDec;
import com.example.gabrielguedes.baseconverter.components.FabHex;
import com.example.gabrielguedes.baseconverter.components.FabOct;
import com.example.gabrielguedes.baseconverter.components.FabPlus;
import com.example.gabrielguedes.baseconverter.utilities.Animations;
import com.example.gabrielguedes.baseconverter.utilities.Constants;
import com.example.gabrielguedes.baseconverter.utilities.MyThread;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private FabPlus fabPlus;
    private FabBin fabBin;
    private FabDec fabDec;
    private FabHex fabHex;
    private FabOct fabOct;
    private Display display;

    @Bind(R.id.fab_plus)
    FloatingActionButton fplus;
    @Bind(R.id.fab_bin)
    FloatingActionButton fbin;
    @Bind(R.id.fab_dec)
    FloatingActionButton fdec;
    @Bind(R.id.fab_hex)
    FloatingActionButton fhex;
    @Bind(R.id.fab_oct)
    FloatingActionButton foct;
    @Bind(R.id.display)
    TextView disp;
    @Bind(R.id.bt_clean)
    ImageButton btClean;
    @Bind(R.id.bt_backspace)
    ImageButton btBackspace;
    @Bind(R.id.rootLayout)
    CoordinatorLayout rootLayout;

    private MyThread threadAnimation;

    private Animations animations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        display = new Display(disp);
        animations = new Animations(getApplicationContext());

        fabBin = new FabBin(fbin);
        fabDec = new FabDec(fdec);
        fabHex = new FabHex(fhex);
        fabOct = new FabOct(foct);

        fabPlus = new FabPlus(rootLayout,fplus,fabBin,fabDec,fabHex,fabOct);

        fabPlus.getFab().setOnClickListener(this);
        fabBin.getFab().setOnClickListener(this);
        fabDec.getFab().setOnClickListener(this);
        fabHex.getFab().setOnClickListener(this);
        fabOct.getFab().setOnClickListener(this);

        fabBin.setAnimations(animations);
        fabDec.setAnimations(animations);
        fabHex.setAnimations(animations);
        fabOct.setAnimations(animations);

        btClean.setOnClickListener(this);
        btBackspace.setOnClickListener(this);

        configContentDisplay(savedInstanceState);
        configFragment(savedInstanceState);
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
        ft.replace(R.id.area_buttons,KeyBoardHex.newInstance(display), Constants.TAG_HEXADECIMAL);
        ft.commit();
    }

    private void onAttachKeyBoardBin(){
        FragmentTransaction ft = beginTransaction();
        ft.replace(R.id.area_buttons,KeyBoardBin.newInstance(display),Constants.TAG_BINARY);
        ft.commit();
    }

    private void onAttachKeyBoardDec(){
        FragmentTransaction ft = beginTransaction();
        ft.replace(R.id.area_buttons,KeyBoardDec.newInstance(display),Constants.TAG_DECIMAL);
        ft.commit();
    }

    private void onAttachKeyBoardOct(){
        FragmentTransaction ft = beginTransaction();
        ft.replace(R.id.area_buttons,KeyBoardOct.newInstance(display),Constants.TAG_OCTAL);
        ft.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String s = display.getText();
        outState.putString(Constants.CONTEUDO_DISPLAY, s);
        outState.putInt(Constants.TAG_FRAGMENT,display.getBaseCurrent());
    }

    private void configContentDisplay(Bundle savedInstanceState){
        if(savedInstanceState!=null){
            String s = savedInstanceState.getString(Constants.CONTEUDO_DISPLAY);
            display.setTextAll(s);
        }
    }

    private void configFragment(Bundle savedInstanceState){
        if(savedInstanceState!=null){
            int base = savedInstanceState.getInt(Constants.TAG_FRAGMENT);
            chooseFragment(base);
        }
        else{
            chooseFragment(Constants.BASE_INFO_DECIMAL);
        }
    }

    private void chooseFragment(int base){
        switch(base){
            case Constants.BASE_INFO_BINARY:
                onAttachKeyBoardBin(); break;
            case Constants.BASE_INFO_HEXADECIMAL:
                onAttachKeyBoardHex(); break;
            case Constants.BASE_INFO_OCTAL:
                onAttachKeyBoardOct(); break;
            default:
                onAttachKeyBoardDec();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
