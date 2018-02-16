package Controller;

/**
 * @author Aneesh Partha
 * @since 12/02/2016
 * File datemovieController.java
 * Final Project
 */

//import statements
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import Model.guisetup;
import application.Main;
import dao.daotheatrecheck;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * This class is for selecting the theatre and movie of location for the user. By doing this
 * the user can filter the location where he wants to watch the movie
 * @author Aneesh Partha
 *
 */
public class datemovieController implements Initializable,guisetup {

	@FXML
	private ComboBox<String> city;
	
	@FXML
	private ComboBox<String> movie;

	@FXML
	private DatePicker date;
	
	
	public ComboBox<String> getCity() {
		return city;
	}

	public void setCity(ComboBox<String> city) {
		this.city = city;
	}

	public ComboBox<String> getMovie() {
		return movie;
	}

	public void setMovie(ComboBox<String> movie) {
		this.movie = movie;
	}

	static String comboselect;
	static String moviefilter;
	static String datefilter;
	
	public DatePicker getDate() {
		return date;
	}

	public void setDate(DatePicker date) {
		this.date = date;
	}
	ObservableList<String> values = FXCollections.observableArrayList("chicago","New york","Las angeles","san fransisco","washington");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		city.setItems(values);
		}
	
	
	
	/**
	 * Setting up GUI for the class.
	 */
	public void setgui(){
		
		//Stage primaryStage= new Stage();
	    Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/datemovie.fxml"));
		
		Scene scene = new Scene(root,700,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.getPrimarystage().setScene(scene);
		Main.getPrimarystage().show();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	@FXML
	/**
	 * The method triggers action to database.information from database is filtered and brought
	 * in.
	 * This method is for city. 
	 */
	public void comboaction(ActionEvent event) throws Exception{
		comboselect= city.getValue();
		movie.getItems().clear();
		daotheatrecheck check = new daotheatrecheck();
		ResultSet result = check.getResultSet(comboselect);
			
		while(result.next()){
	    
			movie.getItems().add(result.getString("Theatre_name"));
		    
		}
		result.close();
			}
	
	@FXML
	/**
	 * This method performs the same action as the previous method but this time it is for movie.
	 * @param event
	 */
	public void comboactiontheatre(ActionEvent event){
		moviefilter=movie.getValue();
		System.out.println(moviefilter);
	}
	
	/**
	 * This function captures the date selected by the user.
	 * 
	 */
	public void datepick(ActionEvent event){
		datefilter=date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	@FXML
	/**
	 * Triggers when submit button is clicked. This passes the control to select the movie.
	 * 
	 * 
	 */
	public void submit(ActionEvent event) throws Exception{
		
	   mainpageController mainpage = new mainpageController(comboselect,moviefilter,datefilter);
	   mainpage.setgui();
	   
	  
	}
	
	/**
	 * Triggers when logout button is clicked.
	 * 
	 */
	public void logoutbutton(ActionEvent event) throws Exception{
		Main log = new Main();
		log.start(Main.getPrimarystage());
	}
	
	}


