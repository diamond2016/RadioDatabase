package it.diamondsw.radio;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;


public class GenreModel {
   
    /**
    * Returns list of genres (of radio) in database
    * If id = 0 returns all data
    * @return genres a list of genres filtered
    */
    static List<Genre> getGenres() {
    	Connection connection = DbConnectionSingleton.getInstance().getConnection();
    	ArrayList<Genre> genres = new ArrayList<Genre>();
    	ResultSet rs = null;
        try {
        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30);  // set timeout to 30 sec.
       		rs = statement.executeQuery("select * from genres"); 
 		    	  
        	while(rs.next()) {
            	Genre genre = new Genre();
        		// read the result set
        		genre.setId(rs.getInt("id"));
        		genre.setGenre(rs.getString("genre"));
        		genres.add(genre);
        	}
        } // try
        catch(Exception e)
        {
           System.err.println(e.getMessage());
        }
        return genres;        
    } // getGenres  

    /**
    * Returns single genre by id
    * id of genre
    * @return genre, single object null if not found
    */
    static Genre getGenre(int id) {
    	Connection connection = DbConnectionSingleton.getInstance().getConnection();
    	ArrayList<Genre> genres = new ArrayList<Genre>();
    	ResultSet rs = null;
        try {
        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30);  // set timeout to 30 sec.
       		rs = statement.executeQuery("select * from genres where id = " + id); 
 		    	  
        	while(rs.next()) {
            	Genre genre = new Genre();
        		// read the result set
        		genre.setId(rs.getInt("id"));
        		genre.setGenre(rs.getString("genre"));
        		genres.add(genre);
        	}
        } // try
        catch(Exception e)
        {
           System.err.println(e.getMessage());
        }
        if (!genres.isEmpty()) 
        	return genres.get(0); 
        else return null;        
    } // getGenre     
    
    /**
    * Returns genres by name
    * Name (description) of genre
    * @return genres, objects with same genre, null if not found
    */
    static List<Genre> getGenreByName(String name) {
    	Connection connection = DbConnectionSingleton.getInstance().getConnection();
    	ArrayList<Genre> genres = new ArrayList<Genre>();
    	ResultSet rs = null;
        try {
        	Statement statement = connection.createStatement();
        	statement.setQueryTimeout(30);  // set timeout to 30 sec.
       		rs = statement.executeQuery("select * from genres where genre = " + "'" + name +"'"); 
 		    	  
        	while(rs.next()) {
            	Genre genre = new Genre();
        		// read the result set
        		genre.setId(rs.getInt("id"));
        		genre.setGenre(rs.getString("genre"));
        		genres.add(genre);
        	}
        } // try
        catch(Exception e)
        {
           System.err.println(e.getMessage());
        }
        if (!genres.isEmpty()) 
        	return genres; 
        else return null;        
    } // getGenre   
    
    /**
     * Insert a list of genres (of radio) in database
     * Skips existent ids.
     */
     static void setGenres(List<Genre> l) {
     	Connection connection = DbConnectionSingleton.getInstance().getConnection();
     	System.out.println("prima di try");
         try {
         	Statement statement = connection.createStatement(); 
         	System.out.println("prima di for");
         	for (Genre item : l) {
         		// if not exists
         		Genre genre1 = getGenre(item.getId());
         		String stm = null;
         		System.out.println("prima di if");
         		if ((genre1 == null) && (item.getId() != 0)) {
         			stm = "insert into genres (id, genre) values (" + item.getId() + "," + "'" + item.getGenre() + "'" + ")" ;
         		}
         		else if ((genre1 == null) && (item.getId() == 0)){
         			stm = "insert into genres (id, genre) values (" + "(select max(id)+10 from genres) " + "," + "'" + item.getGenre() + "'" + ")" ;
         		}
         		System.out.println("stmt = " +  stm);
         		statement.executeUpdate(stm);
         	} // for each
         } // try
 	
         catch(Exception e )
         {
        	System.out.println("exception");
            System.err.println(e.getMessage());
         }
     } // setGenres      
    
} // GenreModel
