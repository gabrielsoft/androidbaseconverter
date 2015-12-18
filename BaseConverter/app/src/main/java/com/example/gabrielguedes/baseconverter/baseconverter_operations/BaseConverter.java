package com.example.gabrielguedes.baseconverter.baseconverter_operations;

/**
 * Created by Gabriel Guedes on 18/12/2015.
 */
public class BaseConverter {
    public String convertDecimalToBinary(String number){
        return Long.toBinaryString(Long.parseLong(number));
    }
    public String convertDecimalToHexadecimal(String number){
        return Long.toHexString(Long.parseLong(number));
    }
    public String convertDecimalToOctal(String number){
        return Long.toOctalString(Long.parseLong(number));
    }
    public String convertBinaryToDecimal(String number){
        return String.valueOf(Long.parseLong(number, 2));
    }
    public String convertBinaryToHexadecimal(String number){
        String number_decimal = convertBinaryToDecimal(number);
        return convertDecimalToHexadecimal(number_decimal);
    }
    public String convertBinaryToOctal(String number){
        String number_decimal = convertBinaryToDecimal(number);
        return convertDecimalToOctal(number_decimal);
    }
    public String convertHexadecimalToBinary(String number){
        String number_decimal = convertHexadecimalToDecimal(number);
        return convertDecimalToBinary(number_decimal);
    }
    public String convertHexadecimalToOctal(String number){
        String number_decimal = convertHexadecimalToDecimal(number);
        return convertDecimalToOctal(number_decimal);
    }
    public String convertHexadecimalToDecimal(String number){
        long soma = 0;
        StringBuffer sb = new StringBuffer(number);
        sb = sb.reverse();
        for(int i=0;i<sb.length();i++){
            soma += Math.pow(16,i)*charToInt(sb.charAt(i));
        }
        return String.valueOf(soma);
    }
    private long charToInt(char c){
        switch(c){
            case 'a': return 10;
            case 'b': return 11;
            case 'c': return 12;
            case 'd': return 13;
            case 'e': return 14;
            case 'f': return 15;
            default : return new Long(String.valueOf(c));
        }
    }
    public String convertOctalToDecimal(String number){
        long soma = 0;
        StringBuffer sb = new StringBuffer(number);
        sb = sb.reverse();
        for(int i=0;i<sb.length();i++){
            soma += Math.pow(8,i)*Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        return String.valueOf(soma);
    }
    public String convertOctalToBinary(String number){
        String number_decimal = convertOctalToDecimal(number);
        return convertDecimalToBinary(number_decimal);
    }
    public String convertOctalToHexadecimal(String number){
        String number_decimal = convertOctalToDecimal(number);
        return convertDecimalToHexadecimal(number_decimal);
    }
}
