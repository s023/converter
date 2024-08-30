package com.number.converter.converter.strategies;

import com.number.converter.converter.Converter;

public class DecimalToRomanConverter implements Converter<String, String> {

    @Override
    public String convert(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Input must be between 1 and 3999");
        }

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[number / 1000] +
                hundreds[(number % 1000) / 100] +
                tens[(number % 100) / 10] +
                ones[number % 10];
    }
}
