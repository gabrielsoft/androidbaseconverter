package com.example.gabrielguedes.baseconverter.gui_and_action;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gabrielguedes.baseconverter.R;
import com.example.gabrielguedes.baseconverter.baseconverter_operations.BaseConverter;
import com.example.gabrielguedes.baseconverter.components.Display;
import com.example.gabrielguedes.baseconverter.utilities.Constants;
import com.example.gabrielguedes.baseconverter.utilities.DigitsControl;


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
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(disp.getBaseCurrent()!=Constants.BASE_INFO_BINARY){
            String n = convert(disp.getText());
            disp.cleanDisplay();
            disp.setTextAll(n);
            disp.setBaseCurrent(Constants.BASE_INFO_BINARY);
        }
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
        if(!disp.isEmpty()){
            long numero = Long.parseLong(BaseConverter.convertBinaryToDecimal(disp.getText()));
            if(numero<Constants.LIMIT_NUMBER)
                disp.setText(((Button) (v)).getText().toString());
        }
        else
            disp.setText(((Button) (v)).getText().toString());
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    private String convert(String number){
        if(!number.equals("") && number!=null){
            switch(disp.getBaseCurrent()){
                case Constants.BASE_INFO_DECIMAL:
                    return BaseConverter.convertDecimalToBinary(number);
                case Constants.BASE_INFO_HEXADECIMAL:
                    return BaseConverter.convertHexadecimalToBinary(number);
                case Constants.BASE_INFO_OCTAL:
                    return BaseConverter.convertOctalToBinary(number);
            }
        }
        return (disp.getText()==null ? "":disp.getText());
    }
}
