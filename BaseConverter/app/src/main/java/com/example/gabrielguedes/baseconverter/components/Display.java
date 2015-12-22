package com.example.gabrielguedes.baseconverter.components;

import android.widget.TextView;

import com.example.gabrielguedes.baseconverter.utilities.Constants;
import com.example.gabrielguedes.baseconverter.utilities.DigitsControl;

import java.io.Serializable;

/**
 * Created by Gabriel Guedes on 14/12/2015.
 */
public class Display implements Serializable{
    private TextView display;
    private int baseCurrent;
    private DigitsControl digitsControl;

    public Display(TextView display){
        this.display = display;
        digitsControl = new DigitsControl(display);
    }

    public boolean isEmpty(){
        return display.getText().equals("");
    }

    public void setText(String text){
        String s = isEmpty() ? text: display.getText()+text;
        display.setText(s);
        digitsControl.controlDigitDinamic(Constants.PIXEL_ONE_DIGIT);
    }

    public String getText(){
        return display.getText().toString();
    }

    public TextView referenceDisplay(){
        return display;
    }

    public void cleanDisplay(){
        display.setText("");
        digitsControl.setSizeFontDefault();
    }
    public void setBaseCurrent(int baseCurrent){
        this.baseCurrent = baseCurrent;
    }
    public int getBaseCurrent(){
        return baseCurrent;
    }

    public void backspace(){
        String s = display.getText().toString();
        if(s.length()>0){
            s = s.substring(0,s.length()-1);
            display.setText(s);
        }
        digitsControl.controlDigitDinamic(-Constants.PIXEL_ONE_DIGIT);
    }
}
