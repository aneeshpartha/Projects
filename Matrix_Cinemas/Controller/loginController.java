package Controller;

//import statement
import java.sql.ResultSet;
import dao.daologin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * This class is for userlogin. Either customer or admin can be switched to login
 * @author Aneesh Partha
 *
 */
	public class loginController {
		
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

		public Hyperlink getLink() {
			return link;
		}

		public void setLink(Hyperlink link) {
			this.link = link;
		}

		@FXML
		 private TextField usernametxt;
		
		@FXML
		private PasswordField passwordtxt;
		
		@FXML
		private Label loginstatus;
		
		@FXML 
		private Hyperlink link = new Hyperlink();
		private static String username;
		private static String password;
		
		/**
		 * This method is used for checking the login of the customer.once information is entered
		 * the data is sent to the database and information is fetched for validation.
		 * @param event
		 * @throws Exception
		 */
		public void logincheck(ActionEvent event) throws Exception{
			ResultSet result=null;
			daologin login = new daologin();
			result=login.getResultSet();
			String type = "customer";	
			
			int i=0;
			
			while(result.next()){
			    System.out.println(result.getString("user_type"));
            	if(usernametxt.getText().equals(result.getString("username"))&& passwordtxt.getText().equals(result.getString("password"))&& type.equals(result.getString("user_type")))
					{
				//loginstatus.setText("Login successful");
				/**Stage subStage = new Stage();
				subStage.setTitle("Alert");
				  FlowPane root = new FlowPane();
			        root.setAlignment(Pos.CENTER);
			        Scene scene = new Scene(root, 300, 100);
			        Label conf = new Label("Login Sucessful");
			        Button buton = new Button("OK");
			        buton.setTranslateX(-50);
			        buton.setTranslateY(30);
			        buton.setOnAction(e -> {
			        	subStage.close();
			        	datemovieController obj = new datemovieController();
						obj.setgui();
			        });
			        root.getChildren().addAll(conf,buton);
			        subStage.setScene(scene);**/
            		setUsername(usernametxt.getText());
            		setPassword(passwordtxt.getText());
            		customermainpage cust = new customermainpage();
            		cust.setgui();
            		//datemovieController obj = new datemovieController();
					//obj.setgui();
			        i=1;
				//datemovieController obj = new datemovieController();
				//obj.setgui();
				//result.next();
				//subStage.show();
			}
			}	
		if (/**!result.next()&&**/i==0){
			//	loginstatus.setText("Login failed.");
			
				Stage subStage = new Stage();
				subStage.setTitle("Alert");
				  FlowPane root = new FlowPane();
			        root.setAlignment(Pos.CENTER);
			        Scene scene = new Scene(root, 300, 200);
			        Label conf = new Label("Login failed.Possible reasons\n\n1.User credentails is wrong\n2.You are admin.Navigate to admin page");
			        Button buton = new Button("OK");
			        buton.setTranslateX(-80);
			        buton.setTranslateY(50);
			        buton.setOnAction(e -> subStage.close());
			        root.getChildren().addAll(conf,buton);
			        subStage.setScene(scene);
			        subStage.show();
			}
            }	
			
            
		//}
			
		/**
		 * 
		 * This method passes the control to adminloginController once the button is clicked.
		 * 
		 */
		public void admin(ActionEvent event) throws Exception{
			adminloginController admin = new adminloginController();
			admin.setgui();
		}

		public static String getUsername() {
			return username;
		}

		public static void setUsername(String username) {
			loginController.username = username;
		}

		public static String getPassword() {
			return password;
		}

		public static void setPassword(String password) {
			loginController.password = password;
		}
		
		}
		
	


