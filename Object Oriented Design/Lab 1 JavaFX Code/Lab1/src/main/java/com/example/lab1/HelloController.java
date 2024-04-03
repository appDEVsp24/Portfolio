package com.example.lab1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {
    private int total = 100;

    @FXML
    private void addStudents(ActionEvent event) {
        // Adding students to the system
        // You can implement the logic here
        total += getInput("Enter the number of students you want to add:");
        showAlert("Successfully added the student to the system");
    }

    @FXML
    private void removeStudents(ActionEvent event) {
        // Removing students from the system
        // You can implement the logic here
        total -= getInput("Enter the number of students you want to remove:");
    }

    @FXML
    private void displayTotal(ActionEvent event) {
        // Displaying the total number of students
        showAlert("Total : " + total + " students registered.");
    }

    @FXML
    private void exit(ActionEvent event) {
        // Exiting the program
        showAlert("The program exited successfully. Restart to manage the records.");
        System.exit(0);
    }

    private int getInput(String message) {
        TextField inputField = new TextField();
        inputField.setPromptText(message);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getDialogPane().setContent(inputField);
        alert.showAndWait();
        return Integer.parseInt(inputField.getText());
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}