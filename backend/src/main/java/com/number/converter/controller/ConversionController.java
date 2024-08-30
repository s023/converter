package com.number.converter.controller;

import com.number.converter.service.ConversionService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/convert")
public class ConversionController {

    private final ConversionService conversionService;

    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping()
    public String convert(@RequestParam String type, @RequestParam String input) {
        return conversionService.convert(type, input);
    }
}
