package Controller;

//import statements
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import Model.guisetup;
import application.Main;
import dao.daomodifymovie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * This class is for modifying the movie running in the theatre. When movies are available
 * you can switch  between movies.
 * @author Aneesh Partha
 *
 */
public class modifymovieController implements Initializable,guisetup {
	
	@FXML
	private ComboBox<String> theatreselect;
	@FXML
	public ComboBox<String> getTheatreselect() {
		return theatreselect;
	}
   
	public void setTheatreselect(ComboBox<String> theatreselect) {
		this.theatreselect = theatreselect;
	}

	private daomodifymovie modifymovie = new daomodifymovie();
	
	public daomodifymovie getModifymovie() {
		return modifymovie;
	}

	public void setModifymovie(daomodifymovie modifymovie) {
		this.modifymovie = modifymovie;
	}
	
	@FXML
	private ComboBox<String> newmovieadd;

	public ComboBox<String> getNewmovieadd() {
		return newmovieadd;
	}

	public void setNewmovieadd(ComboBox<String> newmovieadd) {
		this.newmovieadd = newmovieadd;
	}

	@FXML
	private ComboBox<String> movieold;
	
	public ComboBox<String> getMovieold() {
		return movieold;
	}

	public void setMovieold(ComboBox<String> movieold) {
		this.movieold = movieold;
	}

	private String moviename;
	public String getOldmovie() {
		return oldmovie;
	}

	public void setOldmovie(String oldmovie) {
		this.oldmovie = oldmovie;
	}

	public String getNewmovie() {
		return newmovie;
	}

	public void setNewmovie(String newmovie) {
		this.newmovie = newmovie;
	}

	private String oldmovie;
	private String newmovie;
	
	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Button getModifymoviebb() {
		return modifymoviebb;
	}

	public void setModifymoviebb(Button modifymoviebb) {
		this.modifymoviebb = modifymoviebb;
	}

	public Button getModifymovielog() {
		return modifymovielog;
	}

	public void setModifymovielog(Button modifymovielog) {
		this.modifymovielog = modifymovielog;
	}

	private Button modifymoviebb = new Button();
	private Button modifymovielog = new Button();
	
	/**
	 * Setting up of GUI
	 */
	public void setgui() {
	    
		//Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/modifymovie.fxml"));
		
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
	ResultSet result = null;	
		//daomodifymovie modifymovie = new daomodifymovie();
		try {
			result=modifymovie.modifymov();
		
		
		while(result.next()){
			
			//theatreselect.getItems().add(result.getString("Theatre_name"));
			getTheatreselect().getItems().add(result.getString("Theatre_name"));
			
		}
		
		result.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
   /**
    * This function is for selecting the movies to be switched
    * 
    */
	public void comboaction1(ActionEvent event) throws Exception{
		
		ResultSet result = null;
		System.out.println(getTheatreselect().getValue());
		setMoviename(getTheatreselect().getValue());
		result=modifymovie.modifynewmov(getTheatreselect().getValue());
		
			
		if(!result.next()){
			getNewmovieadd().getItems().add("No movies");
			System.out.println("hi if");
		}
		
		else {
			result.beforeFirst();
			while(result.next()){
				System.out.println("hi else");
				getNewmovieadd().getItems().add(result.getString("Movie_name"));
			}
		
			result.close();
		}
	}
	
	/**
	 * New movie to be selected.
	 */
	public void comboaction2(ActionEvent event) throws Exception{
		
		ResultSet result = null;
		setNewmovie(getNewmovieadd().getValue());
		result=modifymovie.modifyoldmov(getMoviename());
		
		while(result.next()){
			
			getMovieold().getItems().add(result.getString("Movie_name"));
		}
		result.close();
			
	}
	

public void comboaction3(ActionEvent event) throws Exception{
	
	setOldmovie(getMovieold().getValue());
				
	}

/**
 * Once all the selection is completed. It is submitted in order for the change to occur.
 */
public void confirm(ActionEvent event) throws Exception{
	

	ResultSet result = null;
	setNewmovie(getNewmovieadd().getValue());
	modifymovie.tblmoviemodify(getMoviename(),getNewmovie(),getOldmovie());
	adminmainController maincon = new adminmainController();
	maincon.setgui();
	
	Stage primaryStage = new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("/View/recordmodified.fxml"));
	Scene scene = new Scene(root,294,153);
	//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
	
	}

/**
 * Method for navigating back.
 */

public void backmodify (ActionEvent event) throws Exception{
	adminmainController maincon = new adminmainController();
	maincon.setgui();
}

/**
 * 
 *Method for logging out
 */
public void logout (ActionEvent event) throws Exception{
	adminloginController login = new adminloginController();
	login.setgui();
}
}
