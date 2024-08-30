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
    public String convert(@RequestParam("type") String type, @RequestParam("input") String input) {
        return conversionService.convert(type, input);
    }
}
