package com.number.converter.auditLog.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;
    private String conversionType;
    private String input;
    private String output;

    public AuditLog() {}

    public AuditLog(LocalDateTime timestamp, String conversionType, String input, String output) {
        this.timestamp = timestamp;
        this.conversionType = conversionType;
        this.input = input;
        this.output = output;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getConversionType() { return conversionType; }
    public void setConversionType(String conversionType) { this.conversionType = conversionType; }

    public String getInput() { return input; }
    public void setInput(String input) { this.input = input; }

    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
}

