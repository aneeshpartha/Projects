package Model;

public class Movie {
	
	public int getMovie_id() {
		return Movie_id;
	}
	public void setMovie_id(int movie_id) {
		Movie_id = movie_id;
	}
	public String getMovie_name() {
		return Movie_name;
	}
	public void setMovie_name(String movie_name) {
		Movie_name = movie_name;
	}
	public String getMovie_pic() {
		return movie_pic;
	}
	public void setMovie_pic(String movie_pic) {
		this.movie_pic = movie_pic;
	}
	public String getMovie_desc() {
		return movie_desc;
	}
	public void setMovie_desc(String movie_desc) {
		this.movie_desc = movie_desc;
	}
	private int Movie_id;
	private String Movie_name;
	private String movie_pic;
	private String movie_desc;

}
