package it.diamondsw.radio;
import java.net.URL;
import java.util.List;

/**
 * radio main !
 *
 */
public class App 
{
    public static void main( String[] args )
    {         
        Radio r = null;
        GenreService gs = new GenreService();
        RadioService rs = new RadioService(); 
    	List<RadioDesc> radios = rs.findAvailRadios();       
        System.out.println(radios);  
        List<Genre> genres = gs.findAvailGenres();       
        System.out.println(genres);
        gs.insertGenre(new Genre(60, "Religione"));
        try { r = new Radio (30, "Radio Maria", 60, new URL("http://www.radiomaria.it")); }
        catch (Exception e) {e.printStackTrace(); }
        rs.insertRadio(r);
    }                                                     
}                                                         
