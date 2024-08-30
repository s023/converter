package com.number.converter.converter.strategies;

import com.number.converter.converter.Converter;

public class BinaryToRomanConverter implements Converter<String, String> {

    @Override
    public String convert(String input) {
        int decimalValue = Integer.parseInt(input, 2);
        DecimalToRomanConverter decimalConverter = new DecimalToRomanConverter();
        return decimalConverter.convert(String.valueOf(decimalValue));
    }
}
