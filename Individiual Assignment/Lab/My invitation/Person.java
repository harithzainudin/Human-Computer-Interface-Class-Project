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

import javafx.beans.property.IntegerPropertyBase;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	StringProperty fname = new SimpleStringProperty();
	StringProperty lname = new SimpleStringProperty();
	StringProperty matricNum = new SimpleStringProperty();
	StringProperty groupNum = new SimpleStringProperty();
	StringProperty course = new SimpleStringProperty();

	// getter and setter for fname
	public final StringProperty getFName() {
		return this.fname;
	}

	public final void setFName(final java.lang.String fname) {
		this.fnameProperty().set(fname);
	}

	public final StringProperty fnameProperty() {
		return this.fname;
	}

	// getter and setter for lname
	public final StringProperty getLName() {
		return this.lname;
	}

	public final void setLName(final java.lang.String lname) {
		this.fnameProperty().set(lname);
	}

	public final StringProperty lnameProperty() {
		return this.lname;
	}

	// getter and setter for matricNum
	public final StringProperty getmatricNum() {
		return this.matricNum;
	}

	public final void setMatricNum(final java.lang.String matricNum) {
		this.matricNumProperty().set(matricNum);
	}

	public final StringProperty matricNumProperty() {
		return this.matricNum;
	}

	// getter and setter for groupNum
	public final StringProperty getGroupNum() {
		return this.groupNum;
	}

	public final void setGroupNum(final java.lang.String groupNum) {
		this.groupNumProperty().set(groupNum);
	}

	public final StringProperty groupNumProperty() {
		return this.groupNum;
	}

	// getter and setter for course
	public final StringProperty getCourse() {
		return this.course;
	}

	public final void setCourse(final java.lang.String course) {
		this.courseProperty().set(course);
	}

	public final StringProperty courseProperty() {
		return this.course;
	}
}