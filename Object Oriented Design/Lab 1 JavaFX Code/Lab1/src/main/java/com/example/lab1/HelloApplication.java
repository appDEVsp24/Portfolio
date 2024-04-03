package com.example.lab1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AtomicInteger total = new AtomicInteger(100);
        int option = 0;
        AtomicBoolean flag = new AtomicBoolean(true);
        Scanner in = new Scanner(System.in);

        VBox root = new VBox();
        Button[] buttons = new Button[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button();
        }
        buttons[0].setText("Add Students");
        buttons[1].setText("Remove Students");
        buttons[2].setText("Display Total");
        buttons[3].setText("Exit");

        for (Button button : buttons) {
            root.getChildren().add(button);
        }

        for (int i = 0; i < buttons.length; i++) {
            int choice = i + 1;
            buttons[i].setOnAction(event -> {
                switch (choice) {
                    case 1:
                        System.out.print("Enter the number of students you want to add:");
                        total.addAndGet(in.nextInt());
                        System.out.println("Successfully added the student to the system");
                        System.out.println("");
                        break;
                    case 2:
                        System.out.print("Enter the number of students you want to remove:");
                        total.addAndGet(-in.nextInt());
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println("Total : " + total + " students registered.");
                        System.out.println("");
                        break;
                    case 4:
                        flag.set(false);
                        System.out.println("################################");
                        System.out.println("The program exited successfully.");
                        System.out.println("Restart to manage the records.  ");
                        System.out.println("################################");
                        break;
                    default:
                        System.exit(0);
                }
            });
        }

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Student Registration Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}