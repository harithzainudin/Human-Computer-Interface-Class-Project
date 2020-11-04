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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AttendanceController {

	// column for attend
	@FXML private TableView<Person> attend;
	@FXML private TableColumn<Person, String> fnameColumn;
	@FXML private TableColumn<Person, String> lnameColumn;
	@FXML private TableColumn<Person, String> matricNumColumn;
	@FXML private TableColumn<Person, String> groupNumColumn;
	@FXML private TableColumn<Person, String> courseColumn;

	// column for not attend
	@FXML private TableView<Person> notAttend;
	@FXML private TableColumn<Person, String> fnameColumnNA;
	@FXML private TableColumn<Person, String> lnameColumnNA;
	@FXML private TableColumn<Person, String> matricNumColumnNA;
	@FXML private TableColumn<Person, String> groupNumColumnNA;
	@FXML private TableColumn<Person, String> courseColumnNA;

	// method for closing the stage when close button is click
	public void exitStage(ActionEvent event) throws IOException {
		System.exit(0);
	}

	// method for go back button. when this button is click, it will go back to main page
	@FXML
	public void goToMain(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene mainScene = new Scene(mainParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(mainScene);
		window.show();
	}

	// method for refresh attend button. if this button is clicked , the table for attend will be refresh
	public void refresh() throws Exception {
		// read for attend
		Collection<Person> read = Files.readAllLines(new File("C:\\Users\\Admin\\Desktop\\attend.txt").toPath()).stream().map(line -> {
			String[] details = line.split (" , ");
			Person p = new Person();
			p.setFName(details[0]);
			p.setLName(details[1]);
			p.setMatricNum(details[2]);
			p.setGroupNum(details[3]);
			p.setCourse(details[4]);
			return p;
		}).collect(Collectors.toList());

		ObservableList<Person> details = FXCollections.observableArrayList(read);

		fnameColumn.setCellValueFactory(data -> data.getValue().fnameProperty());
		lnameColumn.setCellValueFactory(data -> data.getValue().lnameProperty());
		matricNumColumn.setCellValueFactory(data -> data.getValue().matricNumProperty());
		groupNumColumn.setCellValueFactory(data -> data.getValue().groupNumProperty());
		courseColumn.setCellValueFactory(data -> data.getValue().courseProperty());
		attend.setItems(details);

	}
	
	// method for refresh not attend button. if this button is clicked , the table for not attend will be refresh
	public void refreshNotAttend() throws Exception {
		// read for not attend 
		Collection<Person> readNot = Files.readAllLines(new File("C:\\Users\\Admin\\Desktop\\not attend.txt").toPath()).stream().map(line -> {
			String[] detailsNot = line.split (" , ");
			Person p = new Person();
			p.setFName(detailsNot[0]);
			p.setLName(detailsNot[1]);
			p.setMatricNum(detailsNot[2]);
			p.setGroupNum(detailsNot[3]);
			p.setCourse(detailsNot[4]);
			return p;
		}).collect(Collectors.toList());

		ObservableList<Person> detailsNot = FXCollections.observableArrayList(readNot);

		fnameColumnNA.setCellValueFactory(data -> data.getValue().fnameProperty());
		lnameColumnNA.setCellValueFactory(data -> data.getValue().lnameProperty());
		matricNumColumnNA.setCellValueFactory(data -> data.getValue().matricNumProperty());
		groupNumColumnNA.setCellValueFactory(data -> data.getValue().groupNumProperty());
		courseColumnNA.setCellValueFactory(data -> data.getValue().courseProperty());
		notAttend.setItems(detailsNot);
	}

} // end of class