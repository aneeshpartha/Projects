/**
 * @author Aneesh Partha
 * @since 12/02/2016
 * File adminmainController.java
 * Final Project
 */

package Controller;

//import statements for the class
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Model.Customers;
import Model.Movie;
import Model.admin;
import Model.guisetup;
import application.Main;
import dao.daoadminadd;
import dao.daocustomeradd;
import dao.daomovieadd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
 * This class gives various options for the admin operations. It sets up GUI and provides various
 * functionalities through this class.It inherits Customers class and implements 
 * Initializable and guisetup interface.
 * @author Aneesh Partha
 *
 */
public class adminmainController extends Customers implements Initializable,guisetup {
	
	
	//Label
	@FXML
	private Label label1 = new Label();
	public Label getLabel1() {
		return label1;
	}

	public void setLabel1(Label label1) {
		this.label1 = label1;
	}

	public Label getLabel2() {
		return label2;
	}

	public void setLabel2(Label label2) {
		this.label2 = label2;
	}

	public Label getLabel3() {
		return label3;
	}

	public void setLabel3(Label label3) {
		this.label3 = label3;
	}

	public Label getLabel4() {
		return label4;
	}

	public void setLabel4(Label label4) {
		this.label4 = label4;
	}

	public Label getLabel5() {
		return label5;
	}

	public void setLabel5(Label label5) {
		this.label5 = label5;
	}

	public Label getLabel6() {
		return label6;
	}

	public void setLabel6(Label label6) {
		this.label6 = label6;
	}

	public Label getLabel7() {
		return label7;
	}

	public void setLabel7(Label label7) {
		this.label7 = label7;
	}

	public Label getLabel8() {
		return label8;
	}

	public void setLabel8(Label label8) {
		this.label8 = label8;
	}

	public TextField getTxtfld1() {
		return txtfld1;
	}

	public void setTxtfld1(TextField txtfld1) {
		this.txtfld1 = txtfld1;
	}

	public TextField getTxtfld2() {
		return txtfld2;
	}

	public void setTxtfld2(TextField txtfld2) {
		this.txtfld2 = txtfld2;
	}

	public TextField getTxtfld3() {
		return txtfld3;
	}

	public void setTxtfld3(TextField txtfld3) {
		this.txtfld3 = txtfld3;
	}

	public TextField getTxtfld4() {
		return txtfld4;
	}

	public void setTxtfld4(TextField txtfld4) {
		this.txtfld4 = txtfld4;
	}

	public TextField getTxtfld5() {
		return txtfld5;
	}

	public void setTxtfld5(TextField txtfld5) {
		this.txtfld5 = txtfld5;
	}

	public TextField getTxtfld6() {
		return txtfld6;
	}

	public void setTxtfld6(TextField txtfld6) {
		this.txtfld6 = txtfld6;
	}

	public TextField getTxtfld7() {
		return txtfld7;
	}

	public void setTxtfld7(TextField txtfld7) {
		this.txtfld7 = txtfld7;
	}

	public PasswordField getTxtfld8() {
		return txtfld8;
	}

	public void setTxtfld8(PasswordField txtfld8) {
		this.txtfld8 = txtfld8;
	}

	@FXML
	private Label label2 = new Label();
	@FXML
	private Label label3 = new Label();
	@FXML
	private Label label4 = new Label();
	@FXML
	private Label label5 = new Label();
	@FXML
	private Label label6 = new Label();
	@FXML
	private Label label7 = new Label();
	@FXML
	private Label label8 = new Label();
	
	//Textfield
	@FXML
	private TextField txtfld1 = new TextField();
	@FXML
	private TextField txtfld2 = new TextField();
	@FXML
	private TextField txtfld3 = new TextField();
	@FXML
	private TextField txtfld4 = new TextField();
	@FXML
	private TextField txtfld5 = new TextField();
	@FXML
	private TextField txtfld6 = new TextField();
	@FXML
	private TextField txtfld7 = new TextField();
	@FXML
	private PasswordField txtfld8 = new PasswordField();
	
	public Button getBookmovie() {
		return bookmovie;
	}

	public void setBookmovie(Button bookmovie) {
		this.bookmovie = bookmovie;
	}

	public Button getNewcust() {
		return newcust;
	}

	public void setNewcust(Button newcust) {
		this.newcust = newcust;
	}

	public Button getNewadmin() {
		return newadmin;
	}

	public void setNewadmin(Button newadmin) {
		this.newadmin = newadmin;
	}

	public Button getAddmovie() {
		return addmovie;
	}

	public void setAddmovie(Button addmovie) {
		this.addmovie = addmovie;
	}

	public Button getModifymovie() {
		return modifymovie;
	}

	public void setModifymovie(Button modifymovie) {
		this.modifymovie = modifymovie;
	}

	

	@FXML
	Button bookmovie = new Button();
	@FXML
	Button newcust = new Button();
	@FXML
	Button newadmin = new Button();
	@FXML
	Button addmovie = new Button();
	@FXML
	Button modifymovie = new Button();
	@FXML
	Button add1 = new Button();
	


	public Button getAdd1() {
		return add1;
	}

	public void setAdd1(Button add1) {
		this.add1 = add1;
	}

	public Button getAdd2() {
		return add2;
	}

	public void setAdd2(Button add2) {
		this.add2 = add2;
	}

	@FXML
	Button add2 = new Button();
	
	@FXML
	Button add3 = new Button();
		
	public Button getAdd3() {
		return add3;
	}

	public void setAdd3(Button add3) {
		this.add3 = add3;
	}
	
	public Button getCustomerbb() {
		return customerbb;
	}

	public void setCustomerbb(Button customerbb) {
		this.customerbb = customerbb;
	}

	public Button getAdminbb() {
		return adminbb;
	}

	public void setAdminbb(Button adminbb) {
		this.adminbb = adminbb;
	}

	public Button getMoviebb() {
		return moviebb;
	}

	public void setMoviebb(Button moviebb) {
		this.moviebb = moviebb;
	}

	@FXML
	private Button customerbb = new Button();
	@FXML
	private Button adminbb = new Button();
	@FXML
	private Button moviebb = new Button();
    @FXML
	private Button logout = new Button();
	
	public Button getLogout() {
		return logout;
	}

	public void setLogout(Button logout) {
		this.logout = logout;
	}

	
	/**
	 * This Method is used for setting up GUI.It loads adminselect.fxml file through which GUI 
	 * set up is taken care.
	 */
	public void setgui(){
		    
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/adminselect.fxml"));
		
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
	 * This method is part of Initializable interface.It is mandatory to implement this method.
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		getLabel1().setVisible(false);
		getLabel2().setVisible(false);
		getLabel3().setVisible(false);
		getLabel4().setVisible(false);
		getLabel5().setVisible(false);
		getLabel6().setVisible(false);
		getLabel7().setVisible(false);
		getLabel8().setVisible(false);
		
		getTxtfld1().setVisible(false);
		getTxtfld2().setVisible(false);
		getTxtfld3().setVisible(false);
		getTxtfld4().setVisible(false);
		getTxtfld5().setVisible(false);
		getTxtfld6().setVisible(false);
		getTxtfld7().setVisible(false);
		getTxtfld8().setVisible(false);
		getAdd1().setVisible(false);
		getAdd2().setVisible(false);
		getAdd3().setVisible(false);
		getCustomerbb().setVisible(false);
		getAdminbb().setVisible(false);
		getMoviebb().setVisible(false);
	}
	
	/**
	 * This method tells what action the button bookmovie should do.
	 * @param event is the event generated by the button
	 * @throws Exception is used for exception handling
	 */
	public void bookmovie(ActionEvent event) throws Exception{
				
		datemovieController obj = new datemovieController();
		obj.setgui();
		
		}

	/**
	 * This method and the below method tells the action which must be taken once the button is clicked. This method
	 * is used for adding customer.
	 * @param event is the event generated
	 * @throws Exception is for  capturing the errors.
	 */
	public void addcustomer(ActionEvent event) throws Exception{
		
		getBookmovie().setVisible(false);
		getNewcust().setVisible(false);
		getNewadmin().setVisible(false);
		getAddmovie().setVisible(false);
		getModifymovie().setVisible(false);
		
		
		getLabel1().setVisible(true);
		getLabel2().setVisible(true);
		getLabel3().setVisible(true);
		getLabel4().setVisible(true);
		getLabel5().setVisible(true);
		getLabel6().setVisible(true);
		getLabel7().setVisible(true);
		getLabel8().setVisible(true);
		
		getTxtfld1().setVisible(true);
		getTxtfld2().setVisible(true);
		getTxtfld3().setVisible(true);
		getTxtfld4().setVisible(true);
		getTxtfld5().setVisible(true);
		getTxtfld6().setVisible(true);
		getTxtfld7().setVisible(true);
		getTxtfld8().setVisible(true);
		getAdd1().setVisible(true);
		getCustomerbb().setVisible(true);
	
		getLabel1().setText("Customer id");
		getLabel2().setText("First name");
		getLabel3().setText("Last name");
		getLabel4().setText("Customer Number");
		getLabel5().setText("Customer Email");
		getLabel6().setText("Customer address");
		getLabel7().setText("User name");
		getLabel8().setText("Password");
		
		}

	/**
	 * This method and below method are used for creating a new customer.
	 * @param event is the event generated
	 * @throws Exception throws the exception.
	 */
	
	public void addcustomerbutton(ActionEvent event) throws Exception{
	
	
		int a = Integer.parseInt(getTxtfld1().getText());
		getCustomer().setCust_id(a);
		getCustomer().setCust_fname(getTxtfld2().getText());
		getCustomer().setCust_lname(getTxtfld3().getText());
		int b=Integer.parseInt(getTxtfld4().getText());
		getCustomer().setCust_phno(b);
		getCustomer().setCust_email(getTxtfld5().getText());
		getCustomer().setCust_address(getTxtfld6().getText());
		
		daocustomeradd cust = new daocustomeradd();
		int res=cust.inserts(getTxtfld7().getText(),getTxtfld8().getText());
		
		if(res!=0){
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 300, 200);
		        Label conf = new Label("Customer added");
		        conf.setTranslateX(40);
		        conf.setTranslateY(-10);
		        Button buton = new Button("OK");
		        buton.setTranslateX(-50);
		        buton.setTranslateY(50);
		        buton.setOnAction(e -> subStage.close());
		        root.getChildren().addAll(conf,buton);
		        subStage.setScene(scene);
		        subStage.show();
		
		getBookmovie().setVisible(true);
		getNewcust().setVisible(true);
		getNewadmin().setVisible(true);
		getAddmovie().setVisible(true);
		getModifymovie().setVisible(true);
		
		
		
		getLabel1().setVisible(false);
		getLabel2().setVisible(false);
		getLabel3().setVisible(false);
		getLabel4().setVisible(false);
		getLabel5().setVisible(false);
		getLabel6().setVisible(false);
		getLabel7().setVisible(false);
		getLabel8().setVisible(false);
		
		getTxtfld1().setVisible(false);
		getTxtfld2().setVisible(false);
		getTxtfld3().setVisible(false);
		getTxtfld4().setVisible(false);
		getTxtfld5().setVisible(false);
		getTxtfld6().setVisible(false);
		getTxtfld7().setVisible(false);
		getTxtfld8().setVisible(false);
		getAdd1().setVisible(false);
		
		
		getTxtfld1().clear();
		getTxtfld2().clear();
		getTxtfld3().clear();
		getTxtfld4().clear();
		getTxtfld5().clear();
		getTxtfld6().clear();
		getTxtfld7().clear();
		getTxtfld8().clear();
		}
		else{
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 300, 200);
		        Label conf = new Label("Customer not added. Please check all the entered values");
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
	}
	
	/**
	 * This method and the below method are used for adding a new admin.These methods 
	 * are triggered based on the action event.when button is clicked the application triggers.
	 * @param event
	 * @throws Exception
	 */
	public void addadmin(ActionEvent event) throws Exception{
		
		getBookmovie().setVisible(false);
		getNewcust().setVisible(false);
		getNewadmin().setVisible(false);
		getAddmovie().setVisible(false);
		getModifymovie().setVisible(false);
		
		
		getLabel8().setVisible(true);
		getLabel2().setVisible(true);
		getLabel3().setVisible(true);
		getLabel4().setVisible(true);
		getLabel5().setVisible(true);
		getLabel6().setVisible(true);
		getLabel7().setVisible(true);
		
		
		getTxtfld2().setVisible(true);
		getTxtfld3().setVisible(true);
		getTxtfld4().setVisible(true);
		getTxtfld5().setVisible(true);
		getTxtfld6().setVisible(true);
		getTxtfld7().setVisible(true);
		getTxtfld8().setVisible(true);
		getAdd2().setVisible(true);
		getAdminbb().setVisible(true);
	
		getLabel2().setText("Admin id");
		getLabel3().setText("Admin Name");
		getLabel4().setText("Admin Email");
		getLabel5().setText("Admin Number");
		getLabel6().setText("Admin address");
		getLabel7().setText("User name");
		getLabel8().setText("Password");
		
		}
	
	
	public void addadminbutton(ActionEvent event) throws Exception{
		
		admin adm = new admin();
		int a = Integer.parseInt(getTxtfld2().getText());
		adm.setAdmin_id(a);
		adm.setAdmin_name(getTxtfld3().getText());
		adm.setAdmin_email(getTxtfld4().getText());
		int b=Integer.parseInt(getTxtfld5().getText());
		adm.setAdmin_number(b);
		adm.setAdmin_address(getTxtfld6().getText());
		
		daoadminadd admina = new daoadminadd();
		int res=admina.inserts(adm, getTxtfld7().getText(), getTxtfld8().getText());
		
		if(res!=0){
		
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 300, 200);
		        Label conf = new Label("Admin added");
		        conf.setTranslateX(40);
		        conf.setTranslateY(-10);
		        Button buton = new Button("OK");
		        buton.setTranslateX(-50);
		        buton.setTranslateY(50);
		        buton.setOnAction(e -> subStage.close());
		        root.getChildren().addAll(conf,buton);
		        subStage.setScene(scene);
		        subStage.show();
		
		getBookmovie().setVisible(true);
		getNewcust().setVisible(true);
		getNewadmin().setVisible(true);
		getAddmovie().setVisible(true);
		getModifymovie().setVisible(true);
		
		
		
		getLabel1().setVisible(false);
		getLabel2().setVisible(false);
		getLabel3().setVisible(false);
		getLabel4().setVisible(false);
		getLabel5().setVisible(false);
		getLabel6().setVisible(false);
		getLabel7().setVisible(false);
		getLabel8().setVisible(false);
		
		getTxtfld1().setVisible(false);
		getTxtfld2().setVisible(false);
		getTxtfld3().setVisible(false);
		getTxtfld4().setVisible(false);
		getTxtfld5().setVisible(false);
		getTxtfld6().setVisible(false);
		getTxtfld7().setVisible(false);
		getTxtfld8().setVisible(false);
		getAdd2().setVisible(false);
		getAdd3().setVisible(false);
		
		
		getTxtfld1().clear();
		getTxtfld2().clear();
		getTxtfld3().clear();
		getTxtfld4().clear();
		getTxtfld5().clear();
		getTxtfld6().clear();
		getTxtfld7().clear();
		getTxtfld8().clear();
		}
		else{
			
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 400, 200);
		        Label conf = new Label("Admin not added. Please check all the entered values");
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
	}
	
	/**
	 * This method and below method are used for creating a new movie.
	 * @param event is the event generated
	 * @throws Exception throws exception
	 */
	
	public void addmovie(ActionEvent event) throws Exception{
		
		getBookmovie().setVisible(false);
		getNewcust().setVisible(false);
		getNewadmin().setVisible(false);
		getAddmovie().setVisible(false);
		getModifymovie().setVisible(false);
		
		
		getLabel1().setVisible(true);
		getLabel2().setVisible(true);
		getLabel3().setVisible(true);
		getLabel4().setVisible(true);
		getMoviebb().setVisible(true);	
		
		getTxtfld1().setVisible(true);
		getTxtfld2().setVisible(true);
		getTxtfld3().setVisible(true);
		getTxtfld4().setVisible(true);
		getAdd3().setVisible(true);
		
		getLabel1().setText("Movie id");
		getLabel2().setText("Movie name");
		getLabel3().setText("Movie Image");
		getLabel4().setText("Movie Description");
	
		
		
		}
	
	
	public void addmoviebutton(ActionEvent event) throws Exception{
		
		Movie mov = new Movie();
		int a = Integer.parseInt(getTxtfld1().getText());
		mov.setMovie_id(a);
		mov.setMovie_name(getTxtfld2().getText());
		mov.setMovie_pic(getTxtfld3().getText());
		mov.setMovie_desc(getTxtfld4().getText());
		
		
		if(getTxtfld3().getText().isEmpty() || getTxtfld1().getText().isEmpty() || getTxtfld2().getText().isEmpty() ){
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 300, 200);
		        Label conf = new Label("Values are not entered. Please add value");
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
		else{	
		daomovieadd mvadd = new daomovieadd();
		int res=mvadd.inserts(mov);
		
		if(res!=0){
		
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 300, 200);
		        Label conf = new Label("Movie added");
		        conf.setTranslateX(40);
		        conf.setTranslateY(-10);
		        Button buton = new Button("OK");
		        buton.setTranslateX(-50);
		        buton.setTranslateY(50);
		        buton.setOnAction(e -> subStage.close());
		        root.getChildren().addAll(conf,buton);
		        subStage.setScene(scene);
		        subStage.show();
		
		getBookmovie().setVisible(true);
		getNewcust().setVisible(true);
		getNewadmin().setVisible(true);
		getAddmovie().setVisible(true);
		getModifymovie().setVisible(true);
		
		
		
		getLabel1().setVisible(false);
		getLabel2().setVisible(false);
		getLabel3().setVisible(false);
		getLabel4().setVisible(false);
		getLabel5().setVisible(false);
		getLabel6().setVisible(false);
		getLabel7().setVisible(false);
		getLabel8().setVisible(false);
		
		getTxtfld1().setVisible(false);
		getTxtfld2().setVisible(false);
		getTxtfld3().setVisible(false);
		getTxtfld4().setVisible(false);
		getTxtfld5().setVisible(false);
		getTxtfld6().setVisible(false);
		getTxtfld7().setVisible(false);
		getTxtfld8().setVisible(false);
		getAdd2().setVisible(false);
		getAdd3().setVisible(false);
		
		getTxtfld1().clear();
		getTxtfld2().clear();
		getTxtfld3().clear();
		getTxtfld4().clear();
		getTxtfld5().clear();
		getTxtfld6().clear();
		getTxtfld7().clear();
		getTxtfld8().clear();
		}
		else 
		{
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			  FlowPane root = new FlowPane();
		        root.setAlignment(Pos.CENTER);
		        Scene scene = new Scene(root, 400, 200);
		        Label conf = new Label("Movie not added. Please check all the entered values");
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
	}

	}
	
	/**
	 * This method is for navigating to previous window from the current admin window.
	 * @param event is the event generated.
	 * @throws Exception is the exception handling
	 */
	
	public void adminback(ActionEvent event) throws Exception{
	
		
		getBookmovie().setVisible(true);
		getNewcust().setVisible(true);
		getNewadmin().setVisible(true);
		getAddmovie().setVisible(true);
		getModifymovie().setVisible(true);
		
		
		
		getLabel1().setVisible(false);
		getLabel2().setVisible(false);
		getLabel3().setVisible(false);
		getLabel4().setVisible(false);
		getLabel5().setVisible(false);
		getLabel6().setVisible(false);
		getLabel7().setVisible(false);
		getLabel8().setVisible(false);
		
		getTxtfld1().setVisible(false);
		getTxtfld2().setVisible(false);
		getTxtfld3().setVisible(false);
		getTxtfld4().setVisible(false);
		getTxtfld5().setVisible(false);
		getTxtfld6().setVisible(false);
		getTxtfld7().setVisible(false);
		getTxtfld8().setVisible(false);
		getAdd2().setVisible(false);
		getAdd3().setVisible(false);
		getAdminbb().setVisible(false);
		
		getTxtfld1().clear();
		getTxtfld2().clear();
		getTxtfld3().clear();
		getTxtfld4().clear();
		getTxtfld5().clear();
		getTxtfld6().clear();
		getTxtfld7().clear();
		getTxtfld8().clear();
	
	}
	
	/**
	 * This Method is used for navigating to previous window from customer view window
	 * @param event is the event handled
	 * @throws Exception is used for error generation.
	 */
	
	public void customerback(ActionEvent event) throws Exception{
	
		getBookmovie().setVisible(true);
		getNewcust().setVisible(true);
		getNewadmin().setVisible(true);
		getAddmovie().setVisible(true);
		getModifymovie().setVisible(true);
		
		
		
		getLabel1().setVisible(false);
		getLabel2().setVisible(false);
		getLabel3().setVisible(false);
		getLabel4().setVisible(false);
		getLabel5().setVisible(false);
		getLabel6().setVisible(false);
		getLabel7().setVisible(false);
		getLabel8().setVisible(false);
		
		getTxtfld1().setVisible(false);
		getTxtfld2().setVisible(false);
		getTxtfld3().setVisible(false);
		getTxtfld4().setVisible(false);
		getTxtfld5().setVisible(false);
		getTxtfld6().setVisible(false);
		getTxtfld7().setVisible(false);
		getTxtfld8().setVisible(false);
		getAdd1().setVisible(false);
		getCustomerbb().setVisible(false);
		
		getTxtfld1().clear();
		getTxtfld2().clear();
		getTxtfld3().clear();
		getTxtfld4().clear();
		getTxtfld5().clear();
		getTxtfld6().clear();
		getTxtfld7().clear();
		getTxtfld8().clear();
	}

	/**
	 * This method is used for navigating to previous window from current movie window.
	 * @param event
	 * @throws Exception
	 */
	public void movieback(ActionEvent event) throws Exception{
		
		getBookmovie().setVisible(true);
		getNewcust().setVisible(true);
		getNewadmin().setVisible(true);
		getAddmovie().setVisible(true);
		getModifymovie().setVisible(true);
		
		
		
		getLabel1().setVisible(false);
		getLabel2().setVisible(false);
		getLabel3().setVisible(false);
		getLabel4().setVisible(false);
		getLabel5().setVisible(false);
		getLabel6().setVisible(false);
		getLabel7().setVisible(false);
		getLabel8().setVisible(false);
		
		getTxtfld1().setVisible(false);
		getTxtfld2().setVisible(false);
		getTxtfld3().setVisible(false);
		getTxtfld4().setVisible(false);
		getTxtfld5().setVisible(false);
		getTxtfld6().setVisible(false);
		getTxtfld7().setVisible(false);
		getTxtfld8().setVisible(false);
		getAdd2().setVisible(false);
		getAdd3().setVisible(false);
		getMoviebb().setVisible(false);
		
		getTxtfld1().clear();
		getTxtfld2().clear();
		getTxtfld3().clear();
		getTxtfld4().clear();
		getTxtfld5().clear();
		getTxtfld6().clear();
		getTxtfld7().clear();
		getTxtfld8().clear();

	}
	
	
	/**
	 * This method is for  logging out from the screen.
	 * @param event is the event generated as part of clicking
	 * @throws Exception is the exception thrown
	 */
	
	public void loggingout(ActionEvent event) throws Exception{
		
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
	        buton.setOnAction(e -> {
	        call.start(subStage);
	        
	        });
	        root.getChildren().addAll(conf,buton);
	        subStage.setScene(scene);
	        subStage.show();
		
	}
	
	/**
	 * When admin tries to modify the movie then it movies to a new window.
	 * @param event
	 * @throws Exception
	 */
	
	public void modifymovie(ActionEvent event) throws Exception{
		modifymovieController  movie = new modifymovieController();
		movie.setgui();
		
		
	}
	

	}
	
			
			

