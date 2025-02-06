package com.Learning.Project.controller;

import com.Learning.Project.dto.response.HealthCheckResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

    private static final Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @GetMapping("/health-check")
    public HealthCheckResponseDTO healthCheck() {
        logger.info("Health check endpoint called");
        return new HealthCheckResponseDTO("Healthy");
    }
}
