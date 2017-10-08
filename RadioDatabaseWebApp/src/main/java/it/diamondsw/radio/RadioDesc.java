package it.diamondsw.radio;
import java.net.URL;
import java.net.MalformedURLException;
    
public class RadioDesc {
    private String name;
    private String genre;
    private URL url;
    private int id;
    private URL purl;
    
	public RadioDesc (int radioId, String radioName, int radioGenreId, URL radioUrl, URL radioPlayUrl) {
    	name = radioName;
    	genre = GenreModel.getGenre(radioGenreId).getGenre();
    	url = radioUrl;
    	id = radioId;
    	purl = radioPlayUrl;
    }

	public RadioDesc (Radio r) {
    	name = r.getName();
    	genre = GenreModel.getGenre(r.getGenre()).getGenre();
    	url = r.getUrl();
    	id = r.getId();
    	purl = r.getPlayUrl();
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
    
    public void setPurl (String radioPlayUrl) {
	try {
	    this.purl = new URL(radioPlayUrl);
	}
	catch (MalformedURLException e) { e.printStackTrace(); }
    }
    public URL getPurl() {
	return this.purl;
    }
    
    public Radio toRadio() {
    	Radio r = new Radio();
    	r.setId(id);
    	r.setName(name);
    	r.setGenre(GenreModel.getGenreByName(genre).get(0).getId());
    	r.setUrl(url.toString());
    	r.setPlayUrl(purl.toString());
    	return r;
    }
    
    public String toString() {
    	return ("[ id=" + id + " name=" + name + " genre=" + genre + " url=" + url.toString() + " play=" + purl.toString() +  " ]");
    }
    
} // Radio                                   
