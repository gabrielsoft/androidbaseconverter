package com.example.gabrielguedes.baseconverter.components;

import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by Gabriel Guedes on 14/12/2015.
 */
public class Display implements Serializable{
    private TextView display;

    public Display(TextView display){
        this.display = display;
    }

    public boolean isEmpty(){
        return display.equals("");
    }

    public void setText(String text){
        String s = isEmpty() ? text: display.getText()+text;
        display.setText(s);
    }

    public String getText(){
        return display.getText().toString();
    }

    public TextView referenceDisplay(){
        return display;
    }

    public void cleanDisplay(){
        display.setText("");
    }
}
