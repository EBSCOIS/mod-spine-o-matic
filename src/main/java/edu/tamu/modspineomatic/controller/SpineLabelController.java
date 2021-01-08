package edu.tamu.modspineomatic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tamu.modspineomatic.service.SpineLabelPrinter;

@RestController
@RequestMapping("/spine-label")
public class SpineLabelController {

    @Value("${okapi.tenant}")
    private String tenant;

    @Autowired
    private SpineLabelPrinter spineLabelPrinter;

    @GetMapping
    public String get(@RequestParam(required = true) String identifier) {
        return spineLabelPrinter.getSpineLabel(tenant, identifier);
    }

}
