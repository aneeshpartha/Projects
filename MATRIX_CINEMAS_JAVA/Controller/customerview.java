/**
 * @author Aneesh Partha
 * @since 12/02/2016
 * File customerview.java
 * Final Project
 */

package Controller;

//import statements
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import Model.guisetup;
import application.Main;
import dao.daocustomerview;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * This class is written to display the customer details to the user. By doing this the user can
 * modify his/her details by clicking modify button.
 * @author Aneesh Partha
 *
 */
public class customerview implements Initializable,guisetup {

	
	
	public TextField getTxtfield1() {
		return txtfield1;
	}

	public void setTxtfield1(TextField txtfield1) {
		this.txtfield1 = txtfield1;
	}

	public TextField getTxtfield2() {
		return txtfield2;
	}

	public void setTxtfield2(TextField txtfield2) {
		this.txtfield2 = txtfield2;
	}

	public TextField getTxtfield3() {
		return txtfield3;
	}

	public void setTxtfield3(TextField txtfield3) {
		this.txtfield3 = txtfield3;
	}

	public TextField getTxtfield4() {
		return txtfield4;
	}

	public void setTxtfield4(TextField txtfield4) {
		this.txtfield4 = txtfield4;
	}

	public TextField getTxtfield5() {
		return txtfield5;
	}

	public void setTxtfield5(TextField txtfield5) {
		this.txtfield5 = txtfield5;
	}

	public TextField getTxtfield6() {
		return txtfield6;
	}

	public void setTxtfield6(TextField txtfield6) {
		this.txtfield6 = txtfield6;
	}

	@FXML
	private TextField txtfield1 = new TextField();
	@FXML
	private TextField txtfield2 = new TextField();
	@FXML
	private TextField txtfield3 = new TextField();
	@FXML
	private TextField txtfield4 = new TextField();
	@FXML
	private TextField txtfield5 = new TextField();
	@FXML
	private TextField txtfield6 = new TextField();
	@FXML
	private Button modify = new Button();
	@FXML
	private Button save = new Button();
	@Override
	
	/**
	 * This method is used for creating GUI. It is a method of guisetup interface.This method
	 * loads Customerview.fxml file
	 */
	public void setgui(){
			
	
    Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource("/View/Customerview.fxml"));
	
	Scene scene = new Scene(root,700,500);
	//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	Main.getPrimarystage().setScene(scene);
	Main.getPrimarystage().show();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
			
			 {
		// TODO Auto-generated method stub
		
	}
}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		daocustomerview check = new daocustomerview();
		try {
			ResultSet result = check.getResultSet(loginController.getUsername(),loginController.getPassword());
			
			
			while(result.next()){
			txtfield1.setText(result.getString("Cust_id"));
			txtfield2.setText(result.getString("Cust_fname"));
			txtfield3.setText(result.getString("Cust_lname"));
			txtfield4.setText(result.getString("Cust_phno"));
			txtfield5.setText(result.getString("cust_email"));
			txtfield6.setText(result.getString("cust_address"));
			
			}
			
			save.setVisible(false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method is triggered when modify button is clicked.This sets all the textfield to editable
	 * so that user can change the value. 
	 * 
	 * 
	 */
	public void modifybutton(ActionEvent event) throws Exception{
		
		System.out.println("Editable");
		txtfield2.setEditable(true);
		txtfield3.setEditable(true);
		txtfield4.setEditable(true);
		txtfield5.setEditable(true);
		txtfield6.setEditable(true);
		save.setVisible(true);
		
		Stage subStage = new Stage();
		subStage.setTitle("Alert");
		  FlowPane root = new FlowPane();
	        root.setAlignment(Pos.CENTER);
	        Scene scene = new Scene(root, 300, 200);
	        Label conf = new Label("You can modify your information now");
	        conf.setTranslateX(40);
	        conf.setTranslateY(-10);
	        Button buton = new Button("OK");
	        buton.setTranslateX(-50);
	        buton.setTranslateY(50);
	        buton.setOnAction(e -> subStage.close());
	        root.getChildren().addAll(conf,buton);
	        subStage.setScene(scene);
	        subStage.show();
	}
	
	
	/**
	 * This function is triggered when user tries to save the changes made. This inturn stores 
	 * the details in database.
	 * @param event
	 * @throws Exception
	 */
	public void savebutton(ActionEvent event) throws Exception{
		
		daocustomerview update = new daocustomerview();
		int res=update.modifyuser(loginController.getUsername(),loginController.getPassword(),txtfield2.getText(), txtfield3.getText(), (Integer.parseInt(txtfield4.getText())), txtfield5.getText(), txtfield6.getText());
	   
		if (res==1){
			
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 300, 200);
		        Label conf = new Label("Customer information modified");
		        conf.setTranslateX(40);
		        conf.setTranslateY(-10);
		        Button buton = new Button("OK");
		        buton.setTranslateX(-50);
		        buton.setTranslateY(50);
		        customermainpage main = new customermainpage();
		        buton.setOnAction(e -> {
		        	main.setgui();
		        subStage.close();
		        });
		        root.getChildren().addAll(conf,buton);
		        subStage.setScene(scene);
		        subStage.show();
		}
	}

	/**
	 * This method is triggered when user tries to move to back window from the current window.
	 *  
	 */
	public void backbutton(ActionEvent event) throws Exception{
		
		customermainpage main = new customermainpage();
		main.setgui();
	}
	
	/**
	 * This method is triggered when user tries to logout of the console.
	 * 
	 * 
	 */
	public void logoutbutton(ActionEvent event) throws Exception{
		Main log = new Main();
		log.start(Main.getPrimarystage());
	}
}
