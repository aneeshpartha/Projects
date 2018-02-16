/**
 * @author Aneesh Partha
 * @since 12/02/2016
 * File customermainpage.java
 * Final Project
 */

package Controller;

//Import statements
import java.io.IOException;
import Model.guisetup;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * This class is used for customer operations. Various operations like booking a ticket modifying user 
 * information is done using this class.
 * @author Aneesh Partha
 *
 */
public class customermainpage implements guisetup {

	public Button getBookticket() {
		return bookticket;
	}


	public void setBookticket(Button bookticket) {
		this.bookticket = bookticket;
	}


	public Button getCustomerdetail() {
		return customerdetail;
	}


	public void setCustomerdetail(Button customerdetail) {
		this.customerdetail = customerdetail;
	}


	public Button getMatrixdir() {
		return Matrixdir;
	}


	public void setMatrixdir(Button matrixdir) {
		Matrixdir = matrixdir;
	}


	public Button getLogout() {
		return logout;
	}


	public void setLogout(Button logout) {
		this.logout = logout;
	}

	@FXML
	private Button home = new Button();

	@FXML
	private Button bookticket = new Button();
	@FXML
	private Button customerdetail = new Button();
	@FXML
	private Button Matrixdir = new Button();
	@FXML
	private Button logout = new Button();
	

	
	/**
	 * This method is used for setting graphical user interface.It loads file Customerpage.fxml
	 * This file contains the GUI componenets.
	 * 
	 */
	
	public void setgui(){
	    
		//Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/Customerpage.fxml"));
		
		Scene scene = new Scene(root,700,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.getPrimarystage().setScene(scene);
		Main.getPrimarystage().show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	
	/**
	 * This method is triggered when the user triggers the book button.This will pass the control
	 * to datemovieController class
	 * @param event
	 * @throws Exception
	 */
	public void book(ActionEvent event) throws Exception{
		datemovieController obj = new datemovieController();
		obj.setgui();
	}
	
	/**
	 * This method is triggered when the user tries to logout. 
	 * @param event is generated when the logout button is clicked.
	 * @throws Exception is thrown incase if are any discrepancies.
	 */
	public void logout(ActionEvent event) throws Exception{
		
		Stage subStage = new Stage();
		subStage.setTitle("Alert");
		  FlowPane root = new FlowPane();
	        root.setAlignment(Pos.CENTER);
	        Scene scene = new Scene(root, 300, 200);
	        Label conf = new Label("You are logged out");
	        conf.setTranslateX(40);
	        conf.setTranslateY(-10);
	        Button buton = new Button("Logout");
	        buton.setTranslateX(-50);
	        buton.setTranslateY(50);
	        Main call = new Main();
	        buton.setOnAction(e -> call.start(subStage));
	        root.getChildren().addAll(conf,buton);
	        subStage.setScene(scene);
	        subStage.show();
	}
	
	
	/**
	 * This method is triggered when aboutus button is clicked . The about us button gives information
	 * about the theatre
	 * 
	 * @param event is the event generated when the button is clicked.
	 * @throws Exception when there is any during the run of the method
	 */
	public void aboutus(ActionEvent event) throws Exception{
		//Stage subStage = new Stage();
		//Stage subStage = new Stage();
		  Parent root = FXMLLoader.load(getClass().getResource("/View/aboutus.fxml"));
	        Scene scene = new Scene(root, 700, 500);
	        Main.getPrimarystage().setScene(scene);
	        Main.getPrimarystage().show();
	}
	
	/**
	 * This method is triggered when the home button is clicked.
	 * @param event is generated
	 * @throws Exception generated
	 */
	public void home(ActionEvent event) throws Exception{
		System.out.println("reached");
		setgui();
	}
	
	/**
	 * 
	 * This method is triggered when customer operation is selected.
	 * The control is passed to customerview class.
	 * 
	 */
	public void viewcustomer(ActionEvent event) throws Exception {
		
		customerview cust = new customerview();
		cust.setgui();
		
		
			}
		
	}
	
	

