package com.example.smartparking.service;

import com.example.smartparking.model.ParkingSpot;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class ParkingLotService {
    private final List<ParkingSpot> spots = new ArrayList<>();

    @Value("${value.totalspots}")
    private int totalSpots;

    @PostConstruct
    private void init() {
        for (int i = 1; i <= totalSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    public List<ParkingSpot> getAllSpots() {
        return spots;
    }

    public void reserveSpot(int id) {
        spots.stream()
                .filter(spot -> spot.getId() == id)
                .findFirst()
                .ifPresent(ParkingSpot::reserve);
    }

    public void releaseSpot(int id) {
        spots.stream()
                .filter(spot -> spot.getId() == id)
                .findFirst()
                .ifPresent(ParkingSpot::release);
    }
}
