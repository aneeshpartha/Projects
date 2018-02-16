package Controller;

//import statements
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import Model.guisetup;
import application.Main;
import dao.daomoviefilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class performs the operations of displaying the movie to the user. From the GUI user can 
 * select movies which is available . Once the user selects the movie he will be directed for getting 
 * the show time
 * @author Aneesh Partha
 *
 */
public class mainpageController implements Initializable,guisetup{
	
	ResultSet result;
	//private List<String> selectlist = new ArrayList<String>();
	private List<String> res = new ArrayList<String>();
	private List<String> name = new ArrayList<String>();

	
	mainpageController(String comboselect,String moviefilter,String datefilter){
		
		mainpageController.comboselectnew = comboselect;
		mainpageController.moviefilternew = moviefilter;
		mainpageController.datefilternew = datefilter;
		
	}
	public mainpageController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private ImageView Imagev1 = new ImageView();
	@FXML
	private ImageView Imagev2 = new ImageView();
	@FXML
	private ImageView Imagev3 = new ImageView();
	@FXML
	private ImageView Imagev4 = new ImageView();
	
	@FXML
	private Button b1 = new Button();
	@FXML
	private Button b2 = new Button();
	@FXML
	private Button b3 = new Button();
	@FXML
	private Button b4 = new Button();
	@FXML
	private Button b5 = new Button();
	
	private Image image1,image2,image3,image4;
	
	@FXML
	private Label label = new Label();
	
	
	
	public List<String> getRes() {
		return res;
	}
	public void setRes(List<String> res) {
		this.res = res;
	}
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
	public ImageView getImagev1() {
		return Imagev1;
	}
	public void setImagev1(ImageView imagev1) {
		Imagev1 = imagev1;
	}
	public ImageView getImagev2() {
		return Imagev2;
	}
	public void setImagev2(ImageView imagev2) {
		Imagev2 = imagev2;
	}
	public ImageView getImagev3() {
		return Imagev3;
	}
	public void setImagev3(ImageView imagev3) {
		Imagev3 = imagev3;
	}
	public ImageView getImagev4() {
		return Imagev4;
	}
	public void setImagev4(ImageView imagev4) {
		Imagev4 = imagev4;
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
	public Button getB4() {
		return b4;
	}
	public void setB4(Button b4) {
		this.b4 = b4;
	}
	public Button getB5() {
		return b5;
	}
	public void setB5(Button b5) {
		this.b5 = b5;
	}
	public Image getImage1() {
		return image1;
	}
	public void setImage1(Image image1) {
		this.image1 = image1;
	}
	public Image getImage2() {
		return image2;
	}
	public void setImage2(Image image2) {
		this.image2 = image2;
	}
	public Image getImage3() {
		return image3;
	}
	public void setImage3(Image image3) {
		this.image3 = image3;
	}
	public Image getImage4() {
		return image4;
	}
	public void setImage4(Image image4) {
		this.image4 = image4;
	}
	
	static String comboselectnew;
	static String moviefilternew;
	static String datefilternew;
	
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	
	/**
	 * Setting up of GUI
	 */
	public void setgui(){
		
	    System.out.println(comboselectnew+moviefilternew+datefilternew); 
		//Stage primaryStage = new Stage();
	    
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/homepage.fxml"));
		
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
	
		
		try {
		daomoviefilter moviefilterdb = new daomoviefilter();
		try {
			result=moviefilterdb.getResultSetmoviecheck(comboselectnew,moviefilternew);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (result.next()){
		System.out.println(result.getString("movie_pic"));
		
		//List<String> res = new ArrayList<String>();
		//List<String> name = new ArrayList<String>();
		}
		
			result.beforeFirst();
		
		while (result.next()){
			System.out.println("\""+result.getString("movie_pic")+"\"");
		res.add(result.getString("movie_pic"));	
		name.add(result.getString("Movie_name"));
		}	
		
		result.close();
		 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res.size());
		
		b5.setOpacity(0);
		label.setOpacity(0);
		
		image1 = new Image(res.get(0));
		Imagev1.setImage(image1);
	    b1.setOpacity(1);
	    b1.setText(name.get(0));
	    
	  	
	  		image2 = new Image(res.get(1));
	  		Imagev2.setImage(image2);
	  	    b2.setOpacity(1);
	  	    b2.setText(name.get(1));
	  	
			image3 = new Image(res.get(2));
			Imagev3.setImage(image3);
		    b3.setOpacity(1);
		    b3.setText(name.get(2));
		    
		    image4 = new Image(res.get(3));
			Imagev4.setImage(image4);
		    b4.setOpacity(1); 
		    b4.setText(name.get(3));

		
	}
	
	
/**
 * This button is for selecting the movie. Each button represents different movie.
 * 
 *
 */
	@FXML
public void button1(ActionEvent event) throws Exception{
		
		ShowtimeController showtimefunc = new ShowtimeController(image1.impl_getUrl(),name.get(0));
	//	ShowtimeController showtimefunc = new ShowtimeController();
		showtimefunc.setgui();
						
	}
/**
 * Button for second movie.
 * 
 */
	@FXML
	public void button2(ActionEvent event) throws Exception{
	
		
		ShowtimeController showtimefunc = new ShowtimeController(image2.impl_getUrl(),name.get(1));
		//ShowtimeController showtimefunc = new ShowtimeController();
		showtimefunc.setgui();
		
		
	}
	
/**
 * Button for third movie
 * 
 * 
 */
	@FXML
	public void button3(ActionEvent event) throws Exception{
		
		
		ShowtimeController showtimefunc = new ShowtimeController(image3.impl_getUrl(),name.get(2));
		//ShowtimeController showtimefunc = new ShowtimeController();
		showtimefunc.setgui();
		
		}
	
	/**
	 * Button for fourth movie
	 *  
	 */
	@FXML
	public void button4(ActionEvent event) throws Exception{
		
		ShowtimeController showtimefunc = new ShowtimeController(image4.impl_getUrl(),name.get(3));
		//ShowtimeController showtimefunc = new ShowtimeController();
		showtimefunc.setgui();
		
	}

	/**
	 * This method is for navigating to back window.
	 * 
	 */
	public void backbutton(ActionEvent event) throws Exception{
		datemovieController date = new datemovieController();
		date.setgui();
	}
	
	
	/**
	 * Method for logging out.
	*/
	public void logoutbutton(ActionEvent event) throws Exception{
		Main log = new Main();
		log.start(Main.getPrimarystage());
	}
	}


	
	
