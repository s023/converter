package com.number.converter.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import com.number.converter.auditLog.repository.AuditLogRepository;

class ConversionServiceTest {
    private final AuditLogRepository mockedAuditLogRepository = Mockito.mock(AuditLogRepository.class);

    @Test
    void testDecimalConversionWithStringInput() {
        AuditLogRepository mockAuditLogRepository = Mockito.mock(AuditLogRepository.class);
        ConversionService service = new ConversionService(mockAuditLogRepository);
        String result = service.convert("decimal", "23");
        // Verify that the save method was called on the mock repository
        Mockito.verify(mockAuditLogRepository).save(Mockito.any());
        assertEquals("XXIII", result);

    }

    @Test
    void testDecimalConversionWithIntegerInput() {
        ConversionService service = new ConversionService(mockedAuditLogRepository);
        String result = service.convert("decimal", 23);
        assertEquals("XXIII", result);
    }

    @Test
    void testBinaryConversionWithStringInput() {
        ConversionService service = new ConversionService(mockedAuditLogRepository);
        String result = service.convert("binary", "10111");
        assertEquals("XXIII", result);
    }

    @Test
    void testBinaryConversionWithIntegerInput() {
        ConversionService service = new ConversionService(mockedAuditLogRepository);
        String result = service.convert("binary", 10111);
        assertEquals("XXIII", result);
    }

    @Test
    void testInvalidType() {
        ConversionService service = new ConversionService(mockedAuditLogRepository);
        assertThrows(IllegalArgumentException.class, () -> service.convert("hex", "1A"));
    }
}
