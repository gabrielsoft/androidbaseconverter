package com.example.gabrielguedes.baseconverter.utilities;

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
    public void controlDigitStatic(){
        int length = display.getText().length();
        countDigits+=length*Constants.PIXEL_ONE_DIGIT;
        if(displayWidth<countDigits)
            setSizeFontSmall();
    }

    public static void setSizeFontDefault(){
        display.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeDefault);
    }
    public static void setSizeFontSmall(){
        display.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeDefault/2);
    }
    private void calcWidth() {
        display.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayWidth = display.getWidth();
            }
        }, 1);
    }
    public void cleanCount(){
        countDigits = 0;
    }

}
