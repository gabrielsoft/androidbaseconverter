package com.example.gabrielguedes.baseconverter.components;

import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.example.gabrielguedes.baseconverter.R;
import com.example.gabrielguedes.baseconverter.utilities.Constants;

/**
 * Created by Gabriel Guedes on 16/12/2015.
 */
public class FabPlus {
    private FloatingActionButton fabPlus;
    private FabBin fabBin;
    private FabDec fabDec;
    private FabHex fabHex;
    private FabOct fabOct;
    private CoordinatorLayout rootLayout;

    private float positionOpen;
    private float positionClose;
    private float positionFab;
    private boolean firstTime = true;

    private boolean fabIsOpen = false;

    public FabPlus(CoordinatorLayout rootLayout,FloatingActionButton fabPlus,FabBin fabBin,FabDec fabDec,FabHex fabHex,FabOct fabOct){
        this.fabPlus = fabPlus;
        this.fabBin = fabBin;
        this.fabDec = fabDec;
        this.fabHex = fabHex;
        this.fabOct = fabOct;
        this.rootLayout = rootLayout;
        calc();
    }

    public boolean isOpen(){
        return fabIsOpen;
    }

    public void animate(){
        if(isOpen()){
            toClose();
        }
        else{
            toOpen();
        }
    }

    public void toClose(){
        fabBin.toClose();
        fabDec.toClose();
        fabHex.toClose();
        fabOct.toClose();

        fabPlus.animate().x(positionClose)
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {
                        fabPlus.setClickable(false);
                    }
                })
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        fabPlus.setClickable(true);
                        setFabIsOpen(false);
                        setImageOfFabPlus();
                    }
                });
    }

    public void toOpen(){
        fabPlus.animate().x(positionOpen).
                withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        fabBin.toOpen();
                        fabDec.toOpen();
                        fabHex.toOpen();
                        fabOct.toOpen();
                        setFabIsOpen(true);
                        setImageOfFabPlus();
                    }
                });
    }

    public FloatingActionButton getFab(){
        return fabPlus;
    }

    private void setFabIsOpen(boolean value){
        this.fabIsOpen = value;
    }

    private void calc(){
        rootLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(firstTime){
                    float delta = (fabBin.getFab().getX() - fabBin.getFab().getWidth());
                    positionOpen = delta < 0 ? 0:delta;
                    delta = fabOct.getFab().getX() - (fabOct.getFab().getWidth())/2;
                    positionClose = delta;
                    firstTime = false;
                }


            }
        });
    }

    private void setImageOfFabPlus(){
        if(isOpen()){
            fabPlus.setImageResource(Constants.ic_copy);
        }
        else{
            fabPlus.setImageResource(Constants.ic_plus);
        }
    }

}
