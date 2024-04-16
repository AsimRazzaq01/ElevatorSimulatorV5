package com.example.elevatorsimulator;

import java.util.Random;

public class ExpressElevator extends Elevator {
    ExpressElevator(int maxCapacity) {
        super(maxCapacity);
    }
    @Override
    void move() {
        // Implement movement logic for express elevator (random movement)
        Random rand = new Random();
        if (rand.nextBoolean()) {
            currentFloor = Math.min(currentFloor + 3, 10); // Assuming 10 floors and express elevator moves 2 floors at a time
        } else {
            currentFloor = Math.max(currentFloor - 3, 1);
        }
    }

}
