package com.example.elevatorsimulator;
import javafx.beans.property.SimpleMapProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ElevatorSimulation class
public class ElevatorSimulation {
    List<Elevator> elevators;   //Standard Elevator
    List<Elevator> elevators123;  // Express Elevator
    List<Passanger> passengers;
    int numIterations;

    public ElevatorSimulation(List<Elevator> numElevators, int numPassengers, int numIterations) {
        elevators = new ArrayList<>();
        elevators123 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            elevators.add(new StandardElevator(10)); // Standard Elevator max capacity 10
            elevators123.add(new ExpressElevator(8));  // Express Elevator max capacity 8
        }

// Staff && passanger ratio
        passengers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numPassengers; i++) {
            int startingFloor = rand.nextInt(10) + 1; // Assuming 10 floors
            int destinationFloor = rand.nextInt(10) + 1;
            boolean isStaff = rand.nextDouble() < 0.5; // 50% chance of being a staff member
            if (isStaff) {
                passengers.add(new StaffPassenger(startingFloor, destinationFloor));
            } else {
                passengers.add(new PatientPassanger(startingFloor, destinationFloor));
            }


        }
        this.numIterations = numIterations;
    }

    public void runSimulation() {
        Random rand = new Random();
        for (int i = 0; i < numIterations; i++) {
            // Move elevators
            for (Elevator elevator : elevators) {
                elevator.move();
            }
            // Load and unload passengers Standerd Elevator
            for (Elevator elevator : elevators) {
                List<Passanger> passengersToRemove = new ArrayList<>();
                for (Passanger passenger : elevator.passengers) {
                    // Logic - remove & add passangers at stop
                    if (passenger.destinationFloor == elevator.currentFloor) {
                        passengersToRemove.add(passenger);
                    }
                }     // Remove Passangers
                for (Passanger passenger : passengersToRemove) {
                    elevator.removePassenger(passenger);
                }
                // ADD Passangers && pass < MaxCapacity
                for (Passanger passenger : passengers) {
                    if (passenger.startingFloor == elevator.currentFloor && elevator.canAccommodatePassenger()) {
                        elevator.addPassenger(passenger);
                    }
                }
            }
            // Express Elevator
            for (int j = 0; j < 1; j++) {
                // Move elevators
                for (Elevator Eelevator : elevators123) {
                    Eelevator.move();
                }
                // Load and unload passengers
                for (Elevator Eelevator : elevators123) {
                    List<Passanger> passengersToRemove = new ArrayList<>();
                    for (Passanger passenger : Eelevator.passengers) {
                        // Logic - remove & add passangers at stop
                        if (passenger.destinationFloor == Eelevator.currentFloor) {
                            passengersToRemove.add(passenger);
                        }
                    }     // Remove Passangers
                    for (Passanger passenger : passengersToRemove) {
                        Eelevator.removePassenger(passenger);
                    }
                    // ADD Passangers && pass < MaxCapacity
                    for (Passanger passenger : passengers) {
                        if (passenger.startingFloor == Eelevator.currentFloor && Eelevator.canAccommodatePassenger()) {
                            Eelevator.addPassenger(passenger);
                        }
                    }
                }

                // Display elevator status
                System.out.println();
                System.out.println("Iteration " + (i + 1) + ":");
                for (Elevator elevator : elevators) {
                    System.out.println("Elevator at floor " + elevator.currentFloor + " with " + elevator.countPatients() + " patients and " + elevator.countStaff() + " staff members");
                }
                for (Elevator Eelevator : elevators123) {
                    System.out.println("ExpressElevator at floor " + Eelevator.currentFloor + " with " + Eelevator.countPatients() + " patients and " + Eelevator.countStaff() + " staff members");
                }

                System.out.println();
            }
        }
    }
}


