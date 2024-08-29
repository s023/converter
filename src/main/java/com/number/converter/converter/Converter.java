package com.number.converter.converter;

public interface Converter<T, R> {
    R convert(T input);
}