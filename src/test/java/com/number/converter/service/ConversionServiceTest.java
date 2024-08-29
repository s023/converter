package com.number.converter.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionServiceTest {

    @Test
    void testDecimalConversion() {
        ConversionService service = new ConversionService();
        String result = service.convert("decimal", "23");
        assertEquals("XXIII", result);
    }

    @Test
    void testBinaryConversion() {
        ConversionService service = new ConversionService();
        String result = service.convert("binary", "10111");
        assertEquals("XXIII", result);
    }

    @Test
    void testInvalidType() {
        ConversionService service = new ConversionService();
        assertThrows(IllegalArgumentException.class, () -> service.convert("hex", "1A"));
    }
}
