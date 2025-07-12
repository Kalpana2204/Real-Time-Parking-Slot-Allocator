package com.parking.realtimeallocator.controller;

import com.parking.realtimeallocator.service.ParkingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    private final ParkingService parkingService = new ParkingService();

    @PostMapping("/allocate")
    public String allocateSlot() {
        int slot = parkingService.allocateSlot();
        return (slot == -1) ? "No slots available" : "Slot allocated: " + slot;
    }

    @PostMapping("/release/{slotId}")
    public String releaseSlot(@PathVariable int slotId) {
        boolean success = parkingService.releaseSlot(slotId);
        return success ? "Slot " + slotId + " released" : "Invalid or already free slot.";
    }
}
