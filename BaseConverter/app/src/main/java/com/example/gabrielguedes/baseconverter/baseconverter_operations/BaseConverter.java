package com.example.gabrielguedes.baseconverter.baseconverter_operations;

/**
 * Created by Gabriel Guedes on 18/12/2015.
 */
public class BaseConverter {
    public static String convertDecimalToBinary(String number){
        return Long.toBinaryString(Long.parseLong(number));
    }
    public static String convertDecimalToHexadecimal(String number){
        return Long.toHexString(Long.parseLong(number)).toUpperCase();
    }
    public static String convertDecimalToOctal(String number){
        return Long.toOctalString(Long.parseLong(number));
    }
    public  static String convertBinaryToDecimal(String number){
        return String.valueOf(Long.parseLong(number, 2));
    }
    public static String convertBinaryToHexadecimal(String number){
        String number_decimal = convertBinaryToDecimal(number);
        return convertDecimalToHexadecimal(number_decimal).toUpperCase();
    }
    public static String convertBinaryToOctal(String number){
        String number_decimal = convertBinaryToDecimal(number);
        return convertDecimalToOctal(number_decimal);
    }
    public static String convertHexadecimalToBinary(String number){
        String number_decimal = convertHexadecimalToDecimal(number);
        return convertDecimalToBinary(number_decimal);
    }
    public static String convertHexadecimalToOctal(String number){
        String number_decimal = convertHexadecimalToDecimal(number);
        return convertDecimalToOctal(number_decimal);
    }
    public static String convertHexadecimalToDecimal(String number){
        long soma = 0;
        StringBuffer sb = new StringBuffer(number);
        sb = sb.reverse();
        for(int i=0;i<sb.length();i++){
            soma += Math.pow(16,i)*charToInt(String.valueOf(sb.charAt(i)));
        }
        return String.valueOf(soma);
    }
    private static long charToInt(String c){
        switch(c){
            case "A": return 10;
            case "B": return 11;
            case "C": return 12;
            case "D": return 13;
            case "E": return 14;
            case "F": return 15;
            default : return new Long(String.valueOf(c));
        }
    }
    public static String convertOctalToDecimal(String number){
        long soma = 0;
        StringBuffer sb = new StringBuffer(number);
        sb = sb.reverse();
        for(int i=0;i<sb.length();i++){
            soma += Math.pow(8,i)*Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        return String.valueOf(soma);
    }
    public static String convertOctalToBinary(String number){
        String number_decimal = convertOctalToDecimal(number);
        return convertDecimalToBinary(number_decimal);
    }
    public static String convertOctalToHexadecimal(String number){
        String number_decimal = convertOctalToDecimal(number);
        return convertDecimalToHexadecimal(number_decimal).toUpperCase();
    }

}
