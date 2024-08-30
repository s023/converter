package com.number.converter.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.number.converter.converter.strategies.BinaryToRomanConverter;
import com.number.converter.converter.Converter;
import com.number.converter.converter.strategies.DecimalToRomanConverter;

@Service
public class ConversionService {

    private final Map<String, Converter<?, ?>> converters = new HashMap<>();

    public ConversionService() {
        converters.put("decimal", new DecimalToRomanConverter());
        converters.put("binary", new BinaryToRomanConverter());
        // Next converter case goes here
    }

    public String convert(String type, Object input) {
        Converter converter = converters.get(type);
        if (converter == null) {
            throw new IllegalArgumentException("Unsupported conversion type: " + type);
        }
        if (input instanceof Integer) {
            return (String) converter.convert(input.toString());
        } else {
            return (String) converter.convert(input);
        }
    }
}
