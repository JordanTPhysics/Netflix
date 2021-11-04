import com.TSI.MovieDatabase.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieTest {



    @Test
     public void isTheTitleCorrect(){
        Movie movie = new Movie("moviename",100,123,"Action");
        Assertions.assertEquals("moviename",movie.getTitle(),"The title is wrong");
    }
}
