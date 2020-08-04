package com.muverang.co.test.coincidences;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/coincidences")
public class CoincidenceFilterController {
    
    private static final Logger log = LoggerFactory.getLogger(CoincidenceFilterController.class);

    @Autowired
    private CoincidenceFilterService service;

    @RequestMapping("/findwords")
    public List<Map.Entry<String, Integer>> showWords() throws IOException {
        return service.readWords();
    }

    
}
