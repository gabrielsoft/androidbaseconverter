package com.example.gabrielguedes.baseconverter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gabrielguedes.baseconverter.components.Display;


/**
 * Created by Gabriel Guedes on 14/12/2015.
 */
public class KeyBoardBin extends Fragment implements View.OnClickListener{
    private static Display disp;

    public static KeyBoardBin newInstance(Display display){
        disp = display;
        KeyBoardBin kb = new KeyBoardBin();

        return kb;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View layout = inflater.inflate(R.layout.bin_layout,null);

        for(int i=0;i<2;i++)
            ((Button)(layout.findViewById(Constants.buttons.get(i)))).setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View v) {
        disp.setText(((Button) (v)).getText().toString());
    }

}
