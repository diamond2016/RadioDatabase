package it.diamondsw.radio;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class RadioModel {

	/**
    * Returns list of radio in database
    * If strings are null returns all data
    * @return genres a list of radio filtered
    */
    static List<Radio> getRadios (String name, int genre) {
      Connection connection = null;

      ArrayList<Radio> radios = new ArrayList<Radio>();
      ResultSet rs;
      try {
          // create a database connection
      connection = DbConnectionSingleton.getInstance().getConnection();  
	  Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
      
	  if ((name.length() == 0) && (genre == 0))
		  rs = statement.executeQuery("select * from radios"); 
	  else if ((name.length() > 0) && (genre == 0))
		  rs = statement.executeQuery("select * from radios where name like '%" + name + "%'");
	  else if ((name.length() == 0) && (genre > 0))
	      rs = statement.executeQuery("select * from radios where genre == '" + genre + "'");
	  else
		  rs = statement.executeQuery("select * from radios where name like '%" + name + "%'" + 
					                  " and genre == '" + genre + "'"); 		  
    	  
	  while(rs.next()) {
		  Radio radio = new Radio();
          // read the result set
	      radio.setName(rs.getString("name"));
	      radio.setGenre(rs.getInt("genre_id"));
	      radio.setUrl(rs.getString("url"));
	      radio.setId(rs.getInt("id"));
	      radio.setPlayUrl(rs.getString("play_url"));
	      radios.add(radio);
	      System.out.println("radio = " + radio);
          }
        } // try
	
        catch(Exception e )
        {
           System.err.println(e.getMessage());
        }
        return radios;        
    } // getRadios  

    
    /**
     * Returns single radio in database given id
     * @param id radio id to search
     * @return radio
     */
     static Radio getRadio(int id) {
       Connection connection = null;

       Radio radio = new Radio();
       ResultSet rs;
       try {
           // create a database connection
    	   connection = DbConnectionSingleton.getInstance().getConnection();  
    	   Statement statement = connection.createStatement();
    	   statement.setQueryTimeout(30);  // set timeout to 30 sec.    
 		   rs = statement.executeQuery("select * from radios where id=" + id);      	  
 		   while(rs.next()) {
 			   // read the result set
 			   radio.setName(rs.getString("name"));
 			   radio.setGenre(rs.getInt("genre_id"));
 			   radio.setUrl(rs.getString("url"));
 			   radio.setPlayUrl(rs.getString("play_url"));
 			   radio.setId(rs.getInt("id"));
          }
         } // try
         catch(Exception e )
         {
            System.err.println(e.getMessage());
         }
         return radio;        
     } // getRadios      
    
    
    /**
     * Insert a list of radios in database
     * Skips existent ids.
     */
     static void setRadios(List<Radio> l) {
     	Connection connection = DbConnectionSingleton.getInstance().getConnection();
        try {
         	Statement statement = connection.createStatement(); 
        	for (Radio item : l) {
        		// if not exists
         		Radio radio1 = getRadio(item.getId());
         		String stm = null;
         		if ((radio1 == null) && (item.getId() != 0)) {
         			stm = "insert into radios (id, name, genre_id, url, play_url) values (" + 
         					item.getId() + "," + "'" + item.getName() + "'" + "," + 
         			        item.getGenre() + "," + "'" + item.getUrl().toString() + "'" + "," + 
         					"'" + item.getPlayUrl().toString() + "'" + ")";
         		}
         		else if ((radio1 != null) && (item.getId() == 0)){
         			stm = "insert into radios (id, name, genre_id, url, play_url) values (" + 
         					"(select max(id)+10 from radios)" + "," + "'" + item.getName() + "'" + "," + 
        			        item.getGenre() + "," + "'" + item.getUrl().toString() + "'" + "," + 
        					"'" + item.getPlayUrl().toString() + "'" + ")";        			
         			}	
         		statement.executeUpdate(stm);
         	} // for each
         } // try
         catch(Exception e)
         {
            System.err.println(e.getMessage());
         }  
     } // setRadios    

     
     /**
      * Convert a single radio object in radiodesc suitable to publish
      * @param radio a radio object
      * @return a radiodesc object
      */
      static RadioDesc publish(Radio radio) {
      	RadioDesc result = new RadioDesc(radio);
      	return result;
      } // publish    
     
     /**
      * Convert radio objects in radiodesc suitable to publish
      * @param radioList list of radio objects
      * @return list of radiodesc objects
      */
      static List<RadioDesc> publishRadios(List<Radio> radioList) {
      	ArrayList<RadioDesc> result = new ArrayList<RadioDesc>();
      	for (Radio radio : radioList) {
      		RadioDesc radiod = new RadioDesc(radio);
      		result.add(radiod);
      	}
      	return result;
      } // publishRadios
      
} // RadioModel
