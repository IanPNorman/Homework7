import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
class ProxySongServiceTest {
    private RealSongService realService;
    private ProxySongService proxyService;

    @BeforeEach
    void setUp() {
        List<NewSong> songs = Arrays.asList(
                new NewSong(1, "One of Us", "Mystery Skull", "One of Us", 195),
                new NewSong(2, "Put Them Down", "Eben", "N/A", 274),
                new NewSong(3, "Good News", "Apashe", "Renaissance", 244)
        );
        realService = new RealSongService(songs);
        proxyService = new ProxySongService(realService);
    }

    @Test
    void testCachingSearchByTitle() {
        System.out.println("Testing caching on searchByTitle");
        List<NewSong> firstCall = proxyService.searchByTitle("One of Us");
        long startTime = System.currentTimeMillis();
        List<NewSong> secondCall = proxyService.searchByTitle("One of Us");
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        Assertions.assertEquals(firstCall.size(), secondCall.size());
        Assertions.assertTrue(duration < 100, "Cached call should be faster and under 100ms");
    }

    @Test
    void testCachingSearchById() {
        System.out.println("Testing caching on searchById");
        NewSong firstCall = proxyService.searchById(3);
        long startTime = System.currentTimeMillis();
        NewSong secondCall = proxyService.searchById(3);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        Assertions.assertEquals(firstCall.getTitle(), secondCall.getTitle());
        Assertions.assertTrue(duration < 100, "Cached call should be faster and under 100ms");
    }
}
