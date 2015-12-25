package com.example.gabrielguedes.baseconverter.components;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
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
    private Context context;
    private CoordinatorLayout rootLayout;

    public Display(TextView display,Context context,CoordinatorLayout rootLayout){
        this.display = display;
        digitsControl = new DigitsControl(this.display);
        this.context = context;
        this.rootLayout = rootLayout;
    }

    public boolean isEmpty(){
        return display.getText().equals("");
    }

    public void setText(String text){
        String s = isEmpty() ? text: display.getText()+text;
        display.setText(s);
        digitsControl.controlDigitDinamic(Constants.PIXEL_ONE_DIGIT);
    }
    public void setTextAll(String textAll){
        for(int i=0;i<textAll.length();i++)
            setText(String.valueOf(textAll.charAt(i)));
    }

    public String getText(){
        return display.getText().toString();
    }

    public TextView referenceDisplay(){
        return display;
    }

    public void cleanDisplay(){
        display.setText("");
        digitsControl.cleanCount();
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
            digitsControl.controlDigitDinamic(-Constants.PIXEL_ONE_DIGIT);
        }
    }

    public void copy(){
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData cd = ClipData.newPlainText("value",getText());
        cm.setPrimaryClip(cd);
        Snackbar.make(rootLayout,Constants.MESSAGE_COPY_NUMBER,Snackbar.LENGTH_SHORT).show();
    }
}
