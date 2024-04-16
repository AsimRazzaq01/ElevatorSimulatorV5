package com.example.elevatorsimulator;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Box;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private GridPane gridPane; // Declare gridPane and annotate with @FXML
    private List<Elevator> elevators;
    private List<Elevator> elevators123;

    private int currentRow = 0; // Track the current row of the cube

    @FXML
    public void initialize() {
        // Initialize any necessary setup here
    }

    public void HelloController() {
        // Initialize elevators
        elevators = new ArrayList<>();
        elevators123 = new ArrayList<>();
        elevators.add(new StandardElevator(10)); // Standard Elevator
        elevators123.add(new ExpressElevator(8));   // Express Elevator
    }

    @FXML
    public void StartSimulation(ActionEvent event) {
        // Implement logic to start the simulation when the button is clicked
        ElevatorSimulation simulation = new ElevatorSimulation(elevators, 10, 5); // 10 passengers, 5 iterations
        simulation.runSimulation();
    }

    @FXML
    public void moveCubeUp(ActionEvent event) {
        for (Elevator elevator : elevators) {
            elevator.move(); // Move elevator
            // Check if elevator is at current row
            if (elevator.currentFloor == currentRow) {
                gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == currentRow && GridPane.getColumnIndex(node) == 2);
                currentRow--;
                gridPane.add(new Box(100, 40, 100), 2, currentRow);
            }
        }
    }

    @FXML
    public void moveCubeDown(ActionEvent event) {
        for (Elevator elevator : elevators) {
            elevator.move(); // Move elevator
            // Check if elevator is at current row
            if (elevator.currentFloor == currentRow) {
                gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == currentRow && GridPane.getColumnIndex(node) == 2);
                currentRow++;
                gridPane.add(new Box(100, 40, 100), 2, currentRow);
            }
        }
    }
}















/*
<?import javafx.scene.control.Button?>
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.elevatorsimulator.HelloController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>

    <Label fx:id="welcomeText"/>
    <Button text="Hello!" onAction="#onHelloButtonClick"/>
</VBox>

*/