package com.example.gabrielguedes.baseconverter.components;

import android.support.design.widget.FloatingActionButton;

import com.example.gabrielguedes.baseconverter.Animations;

/**
 * Created by Gabriel Guedes on 16/12/2015.
 */
public class FabBin implements FabAction{
    private FloatingActionButton fabBin;
    private Animations animations;

    public FabBin(FloatingActionButton fabBin){
        this.fabBin = fabBin;
    }

    public FloatingActionButton getFab(){
        return fabBin;
    }

    @Override
    public void toClose() {
        if(animations!=null){
            fabBin.setClickable(false);
            fabBin.startAnimation(Animations.FAB_CLOSE);
        }

    }

    @Override
    public void toOpen() {
       if(animations!=null){
           fabBin.setClickable(true);
           fabBin.startAnimation(animations.FAB_OPEN);
       }
    }

    @Override
    public void setAnimations(Animations animations) {
        this.animations = animations;
    }
}
