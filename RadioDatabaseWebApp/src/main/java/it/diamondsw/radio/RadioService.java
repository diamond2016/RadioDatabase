package it.diamondsw.radio;

import java.util.ArrayList;
import java.util.List;

public class RadioService {

	/**
    * Returns the radios in database.
    * @return a list of radio objects
    */
    public List<RadioDesc> findAvailRadios() {
        return RadioModel.publishRadios(RadioModel.getRadios("", 0)); 
    }

    /**                                  
    * Returns the radios in database given a name filter
    * @param name a filter for name of the radio (used as like)
    * @return a list of radio objects        
    */
    public List<RadioDesc> findAvailRadiosByName(String name) {
        return RadioModel.publishRadios(RadioModel.getRadios(name, 0));	
    }
    
    /**                                  
    * Returns the radios in database given a genre
    * @param genre - one of the existent in db
    * @return a list of radio objects    
    */                                   
    public List<RadioDesc> findAvailRadiosByGenre(int genre) {
        return RadioModel.publishRadios(RadioModel.getRadios("", genre));	
    }

    /**                                  
    * Returns the radios in database given an id
    * @param id - one of the existent in db
    * @return a single radio object    
    */                                   
    public RadioDesc findRadio(int id) {
        return RadioModel.publish(RadioModel.getRadio(id));	
    }
    
    /**                                  
    * Insert a new radio in database
    * @param radio
    * throws if SQLException        
    */
    public void insertRadio(Radio r) {
    	ArrayList<Radio> radios = new ArrayList<Radio>();
    	if (r != null) {
    		radios.add(r);
    		RadioModel.setRadios(radios);	
    	}
    }
    
}
