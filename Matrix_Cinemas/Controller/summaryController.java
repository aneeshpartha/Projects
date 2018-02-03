package Controller;

//import statements
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import Model.guisetup;
import application.Main;
import dao.daoscreenselection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/** 
 * This class is for displaying the summary of selection which was performed.
 * It gives user of the choices which were made.
 * @author Aneesh Partha
 *
 */
public class summaryController implements Initializable,guisetup {
	
	public Label getTxtfld1() {
		return txtfld1;
	}

	public void setTxtfld1(Label txtfld1) {
		this.txtfld1 = txtfld1;
	}

	public Label getTxtfld2() {
		return txtfld2;
	}

	public void setTxtfld2(Label txtfld2) {
		this.txtfld2 = txtfld2;
	}

	public Label getTxtfld3() {
		return txtfld3;
	}

	public void setTxtfld3(Label txtfld3) {
		this.txtfld3 = txtfld3;
	}

	public Label getTxtfld4() {
		return txtfld4;
	}

	public void setTxtfld4(Label txtfld4) {
		this.txtfld4 = txtfld4;
	}

	public Label getTxtfld5() {
		return txtfld5;
	}

	public void setTxtfld5(Label txtfld5) {
		this.txtfld5 = txtfld5;
	}

	public Label getTxtfld6() {
		return txtfld6;
	}

	public void setTxtfld6(Label txtfld6) {
		this.txtfld6 = txtfld6;
	}

	public Label getTxtfld7() {
		return txtfld7;
	}

	public void setTxtfld7(Label txtfld7) {
		this.txtfld7 = txtfld7;
	}

	public Label getTxtfld8() {
		return txtfld8;
	}

	public void setTxtfld8(Label txtfld8) {
		this.txtfld8 = txtfld8;
	}

	@FXML
	private Label txtfld1 = new Label();
	@FXML
	private Label txtfld2 = new Label();
	@FXML
	private Label txtfld3 = new Label();
	@FXML
	private Label txtfld4 = new Label();
	@FXML
	private Label txtfld5 = new Label();
	@FXML
	private Label txtfld6 = new Label();
	@FXML
	private Label txtfld7 = new Label();
	@FXML
	private Label txtfld8 = new Label();
	
	/**
	 * Setting up of GUI
	 */
	public void setgui(){
		//Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/summary.fxml"));
		
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//datemovieController select = new datemovieController();
		//System.out.println(select.comboselect+select.moviefilter+select.datefilter);
		
		ResultSet result;
		daoscreenselection check = new daoscreenselection();
		try {
			result = check.getResultSet(datemovieController.moviefilter,ShowtimeController.moviename,ShowtimeController.showtime);
		
			while(result.next()){
	    	txtfld4.setText(result.getString("Screen_name"));
			}
			result.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtfld1.setText(datemovieController.moviefilter);
		txtfld2.setText(ShowtimeController.moviename);
		txtfld3.setText(datemovieController.datefilter);
		txtfld5.setText(ShowtimeController.showtime);
		String a="";
		for (int i=0;i<ShowtimeController.seatselection.size();i++){
			
			a=a.concat(ShowtimeController.seatselection.get(i));
		}
		txtfld7.setText(a);
		
		String b=Integer.toString(ShowtimeController.seatselection.size());
		txtfld6.setText(b);
		
		String cost = Integer.toString(ShowtimeController.seatselection.size()*10);
		txtfld8.setText(cost);
	}
	
	/**
	 * once the user verifies the information and clicks next the control is passed to next class.
	 */
	public void confirm(ActionEvent event) throws Exception{

		PaymentController summary = new PaymentController();
				summary.setgui();
	}
	
	/**
	 * Method for logout
	 */
	
	public void logoutbutton(ActionEvent event) throws Exception{
		Main log = new Main();
		log.start(Main.getPrimarystage());
	}
}
