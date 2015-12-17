package com.example.gabrielguedes.baseconverter;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Gabriel Guedes on 16/12/2015.
 */
public class Animations {
    public static Animation FAB_OPEN = null;
    public static Animation FAB_CLOSE = null;

    public Animations(Context context){
        FAB_OPEN = AnimationUtils.loadAnimation(context,R.anim.fab_open);
        FAB_CLOSE = AnimationUtils.loadAnimation(context,R.anim.fab_close);
    }
}
