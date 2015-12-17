package com.example.gabrielguedes.baseconverter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gabrielguedes.baseconverter.components.Display;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Gabriel Guedes on 14/12/2015.
 */
public class KeyBoardDec extends Fragment implements View.OnClickListener{
    private static Display disp;

    public static KeyBoardDec newInstance(Display display){
        disp = display;
        KeyBoardDec dec = new KeyBoardDec();

        return dec;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View layout = inflater.inflate(R.layout.dec_layout,null);
        ButterKnife.bind(this, layout);

        for(int i=0;i<10;i++)
            ((Button)(layout.findViewById(Constants.buttons.get(i)))).setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View v) {
        disp.setText(((Button) (v)).getText().toString());
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
