package it.diamondsw.radio;
import java.net.URL;
import java.net.MalformedURLException;
    
public class Radio {
    private String name;
    private int genreId;
    private URL url;
    private int id;
    
	public Radio() {}
	public Radio (int radioId, String radioName, int radioGenreId, URL radioUrl) {
    	name = radioName;
    	genreId = radioGenreId;
    	url = radioUrl;
    	id = radioId;
    }

    public void setName(String name) {
	this.name = name;
    }
    public String getName() {
	return this.name;
    }

    public void setGenre(int radioGenreId) {
	this.genreId = radioGenreId;
    }                                 
    public int getGenre() {
	return this.genreId;
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
    	return ("[ id=" + id + " name=" + name + " genre=" + genreId + " url=" + url.toString() + " ]");
    }
    
} // Radio                                   
