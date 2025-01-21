package com.example.smartparking.model;

public class ParkingSpot {
    private int id;
    private boolean isReserved;

    public ParkingSpot(int id) {
        this.id = id;
        this.isReserved = false;
    }

    public int getId() {
        return id;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        this.isReserved = true;
    }

    public void release() {
        this.isReserved = false;
    }
}
