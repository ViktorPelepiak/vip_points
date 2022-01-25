package com.vip.points.controller.rest;

import com.vip.points.util.TestDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test_data")
public class TestDataGenerationController {

    private final TestDataUtil testDataUtil;

    @Autowired
    public TestDataGenerationController(TestDataUtil testDataUtil) {
        this.testDataUtil = testDataUtil;
    }

    @GetMapping("/generate")
    public void generateTestData(){
        testDataUtil.generateTestData();
    }
}
