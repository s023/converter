package com.number.converter.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.number.converter.auditLog.model.AuditLog;
import com.number.converter.auditLog.repository.AuditLogRepository;
import com.number.converter.converter.strategies.BinaryToRomanConverter;
import com.number.converter.converter.Converter;
import com.number.converter.converter.strategies.DecimalToRomanConverter;

@Service
public class ConversionService {

    private final Map<String, Converter<?, ?>> converters = new HashMap<>();

    private AuditLogRepository auditLogRepository;

    public ConversionService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;

        converters.put("decimal", new DecimalToRomanConverter());
        converters.put("binary", new BinaryToRomanConverter());
        // Next converter case goes here
    }

    public String convert(String type, Object input) {
        Converter converter = converters.get(type);
        if (converter == null) {
            throw new IllegalArgumentException("Unsupported conversion type: " + type);
        }
        // Log the conversion

        String result;
        if (input instanceof Integer) {
            result = (String) converter.convert(input.toString());
        } else {
            result = (String) converter.convert(input);
        }
        logConversion(type, (String) input, result);
        return result;
    }

    private void logConversion(String type, String input, String result) {
        AuditLog auditLog = new AuditLog(LocalDateTime.now(), type, input, result);
        auditLogRepository.save(auditLog);
    }
}
