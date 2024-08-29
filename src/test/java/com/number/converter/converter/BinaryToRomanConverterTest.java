package com.number.converter.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.number.converter.converter.strategies.BinaryToRomanConverter;

class BinaryToRomanConverterTest {

    @Test
    void testConvertValidInput() {
        BinaryToRomanConverter converter = new BinaryToRomanConverter();
        assertEquals("XXIII", converter.convert("10111"));
        assertEquals("MCMXCIV", converter.convert("11111001010"));
    }

    @Test
    void testConvertInvalidInput() {
        BinaryToRomanConverter converter = new BinaryToRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> converter.convert(""));
        assertThrows(IllegalArgumentException.class, () -> converter.convert("FB3"));
    }
}

