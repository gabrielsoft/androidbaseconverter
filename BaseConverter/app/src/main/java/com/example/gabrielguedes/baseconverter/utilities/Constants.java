package com.example.gabrielguedes.baseconverter.utilities;

import com.example.gabrielguedes.baseconverter.R;

import java.util.HashMap;

/**
 * Created by Gabriel Guedes on 14/12/2015.
 */
public class Constants {
    public static final String CONTEUDO_DISPLAY = "CONTEUDO_DISPLAY";
    public static final String TAG_FRAGMENT = "TAG_FRAGMENT";
    public static final String TAG_BINARY = "BINARY";
    public static final String TAG_DECIMAL = "DECIMAL";
    public static final String TAG_HEXADECIMAL = "HEXADECIMAL";
    public static final String TAG_OCTAL = "OCTAL";

    public static final int BASE_INFO_BINARY = 2;
    public static final int BASE_INFO_DECIMAL = 10;
    public static final int BASE_INFO_HEXADECIMAL = 16;
    public static final int BASE_INFO_OCTAL = 8;

    public static final long LIMIT_NUMBER = 999999999999999L;


    public static final HashMap<Integer,Integer> buttons = new HashMap<Integer,Integer>(){{
        put(0, R.id.bt0);
        put(1,R.id.bt1);
        put(2,R.id.bt2);
        put(3,R.id.bt3);
        put(4,R.id.bt4);
        put(5,R.id.bt5);
        put(6,R.id.bt6);
        put(7,R.id.bt7);
        put(8,R.id.bt8);
        put(9,R.id.bt9);
        put(10,R.id.bta);
        put(11,R.id.btb);
        put(12,R.id.btc);
        put(13,R.id.btd);
        put(14,R.id.bte);
        put(15,R.id.btf);

    }};

}
