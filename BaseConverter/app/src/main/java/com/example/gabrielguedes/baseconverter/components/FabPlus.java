package com.example.gabrielguedes.baseconverter.components;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.ViewTreeObserver;

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
                    }
                });
        setFabIsOpen(false);
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
                    }
                });
        setFabIsOpen(true);
    }

    public FloatingActionButton getFab(){
        return fabPlus;
    }

    private void setFabIsOpen(boolean value){
        this.fabIsOpen = value;
    }

    private void calc(){
        fabBin.getFab().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                float positionRootLayout = rootLayout.getX();
                positionOpen = (fabBin.getFab().getX()-250) < positionRootLayout ? positionRootLayout: fabBin.getFab().getX()-250;
            }
        });

        fabPlus.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                positionClose = fabOct.getFab().getX()-50;
            }
        });
    }
}
