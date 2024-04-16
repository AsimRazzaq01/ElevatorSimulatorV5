package com.example.elevatorsimulator;

import java.util.Random;
public class StandardElevator extends Elevator{

    StandardElevator(int maxCapacity) {
        super(maxCapacity);
    }
    @Override
    void move() {
        // Implement movement logic for standard elevator (random movement)
        Random rand = new Random();
        if (rand.nextBoolean()) {
            currentFloor = Math.min(currentFloor + 1, 10); // Assuming 10 floors
        } else {
            currentFloor = Math.max(currentFloor - 1, 1);
        }
    }

}
