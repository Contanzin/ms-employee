package com.github.Contanzin.ms_employee.controller.handlers.dto;

import java.time.Instant;

public class CustomErrorDTO {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
