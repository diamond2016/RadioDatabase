package it.diamondsw.radio;
import java.net.URL;
import java.net.MalformedURLException;
    
public class RadioDesc {
    private String name;
    private String genre;
    private URL url;
    private int id;
    
	public RadioDesc (int radioId, String radioName, int radioGenreId, URL radioUrl) {
    	name = radioName;
    	genre = GenreModel.getGenre(radioGenreId).getGenre();
    	url = radioUrl;
    	id = radioId;
    }

	public RadioDesc (Radio r) {
    	name = r.getName();
    	genre = GenreModel.getGenre(r.getGenre()).getGenre();
    	url = r.getUrl();
    	id = r.getId();
    }

    public void setName(String name) {
	this.name = name;
    }
    public String getName() {
	return this.name;
    }

    public void setGenre(int radioGenreId) {
	this.genre = GenreModel.getGenre(radioGenreId).getGenre();
    }                                 
    public String getGenre() {
	return this.genre;
    }
    
    public void setUrl (String radioUrl) {
	try {
	    this.url = new URL(radioUrl);
	}
	catch (MalformedURLException e) { e.printStackTrace(); }
    }
    public URL getUrl() {
	return this.url;
    }

    public void setId(int id) {
	this.id = id;
    }
    public int getId() {
	return this.id;
    }
    
    public String toString() {
    	return ("[ id=" + id + " name=" + name + " genre=" + genre + " url=" + url.toString() + " ]");
    }
    
} // Radio                                   
