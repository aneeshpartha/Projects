/**
 * @author Aneesh Partha
 * @since 12/02/2016
 * File adminloginController.java
 * Final Project
 */

package Controller;

//import statements used for the code.
import java.io.IOException;
import java.sql.ResultSet;
import Model.guisetup;
import application.Main;
import dao.daologin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * This class is used for setting up initial login screen for the customer. The login page will 
 * get username and password from the user and validates the user credential.
 * If the user credential is wrong then it will prompt the error.
 * @author Aneesh Partha
 *
 */
public class adminloginController implements guisetup {

	
	@FXML
	 private TextField usernametxt;
	
	public TextField getUsernametxt() {
		return usernametxt;
	}

	public void setUsernametxt(TextField usernametxt) {
		this.usernametxt = usernametxt;
	}

	public PasswordField getPasswordtxt() {
		return passwordtxt;
	}

	public void setPasswordtxt(PasswordField passwordtxt) {
		this.passwordtxt = passwordtxt;
	}

	public Label getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(Label loginstatus) {
		this.loginstatus = loginstatus;
	}

	@FXML
	private PasswordField passwordtxt;
	
	@FXML
	private Label loginstatus;
	
	/**
	 * This method creates GUI for the application. It loads the adminconsole which is used 
	 * as login page. setgui is a function in interface guisetup. Hence we are taking the function.
	 * 
	 */
	public void setgui() {
			
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/adminconsole.fxml"));
		
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
	 * This method is used for getting user name and password and validating it against the 
	 * information stored in database. It sends the details to daologin class through which information
	 * is collected from the database.
	 * @param event this is the event created due to submit  button.
	 * @throws Exception is added in the code.
	 */
	
	public void logincheckadmin(ActionEvent event) throws Exception{
		ResultSet result=null;
		daologin login = new daologin();
		result=login.getResultSetadmin();
		//System.out.println(usernametxt.getText());	
		String type = "admin";
		int i=0;
        while(result.next()){
		     System.out.println(result.getString("username"));
        	if(getUsernametxt().getText().equals(result.getString("username"))&& getPasswordtxt().getText().equals(result.getString("password"))&& type.equals(result.getString("user_type")))
				{
        		        		
        	
			        	adminmainController admincontrol = new adminmainController();
		        		admincontrol.setgui();
		                i=1;
			
		}
        }
		
		 if (i==0){
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 300, 200);
		        Label conf = new Label("Login failed.Possible reasons\n\n1.User credentails is wrong\n2.You are a customer.Navigate to Customer page");
		        Button buton = new Button("OK");
		        buton.setTranslateX(-80);
		        buton.setTranslateY(50);
		        buton.setOnAction(e -> subStage.close());
		        root.getChildren().addAll(conf,buton);
		        subStage.setScene(scene);
		        subStage.show();
		
		
        }	
		
        result.close();         
	}
}
