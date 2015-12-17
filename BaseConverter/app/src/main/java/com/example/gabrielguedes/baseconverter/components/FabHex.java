package com.example.gabrielguedes.baseconverter.components;

import android.support.design.widget.FloatingActionButton;

import com.example.gabrielguedes.baseconverter.Animations;

/**
 * Created by Gabriel Guedes on 16/12/2015.
 */
public class FabHex implements FabAction{
    private FloatingActionButton fabHex;
    private Animations animations;

    public FabHex(FloatingActionButton fabHex){
        this.fabHex = fabHex;
    }

    public FloatingActionButton getFab(){
        return fabHex;
    }

    @Override
    public void toClose() {
        fabHex.setClickable(false);
        fabHex.startAnimation(animations.FAB_CLOSE);
    }

    @Override
    public void toOpen() {
        fabHex.setClickable(true);
        fabHex.startAnimation(animations.FAB_OPEN);
    }

    @Override
    public void setAnimations(Animations animations) {
        this.animations = animations;
    }
}
