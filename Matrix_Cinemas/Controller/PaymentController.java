package Controller;

//import statements
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import Model.guisetup;
import application.Main;
import dao.daocardcheck;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


/**
 * This class is created for payment during the final stage.It gets the card holder details
 * and compares it with the database.
 * @author Aneesh Partha
 *
 */
public class PaymentController implements Initializable,guisetup {

	@FXML
	private Label costlabel = new Label();
	
	@FXML
	private ComboBox<String> cardtype;
	@FXML
	private ComboBox<String> Months;
	@FXML
	private ComboBox<String> years;
	@FXML
	private TextField cardhn = new TextField();
	@FXML
	private TextField cardnumber = new TextField();
	@FXML
	private PasswordField CVV = new PasswordField();
	
	@FXML
	private Button Pay = new Button();
    @FXML 
    private Button Logout = new Button(); 

	
	public Label getCostlabel() {
		return costlabel;
	}

	public void setCostlabel(Label costlabel) {
		this.costlabel = costlabel;
	}

	public ComboBox<String> getCardtype() {
		return cardtype;
	}

	public void setCardtype(ComboBox<String> cardtype) {
		this.cardtype = cardtype;
	}

	public ComboBox<String> getMonths() {
		return Months;
	}

	public void setMonths(ComboBox<String> months) {
		Months = months;
	}

	public ComboBox<String> getYears() {
		return years;
	}

	public void setYears(ComboBox<String> years) {
		this.years = years;
	}

	public TextField getCardhn() {
		return cardhn;
	}

	public void setCardhn(TextField cardhn) {
		this.cardhn = cardhn;
	}

	public TextField getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(TextField cardnumber) {
		this.cardnumber = cardnumber;
	}

	public TextField getCVV() {
		return CVV;
	}

	public void setCVV(PasswordField cVV) {
		CVV = cVV;
	}

	public Button getPay() {
		return Pay;
	}

	public void setPay(Button pay) {
		Pay = pay;
	}

	/**
	 * Setting up GUI
	 */
	
	public void setgui(){
	//	Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/payment.fxml"));
		
		Scene scene = new Scene(root,700,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.getPrimarystage().setScene(scene);
		Main.getPrimarystage().show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<String> values = FXCollections.observableArrayList("Visa","Maestro","Forex");
		ObservableList<String> month = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
		ObservableList<String> year = FXCollections.observableArrayList("2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027");
		cardtype.setItems(values);
		Months.setItems(month);
        years.setItems(year);
        String a= Integer.toString(ShowtimeController.seatselection.size()*10);
        costlabel.setText(a+"$");    	
	}
	
/**
 * Method used for payment.
 * @param event
 * @throws Exception
 */
	public void pay(ActionEvent event) throws Exception{
        Double a,b; 
		ResultSet result;
		daocardcheck check = new daocardcheck();
		try {
				
			if(CVV.getLength()==3 & cardnumber.getLength()==16 & cardtype.getValue()!=null & Months.getValue()!=null & years.getValue()!=null ){
				a = Double.parseDouble(CVV.getText());
				 b= Double.parseDouble(cardnumber.getText());
				
				
				result = check.getResultSet(cardhn.getText(),b,a);
				if(!result.next()){
					
					Stage primaryStage = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource("/View/connectionfailed.fxml"));
					Scene scene = new Scene(root,290,160);
					//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				}
				
				else{
					
					Stage subStage = new Stage();
					subStage.setTitle("Alert");
					  FlowPane root = new FlowPane();
				        root.setAlignment(Pos.CENTER);
				        Scene scene = new Scene(root, 300, 200);
				        Label conf = new Label("Payment sucessful");
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
			}
			else{
			
				Stage subStage = new Stage();
				subStage.setTitle("Alert");
				  FlowPane root = new FlowPane();
			        root.setAlignment(Pos.CENTER);
			        Scene scene = new Scene(root, 400, 100);
			        Label conf = new Label("All field values are not entered or entered wrongly");
			        Button buton = new Button("OK");
			        buton.setTranslateX(-30);
			        buton.setTranslateY(30);
			        buton.setOnAction(e -> subStage.close());
			        root.getChildren().addAll(conf,buton);
			        subStage.setScene(scene);
			        subStage.show();
			}
			 
				
		}catch(NumberFormatException se)	{
			
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 300, 100);
		        Label conf = new Label("Value entered in one or more fields are not valid");
		        Button buton = new Button("OK");
		        buton.setTranslateX(-150);
		        buton.setTranslateY(30);
		        buton.setOnAction(e -> subStage.close());
		        root.getChildren().addAll(conf,buton);
		        subStage.setScene(scene);
		        subStage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

/**
 * The function is triggered whn the user tries to logoff.
 */
	public void logoutbutton(ActionEvent event) throws Exception{
		Main log = new Main();
		log.start(Main.getPrimarystage());
	}
		
}
