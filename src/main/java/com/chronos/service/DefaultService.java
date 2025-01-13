package com.chronos.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class DefaultService {
    private static final Logger LOGGER = Logger.getLogger(DefaultService.class.getName());

    @PostConstruct
    public void addRoles() {
        LOGGER.info("Roles added successfully");
    }
}
