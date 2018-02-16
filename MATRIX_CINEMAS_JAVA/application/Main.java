/**
 * @author Aneesh Partha
 * @since 12/02/2016
 * File BankRecords.java
 * Final Project
 */


package application;

//Import statements
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * This is the Main class from which the application starts and runs.The class extends application
 * class which forces to override start method.
 * The start method creates the primarystage which holds various scenes and nodes.
 * This Stage is used all over the application . There is change only in the scene on this stage.
 * This method loads the Loginview fxml file.
 * @author Aneesh Partha
 *
 */
public class Main extends Application {
	
  
	@Override
	public void start(Stage primaryStage) {
		try {
			primarystage=primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("/View/Loginview.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
			
			} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static Stage primarystage;
	public static Stage getPrimarystage() {
		return primarystage;
	}
	
		public static void setPrimarystage(Stage primarystage) {
		Main.primarystage = primarystage;
	}
		
		/**
		 * This method launches the application. This is the starting point of the application.
		 * @param args
		 */
	public static void main(String[] args) {
		launch(args);
	}
}
