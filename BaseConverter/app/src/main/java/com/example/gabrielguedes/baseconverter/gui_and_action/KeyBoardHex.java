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
public class KeyBoardHex extends Fragment implements View.OnClickListener{
    private static Display disp;

    public static KeyBoardHex newInstance(Display display){
        disp = display;
        KeyBoardHex hex = new KeyBoardHex();

        return hex;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(disp.getBaseCurrent()!=Constants.BASE_INFO_HEXADECIMAL){
            String n = convert(disp.getText());
            disp.cleanDisplay();
            disp.setText(n);
            new DigitsControl(disp.referenceDisplay()).controlDigitStatic();
            disp.setBaseCurrent(Constants.BASE_INFO_HEXADECIMAL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);

        View layout = inflater.inflate(R.layout.hex_layout,null);

        for(int i=0;i<16;i++)
            ((Button)(layout.findViewById(Constants.buttons.get(i)))).setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View v) {
        if(!disp.isEmpty()){
            long numero = Long.parseLong(BaseConverter.convertHexadecimalToDecimal(disp.getText()));
            if(numero<Constants.LIMIT_NUMBER)
                disp.setText(((Button) (v)).getText().toString());
        }
        else
            disp.setText(((Button) (v)).getText().toString());
    }

    private String convert(String number){
        if(!number.equals("") && number!=null){
            switch(disp.getBaseCurrent()){
                case Constants.BASE_INFO_BINARY:
                    return BaseConverter.convertBinaryToHexadecimal(number);
                case Constants.BASE_INFO_DECIMAL:
                    return BaseConverter.convertDecimalToHexadecimal(number);
                case Constants.BASE_INFO_OCTAL:
                    return BaseConverter.convertOctalToHexadecimal(number);
            }
        }
        return (disp.getText()==null ? "":disp.getText());
    }
}
