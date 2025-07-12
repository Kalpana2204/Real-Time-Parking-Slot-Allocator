package com.parking.realtimeallocator.model;

public class ParkingSlot {
    private int slotId;
    private boolean isOccupied;

    public ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.isOccupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
