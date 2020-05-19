package com.sample.baran.reactive.sampleapp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Toll {
    private LocalDateTime passDate;
    private String numberPlate;
    private String state;

}
