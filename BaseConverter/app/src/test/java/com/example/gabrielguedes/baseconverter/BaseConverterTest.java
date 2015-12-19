package com.example.gabrielguedes.baseconverter;

import com.example.gabrielguedes.baseconverter.baseconverter_operations.BaseConverter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Gabriel Guedes on 18/12/2015.
 */
public class BaseConverterTest {
    private BaseConverter baseConverter;

    @Before
    public void initialize(){
        baseConverter = new BaseConverter();
    }
    /*
    @Test
    public void convert_decimal_to_binary(){
        String binary_number = baseConverter.convertDecimalToBinary("9223372036854775807");
        Assert.assertEquals("111111111111111111111111111111111111111111111111111111111111111",binary_number);
    }*/
    /*
    @Test
    public void convert_decimal_to_hexadecimal(){
        String hexadecimal_number = baseConverter.convertDecimalToHexadecimal("9223372036854775807");
        Assert.assertEquals("7fffffffffffffff", hexadecimal_number);
    }*/
    /*
    @Test
    public void convert_decimal_to_octal(){
        String octal_number = baseConverter.convertDecimalToOctal("9223372036854775807");
        Assert.assertEquals("777777777777777777777",octal_number);
    }*/
    /*
    @Test
    public void convert_binary_to_decimal(){
        String number_decimal = baseConverter.convertBinaryToDecimal("111111111111111111111111111111111111111111111111111111111111111");
        Assert.assertEquals("9223372036854775807",number_decimal);
    }*/
    /*
    @Test
    public void convert_binary_to_hexadecimal(){
        String number_hexadecimal = baseConverter.convertBinaryToHexadecimal("1111");
        Assert.assertEquals("f",number_hexadecimal);
    }*/
    /*
    @Test
    public void convert_binary_to_octal(){
        String number_octal = baseConverter.convertBinaryToOctal("1111");
        Assert.assertEquals("17",number_octal);
    }*/
    /*
    @Test
    public void convert_hexadecimal_to_decimal(){
        String number_decimal = baseConverter.convertHexadecimalToDecimal("7dcb3");
        Assert.assertEquals("515251",number_decimal);
    }*/
    /*
    @Test
    public void convert_hexadecimal_to_octal(){
        String number_octal = baseConverter.convertHexadecimalToOctal("7dcb3");
        Assert.assertEquals("1756263",number_octal);
    }*/
    /*
    @Test
    public void convert_hexadecimal_to_binary(){
        String number_binary = baseConverter.convertHexadecimalToBinary("ba");
        Assert.assertEquals("10111010",number_binary);
    }*/
    /*
    @Test
    public void convert_octal_to_decimal(){
        String number_decimal = baseConverter.convertOctalToDecimal("272");
        Assert.assertEquals("186",number_decimal);

    }*/
    /*
    @Test
    public void convert_octal_to_binary(){
        String number_binary = baseConverter.convertOctalToBinary("272");
        Assert.assertEquals("10111010",number_binary);

    }*/
    /*
    @Test
    public void convert_octal_to_hexadecimal(){
        String number_binary = baseConverter.convertOctalToHexadecimal("272");
        Assert.assertEquals("ba",number_binary);
    }*/
    @Test
    public void convert_from_to(){
    }
}
