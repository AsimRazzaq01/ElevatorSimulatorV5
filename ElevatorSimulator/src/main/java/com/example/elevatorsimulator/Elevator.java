package com.example.elevatorsimulator;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public abstract class Elevator {
    int currentFloor;
    List<Passanger> passengers;
    int maxCapacity;

    Elevator(int maxCapacity) {
        this.currentFloor = 1;
        this.passengers = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }
    abstract void move();
    // Accomadation for Elevator capacity
    boolean canAccommodatePassenger() {
        return passengers.size() < maxCapacity;
    }
    // method to add passangers staff/patient
    void addPassenger(Passanger passenger) {
        passengers.add(passenger);
        System.out.println("A" + (passenger.isStaff() ? "Staff" : "Patient") + " boarded the elevator at floor " + currentFloor);
    }
    // method to remove passangers staff/patient
    void removePassenger(Passanger passenger) {
        passengers.remove(passenger);
        System.out.println("A " + (passenger.isStaff() ? "Staff" : "Patient") + " left the elevator at floor " + currentFloor);
    }
    // method to count Patients
    int countPatients() {
        int count = 0;
        for (Passanger passenger : passengers) {
            if (!passenger.isStaff()) {
                count++;
            }
        }
        return count;
    }
    // method to count staff
    int countStaff() {
        int count = 0;
        for (Passanger passenger : passengers) {
            if (passenger.isStaff()) {
                count++;
            }
        }
        return count;
    }
}


// Run simulation with 2 elevators, 10 passengers, and 5 iterations
//   ElevatorSimulation simulation = new ElevatorSimulation(1, 100, 10);
//    simulation.runSimulation();