package com.example.gabrielguedes.baseconverter.utilities;

import android.util.Log;
import android.util.TypedValue;
import android.view.ViewTreeObserver;
import android.widget.TextView;
/**
 * Created by Gabriel Guedes on 19/12/2015.
 */
public class DigitsControl {
    private static TextView display;
    private static float fontSizeDefault = 60;
    private boolean flip = false;
    private int displayWidth;
    private int countDigits;

    public DigitsControl(TextView display){
        this.display = display;
        countDigits = 0;
        calcWidth();
    }

    public void controlDigitDinamic(int pixel){
        countDigits+=pixel;
        if(displayWidth<countDigits) {
            setSizeFontSmall();
            flip = true;
        }
        else if(displayWidth>countDigits && flip){
            setSizeFontDefault();
            flip = false;
        }
    }

    public static void setSizeFontDefault(){
        display.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeDefault);
    }
    public static void setSizeFontSmall(){
        display.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeDefault/2);
    }
    private void calcWidth() {
        ViewTreeObserver observer = display.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                displayWidth = display.getWidth();
            }
        });
    }
    public void cleanCount(){
        countDigits = 0;
    }

}