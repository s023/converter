package com.number.converter.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.number.converter.converter.strategies.DecimalToRomanConverter;

class DecimalToRomanConverterTest {

    @Test
    void testConvertValidInput() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();
        assertEquals("XXIII", converter.convert("23"));
        assertEquals("MCMXCIV", converter.convert("1994"));
    }

    @Test
    void testConvertInvalidInput() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> converter.convert("4000"));
        assertThrows(IllegalArgumentException.class, () -> converter.convert("0"));
    }
}
