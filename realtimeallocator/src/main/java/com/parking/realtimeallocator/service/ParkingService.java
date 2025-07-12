package com.parking.realtimeallocator.service;

import com.parking.realtimeallocator.model.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public class ParkingService {

    private final Map<Integer, ParkingSlot> slots = new HashMap<>();
    private final int totalSlots = 10;

    public ParkingService() {
        for (int i = 1; i <= totalSlots; i++) {
            slots.put(i, new ParkingSlot(i));
        }
    }

    public int allocateSlot() {
        for (Map.Entry<Integer, ParkingSlot> entry : slots.entrySet()) {
            if (!entry.getValue().isOccupied()) {
                entry.getValue().setOccupied(true);
                return entry.getKey();
            }
        }
        return -1; // No slots available
    }

    public boolean releaseSlot(int slotId) {
        if (slots.containsKey(slotId) && slots.get(slotId).isOccupied()) {
            slots.get(slotId).setOccupied(false);
            return true;
        }
        return false;
    }
}
