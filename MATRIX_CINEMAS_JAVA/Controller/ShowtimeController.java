package Controller;

//import statements
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import Model.guisetup;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * This class allows user to select the seats required for the movie. When the seat is selected the 
 * seat gets disabled and a summary of seat selected is displayed.
 * @author Aneesh Partha
 *
 */
public class ShowtimeController implements Initializable,guisetup{
    
	//screen1
	@FXML
	private ImageView imageview = new ImageView();
	static String imgassign;
	static String moviename;
	@FXML
	private Button b1 = new Button();
	@FXML
	private Button b2 = new Button();
	@FXML
	private Button b3 = new Button();
	static String showtime;

	//screen2
	
	@FXML
	private Label seat = new Label();
	@FXML
	private Label labela= new Label();
	@FXML
	private Label labelb= new Label();
	@FXML
	private Label labelc= new Label();
	@FXML
	private Label labeld= new Label();
	
	@FXML
	private Button a1 = new Button();
	@FXML
	private Button a2 = new Button();
	@FXML
	private Button a3 = new Button();
	@FXML
	private Button c1 = new Button();
	@FXML
	private Button b11 = new Button();
	@FXML
	private Button b22 = new Button();
	@FXML
	private Button b33 = new Button();
	@FXML
	private Button c2 = new Button();
	@FXML
	private Button c3 = new Button();
	@FXML
	private Button d1 = new Button();
	@FXML
	private	Button d2 = new Button();
	@FXML
	private Button d3 = new Button();
	@FXML
	private Button confirmbutton = new Button();
	
	@FXML
	private TextField maintxtfld = new TextField();
	@FXML
	private TextField txtflds = new TextField();
	@FXML
	private TextField txtfldc = new TextField();
	@FXML
	private TextField txtfldr = new TextField();
	@FXML
	private TextField txtflde1 = new TextField();
	@FXML
	private TextField txtflde2 = new TextField();
	@FXML
	private TextField txtfldn = new TextField();
	@FXML
	private Label seatsum = new Label();
	@FXML
	private Label aile1 = new Label();
	@FXML
	private Label aile2 = new Label();
	
	public ImageView getImageview() {
		return imageview;
	}

	public void setImageview(ImageView imageview) {
		this.imageview = imageview;
	}

	public Button getB1() {
		return b1;
	}

	public void setB1(Button b1) {
		this.b1 = b1;
	}

	public Button getB2() {
		return b2;
	}

	public void setB2(Button b2) {
		this.b2 = b2;
	}

	public Button getB3() {
		return b3;
	}

	public void setB3(Button b3) {
		this.b3 = b3;
	}

	public Label getSeat() {
		return seat;
	}

	public void setSeat(Label seat) {
		this.seat = seat;
	}

	public Label getLabela() {
		return labela;
	}

	public void setLabela(Label labela) {
		this.labela = labela;
	}

	public Label getLabelb() {
		return labelb;
	}

	public void setLabelb(Label labelb) {
		this.labelb = labelb;
	}

	public Label getLabelc() {
		return labelc;
	}

	public void setLabelc(Label labelc) {
		this.labelc = labelc;
	}

	public Label getLabeld() {
		return labeld;
	}

	public void setLabeld(Label labeld) {
		this.labeld = labeld;
	}

	public Button getA1() {
		return a1;
	}

	public void setA1(Button a1) {
		this.a1 = a1;
	}

	public Button getA2() {
		return a2;
	}

	public void setA2(Button a2) {
		this.a2 = a2;
	}

	public Button getA3() {
		return a3;
	}

	public void setA3(Button a3) {
		this.a3 = a3;
	}

	public Button getC1() {
		return c1;
	}

	public void setC1(Button c1) {
		this.c1 = c1;
	}

	public Button getB11() {
		return b11;
	}

	public void setB11(Button b11) {
		this.b11 = b11;
	}

	public Button getB22() {
		return b22;
	}

	public void setB22(Button b22) {
		this.b22 = b22;
	}

	public Button getB33() {
		return b33;
	}

	public void setB33(Button b33) {
		this.b33 = b33;
	}

	public Button getC2() {
		return c2;
	}

	public void setC2(Button c2) {
		this.c2 = c2;
	}

	public Button getC3() {
		return c3;
	}

	public void setC3(Button c3) {
		this.c3 = c3;
	}

	public Button getD1() {
		return d1;
	}

	public void setD1(Button d1) {
		this.d1 = d1;
	}

	public Button getD2() {
		return d2;
	}

	public void setD2(Button d2) {
		this.d2 = d2;
	}

	public Button getD3() {
		return d3;
	}

	public void setD3(Button d3) {
		this.d3 = d3;
	}

	public Button getConfirmbutton() {
		return confirmbutton;
	}

	public void setConfirmbutton(Button confirmbutton) {
		this.confirmbutton = confirmbutton;
	}

	public TextField getMaintxtfld() {
		return maintxtfld;
	}

	public void setMaintxtfld(TextField maintxtfld) {
		this.maintxtfld = maintxtfld;
	}

	public TextField getTxtflds() {
		return txtflds;
	}

	public void setTxtflds(TextField txtflds) {
		this.txtflds = txtflds;
	}

	public TextField getTxtfldc() {
		return txtfldc;
	}

	public void setTxtfldc(TextField txtfldc) {
		this.txtfldc = txtfldc;
	}

	public TextField getTxtfldr() {
		return txtfldr;
	}

	public void setTxtfldr(TextField txtfldr) {
		this.txtfldr = txtfldr;
	}

	public TextField getTxtflde1() {
		return txtflde1;
	}

	public void setTxtflde1(TextField txtflde1) {
		this.txtflde1 = txtflde1;
	}

	public TextField getTxtflde2() {
		return txtflde2;
	}

	public void setTxtflde2(TextField txtflde2) {
		this.txtflde2 = txtflde2;
	}

	public TextField getTxtfldn() {
		return txtfldn;
	}

	public void setTxtfldn(TextField txtfldn) {
		this.txtfldn = txtfldn;
	}

	public Label getSeatsum() {
		return seatsum;
	}

	public void setSeatsum(Label seatsum) {
		this.seatsum = seatsum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

    @FXML
    private Button back1 = new Button();
    @FXML
    private Button back2 = new Button();
	
	static List<String> seatselection = new ArrayList<String>();
	
	int count=0;
	public ShowtimeController(){
		
		
	}
	
	ShowtimeController(String img,String movienme){
		imgassign = img;
		moviename = movienme;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//Screen 1
		b1.setOpacity(1);
		b2.setOpacity(1);
		b3.setOpacity(1);
	//	b4.setOpacity(0);
		Image img = new Image(imgassign);
		imageview.setImage(img);
		
		
		//Screen2
		seat.setVisible(false);
		labela.setVisible(false);
		labelb.setVisible(false);
		labelc.setVisible(false);
		labeld.setVisible(false);
		a1.setVisible(false);
		a2.setVisible(false);
		a3.setVisible(false);
		b11.setVisible(false);
		b22.setVisible(false);
		b33.setVisible(false);
		c1.setVisible(false);
		c2.setVisible(false);
		c3.setVisible(false);
		d1.setVisible(false);
		d2.setVisible(false);
		d3.setVisible(false);
		maintxtfld.setVisible(false);
		txtflds.setVisible(false);
		txtfldc.setVisible(false);
		txtfldr.setVisible(false);
		txtflde1.setVisible(false);
		txtflde2.setVisible(false);
		txtfldn.setVisible(false);
		confirmbutton.setVisible(false);
		aile1.setVisible(false);
		aile2.setVisible(false);
		back2.setVisible(false);
	}


	/**
	 * Method for setting up GUI
	 */
	public void setgui(){
        
		//imgassign = img;
		System.out.println("hi");
		//System.out.println(res.get(0));
		//System.out.println(imgassign.impl_getUrl());
		//moviename =movienme;
		//Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/showtime.fxml"));
		
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
	 * Switching between shows. button 1 represents one show and other button represents other show
	 * 
	 */
@FXML	
public void button1(ActionEvent event) throws Exception{
	
	//screen 1
	ShowtimeController.showtime=b1.getText();
	System.out.println(ShowtimeController.showtime);
	b1.setOpacity(0);
	b2.setOpacity(0);
	b3.setOpacity(0);
	//b4.setVisible(false);
    imageview.setVisible(false);
    back1.setVisible(false);
    back2.setVisible(true);
    //screen2
    
    seat.setVisible(true);
	labela.setVisible(true);
	labelb.setVisible(true);
	labelc.setVisible(true);
	labeld.setVisible(true);
	a1.setVisible(true);
	a2.setVisible(true);
	a3.setVisible(true);
	b11.setVisible(true);
	b22.setVisible(true);
	b33.setVisible(true);
	c1.setVisible(true);
	c2.setVisible(true);
	c3.setVisible(true);
	d1.setVisible(true);
	d2.setVisible(true);
	d3.setVisible(true);
	maintxtfld.setVisible(true);
	txtflds.setVisible(true);
	txtfldc.setVisible(true);
	txtfldr.setVisible(true);
	txtflde1.setVisible(true);
	txtflde2.setVisible(true);
	txtfldn.setVisible(true);
	confirmbutton.setVisible(true);
	aile1.setVisible(true);
	aile2.setVisible(true);
	}

/**
 * Represents second show
 */
@FXML
public void button2(ActionEvent event) throws Exception{
	//screen 1
	ShowtimeController.showtime=b2.getText();
	System.out.println(ShowtimeController.showtime);
		b1.setOpacity(0);
		b2.setOpacity(0);
		b3.setOpacity(0);
		//b4.setVisible(false);
	    imageview.setVisible(false);
	    
	    //screen2
	    
	    seat.setVisible(true);
		labela.setVisible(true);
		labelb.setVisible(true);
		labelc.setVisible(true);
		labeld.setVisible(true);
		a1.setVisible(true);
		a2.setVisible(true);
		a3.setVisible(true);
		b11.setVisible(true);
		b22.setVisible(true);
		b33.setVisible(true);
		c1.setVisible(true);
		c2.setVisible(true);
		c3.setVisible(true);
		d1.setVisible(true);
		d2.setVisible(true);
		d3.setVisible(true);
		maintxtfld.setVisible(true);
		txtflds.setVisible(true);
		txtfldc.setVisible(true);
		txtfldr.setVisible(true);
		txtflde1.setVisible(true);
		txtflde2.setVisible(true);
		txtfldn.setVisible(true);
		confirmbutton.setVisible(true);
		  back1.setVisible(false);
		    back2.setVisible(true);

}


/**
 * Represents third show
 */
@FXML
public void button3(ActionEvent event) throws Exception{
	//screen 1
	ShowtimeController.showtime=b3.getText();
	System.out.println(ShowtimeController.showtime);
		b1.setOpacity(0);
		b2.setOpacity(0);
		b3.setOpacity(0);
	//	b4.setVisible(false);
	    imageview.setVisible(false);
	    
	    //screen2
	    
	    seat.setVisible(true);
		labela.setVisible(true);
		labelb.setVisible(true);
		labelc.setVisible(true);
		labeld.setVisible(true);
		a1.setVisible(true);
		a2.setVisible(true);
		a3.setVisible(true);
		b11.setVisible(true);
		b22.setVisible(true);
		b33.setVisible(true);
		c1.setVisible(true);
		c2.setVisible(true);
		c3.setVisible(true);
		d1.setVisible(true);
		d2.setVisible(true);
		d3.setVisible(true);
		maintxtfld.setVisible(true);
		txtflds.setVisible(true);
		txtfldc.setVisible(true);
		txtfldr.setVisible(true);
		txtflde1.setVisible(true);
		txtflde2.setVisible(true);
		txtfldn.setVisible(true);
		confirmbutton.setVisible(true);
		  back1.setVisible(false);
		    back2.setVisible(true);
}

/**
 *The below method represent Seat selection
 */
public void buttona1(ActionEvent event) throws Exception{
	
a1.setDisable(true);

ShowtimeController.seatselection.add(a1.getText());
seatsum.setText("Your selected seat is :"+ a1.getText());
count+=1;					
}

/**
 * Next seat selection
 */
public void buttona2(ActionEvent event) throws Exception{
	
	a2.setDisable(true);

	ShowtimeController.seatselection.add(a2.getText());
	seatsum.setText("Your selected seat is :"+ a2.getText());
	count+=1;					
}

public void buttona3(ActionEvent event) throws Exception{

	a3.setDisable(true);

	ShowtimeController.seatselection.add(a3.getText());
	seatsum.setText("Your selected seat is :"+ a3.getText());
	count+=1;		
}

public void buttonb11(ActionEvent event) throws Exception{
	b11.setDisable(true);

	ShowtimeController.seatselection.add(b11.getText());
	seatsum.setText("Your selected seat is :"+ b11.getText());
	count+=1;	
}

public void buttonb22(ActionEvent event) throws Exception{
	b22.setDisable(true);

	ShowtimeController.seatselection.add(b22.getText());
	seatsum.setText("Your selected seat is :"+ b22.getText());
	count+=1;	
					
}

public void buttonb33(ActionEvent event) throws Exception{
	
	b33.setDisable(true);

	ShowtimeController.seatselection.add(b33.getText());
	seatsum.setText("Your selected seat is :"+ b33.getText());
	count+=1;	
}

public void buttonc1(ActionEvent event) throws Exception{
	
	c1.setDisable(true);

	ShowtimeController.seatselection.add(c1.getText());
	seatsum.setText("Your selected seat is :"+ c1.getText());
	count+=1;	
}

public void buttonc2(ActionEvent event) throws Exception{
	
	c2.setDisable(true);

	ShowtimeController.seatselection.add(c2.getText());
	seatsum.setText("Your selected seat is :"+ c2.getText());
	count+=1;	
}

public void buttonc3(ActionEvent event) throws Exception{
	
	c3.setDisable(true);

	ShowtimeController.seatselection.add(c3.getText());
	seatsum.setText("Your selected seat is :"+ c3.getText());
	count+=1;	
}

public void buttond1(ActionEvent event) throws Exception{
	d1.setDisable(true);

	ShowtimeController.seatselection.add(d1.getText());
	seatsum.setText("Your selected seat is :"+ d1.getText());
	count+=1;	
}

public void buttond2(ActionEvent event) throws Exception{
	
	d2.setDisable(true);

	ShowtimeController.seatselection.add(d2.getText());
	seatsum.setText("Your selected seat is :"+ d2.getText());
	count+=1;	
}

public void buttond3(ActionEvent event) throws Exception{
	
	d3.setDisable(true);

	ShowtimeController.seatselection.add(d3.getText());
	seatsum.setText("Your selected seat is :"+ d3.getText());
	count+=1;	
}

public void confirm(ActionEvent event) throws Exception{

	summaryController summary = new summaryController();
			summary.setgui();
}

public void backbutton1(ActionEvent event) throws Exception{
	mainpageController main = new mainpageController();
	main.setgui();
}

public void backbutton2(ActionEvent event) throws Exception{
	setgui();
}

public void logoutbutton(ActionEvent event) throws Exception{
	Main log = new Main();
	log.start(Main.getPrimarystage());
}

}

