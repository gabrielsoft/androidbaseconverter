package com.example.gabrielguedes.baseconverter.components;

import android.support.design.widget.FloatingActionButton;

import com.example.gabrielguedes.baseconverter.utilities.Animations;

/**
 * Created by Gabriel Guedes on 16/12/2015.
 */
public class FabDec implements FabAction{
    private FloatingActionButton fabDec;
    private Animations animations;

    public FabDec(FloatingActionButton fabDec){
        this.fabDec = fabDec;
    }

    public FloatingActionButton getFab(){
        return fabDec;
    }

    @Override
    public void toClose() {
        fabDec.setClickable(false);
        fabDec.startAnimation(animations.FAB_CLOSE);
    }

    @Override
    public void toOpen() {
        fabDec.setClickable(true);
        fabDec.startAnimation(animations.FAB_OPEN);
    }

    @Override
    public void setAnimations(Animations animations) {
        this.animations = animations;
    }
}
