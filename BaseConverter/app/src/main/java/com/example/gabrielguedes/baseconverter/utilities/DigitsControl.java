package com.example.gabrielguedes.baseconverter.utilities;

import android.util.TypedValue;
import android.widget.TextView;
/**
 * Created by Gabriel Guedes on 19/12/2015.
 */
public class DigitsControl {
    private final int LIMIT_DIGIT = 24;
    private static TextView display;
    private static float fontSizeDefault = 60;
    private boolean flip = false;

    public DigitsControl(TextView display){
        this.display = display;
    }

    public void controlDigitDinamic(){
            if(display.getText().length()==25){
                setSizeFontSmall();
                flip = true;
            }
            else if(display.getText().length()==24 && flip){
                setSizeFontDefault();
                flip = false;
            }
    }
    public static void controlDigitStatic(TextView display){
        if(display.getText().length()>=25)
            setSizeFontSmall();
        else
            setSizeFontDefault();
    }

    public static void setSizeFontDefault(){
        display.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeDefault);
    }
    public static void setSizeFontSmall(){
        display.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeDefault/2);
    }

}
