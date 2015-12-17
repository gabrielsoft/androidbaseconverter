package com.example.gabrielguedes.baseconverter.components;

import android.support.design.widget.FloatingActionButton;

import com.example.gabrielguedes.baseconverter.Animations;

/**
 * Created by Gabriel Guedes on 16/12/2015.
 */
public class FabOct implements FabAction{
    private FloatingActionButton fabOct;
    private Animations animations;

    public FabOct(FloatingActionButton fabOct){
        this.fabOct = fabOct;
    }

    public FloatingActionButton getFab(){
        return fabOct;
    }

    @Override
    public void toClose() {
        fabOct.setClickable(false);
        fabOct.startAnimation(Animations.FAB_CLOSE);
    }

    @Override
    public void toOpen() {
        fabOct.setClickable(true);
        fabOct.startAnimation(Animations.FAB_OPEN);
    }

    @Override
    public void setAnimations(Animations animations) {
        this.animations = animations;
    }
}
