package it.diamondsw.radio;
import java.util.List;
import java.util.ArrayList;

public class GenreService {
		
	    /**
	    * Returns the genres of radio in database.
	    * @return a list of genre objects
	    */
	    public List<Genre> findAvailGenres() {
	        return GenreModel.getGenres(); 
	    }

	    /**                                  
	    * Returns the genre in database given an id
	    * @param id of genre
	    * @return a single genre if exists        
	    */
	    public Genre findGenre(int id) {
	        return GenreModel.getGenre(id);	
	    }
	    /**                                  
	    * Returns the genre in database given name
	    * @param name of genre
	    * @return a single genre if exists        
	    */
	    public Genre findGenreByName(String name) {
	        return GenreModel.getGenreByName(name);	
	    }
	    
	    
	    /**                                  
	    * Insert a new genre in database
	    * @param genre
	    * throws if SQLException        
	    */
	    public void insertGenre(Genre g) {
	    	ArrayList<Genre> genres = new ArrayList<Genre>();
	    	if (g != null) {
	    		genres.add(g);
	    		GenreModel.setGenres(genres);	
	    	}
	    }    
	    
} // GenreService

