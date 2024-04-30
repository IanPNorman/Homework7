
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

class RealSongServiceTest {
    private RealSongService service;

    @BeforeEach
    void setUp() {
        List<NewSong> songs = Arrays.asList(
                new NewSong(1, "One of Us", "Mystery Skull", "One of Us", 195),
                new NewSong(2, "Put Them Down", "Eben", "N/A", 274),
                new NewSong(3, "Good News", "Apashe", "Renaissance", 244)
        );
        service = new RealSongService(songs);
    }

    @Test
    void testSearchById() {
        System.out.println("Testing searchById");
        NewSong result = service.searchById(1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("One of Us", result.getTitle());
    }

    @Test
    void testSearchByTitle() {
        System.out.println("Testing searchByTitle");
        List<NewSong> results = service.searchByTitle("One of Us");
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertEquals(1, results.size());
    }

    @Test
    void testSearchByAlbum() {
        System.out.println("Testing searchByAlbum");
        List<NewSong> results = service.searchByAlbum("Renaissance");
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertEquals(1, results.size());
    }
}
