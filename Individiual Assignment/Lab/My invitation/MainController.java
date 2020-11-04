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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {

	@FXML private ResourceBundle resources;
	@FXML private URL location;
	@FXML private TextField fname;
	@FXML private TextField groupNum;
	@FXML private TextField lname;
	@FXML private TextField matricNum;
	@FXML private ComboBox course;    

	/*
	 * change scene from main page scene to attendance scene and give alert if the textfield is empty.
	 * If the textfield is fully fill in, then it will be write to filewriter.
	 * This method will be call if the attend button is click.
	 */
	public void attendButton(ActionEvent event) throws IOException {
		StringBuilder sb = new StringBuilder();
		if ((fname.getText().trim().isEmpty()) || (lname.getText().trim().isEmpty()) || (matricNum.getText().trim().isEmpty()) || (groupNum.getText().trim().isEmpty())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Empty Information");
			alert.setHeaderText("No Information inserted");
			alert.setContentText("Please fill in the information to proceed!");
			alert.showAndWait();
		}

		else {
			sb.append(fname.getText().toString()+ " , ");
			sb.append(lname.getText().toString()+ " , ");
			sb.append(matricNum.getText().toString()+ " , ");
			sb.append(groupNum.getText().toString()+ " , ");
			sb.append(course.getValue().toString());

			File file = new File("C:\\Users\\Admin\\Desktop\\attend.txt");

			FileWriter w;

			try {
				String newLine = System.getProperty("line.separator");
				w = new FileWriter(file,true);
				w.write(sb.toString() + newLine);
				w.close();

				Parent mainParent = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
				Scene mainScene = new Scene(mainParent);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(mainScene);
				window.show();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end of else statement
	} // end of attendButton method

	// change scene from main page to attendance scene if the not attend button is clicked.
	public void notAttendButton(ActionEvent event) throws IOException {
		StringBuilder sb = new StringBuilder();
		if ((fname.getText().trim().isEmpty()) || (lname.getText().trim().isEmpty()) || (matricNum.getText().trim().isEmpty()) || (groupNum.getText().trim().isEmpty())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Empty Information");
			alert.setHeaderText("No Information inserted");
			alert.setContentText("Please fill in the information to proceed!");
			alert.showAndWait();

		} else {
			sb.append(fname.getText().toString()+ " , ");
			sb.append(lname.getText().toString()+ " , ");
			sb.append(matricNum.getText().toString()+ " , ");
			sb.append(groupNum.getText().toString()+ " , ");
			sb.append(course.getValue().toString());

			File file = new File("C:\\Users\\Admin\\Desktop\\not attend.txt");
			FileWriter w;
			try {
				String newLine = System.getProperty("line.separator");
				w = new FileWriter(file,true);
				w.write(sb.toString() + newLine);
				w.close();
				Parent mainParent = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
				Scene mainScene = new Scene(mainParent);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(mainScene);
				window.show();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end of else statement
	} // end of method notAttendButton

	// this method for list button that when click will go to attendance scene
	@FXML
	public void goToList(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
		Scene mainScene = new Scene(mainParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(mainScene);
		window.show();
	}

	@FXML
	void initialize() {

		// initialize for course combo box
		course.getItems().addAll("Software Engineering", "Network", "Multimedia", "Computer System");
	}

} // end of class
