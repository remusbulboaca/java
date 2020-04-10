import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistControllerTest {

    @Test
    void findByName() {
        ArtistController artistController = new ArtistController();
        Artist a = new Artist();
        a = artistController.findByName("Rihanna");
        assertEquals(6,a.getId());
    }
}