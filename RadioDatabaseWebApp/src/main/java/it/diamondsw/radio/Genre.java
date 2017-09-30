package it.diamondsw.radio;

public class Genre {
	private int id;
	private String genre;
	
	public Genre() {}

	public Genre(int genreId, String genreDesc) {
		id = genreId;
        genre = genreDesc;
	}
	public int getId() {
		return(this.id); 
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getGenre() {
		return(this.genre); 
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String toString() {
		return ("[ id=" + id + " genre=" + genre + " ]");
	}
}
