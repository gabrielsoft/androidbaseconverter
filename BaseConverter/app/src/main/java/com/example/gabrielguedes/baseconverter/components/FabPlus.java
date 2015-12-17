package com.example.gabrielguedes.baseconverter.components;

import android.support.design.widget.FloatingActionButton;
import com.example.gabrielguedes.baseconverter.Constants;

/**
 * Created by Gabriel Guedes on 16/12/2015.
 */
public class FabPlus {
    private FloatingActionButton fabPlus;
    private FabBin fabBin;
    private FabDec fabDec;
    private FabHex fabHex;
    private FabOct fabOct;

    private boolean fabIsOpen = false;

    public FabPlus(FloatingActionButton fabPlus,FabBin fabBin,FabDec fabDec,FabHex fabHex,FabOct fabOct){
        this.fabPlus = fabPlus;
        this.fabBin = fabBin;
        this.fabDec = fabDec;
        this.fabHex = fabHex;
        this.fabOct = fabOct;
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

        fabPlus.animate().x(fabOct.getFab().getX()-50)
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
        fabPlus.animate().x(fabBin.getFab().getX()-200).
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
}
