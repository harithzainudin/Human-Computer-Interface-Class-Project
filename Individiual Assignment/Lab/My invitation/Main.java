// Author: Muhammad Harith Bin Zainudin
// Matric Number: 192171
// Course code and name: SSE3306 Human Computer Interaction
// Lab Question: 1
// Lecturer: Dr. Azrina Binti Kamaruddin
/*
 * An invitation card is sent asking student to input their name to the forum.
 * The interface sketching is incomplete. Provide a suitable widgets on the
 * interface. The designer/developer may add more information on the interface
 * that could assist the organizer such as: matric number, group number and other
 * (only relevant information).
 * Then, the program, can produce a report that will list out students who can
 * attend and cannot attend to the program and also total numbers for both types.
 * Develop a program that uses: Border Pane and VBOX as the layout. The primary
 * stage must have the title My Invitation, minimize, maximize and close.
 */
// Objective: Analyze Problem And Construct Program Using GUI Components and applying design principles.
// Last Update: 12 May 2019 



package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static Object primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("My Invitation");
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
