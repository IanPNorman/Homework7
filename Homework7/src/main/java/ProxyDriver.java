import java.util.Arrays;
import java.util.List;

public class ProxyDriver {

    public static void main(String[] args) {
        List<NewSong> newSongs = Arrays.asList(
                new NewSong(1, "One of Us", "Mystery Skull", "One of Us", 195),
                new NewSong(2, "Put Them Down", "Eben", "N/A", 274),
                new NewSong(3, "Good News", "Apashe", "Renaissance", 244),
                new NewSong(4, "Come and Get Your Love", "Redbone", "Wovoka", 180),
                new NewSong(5, "Panorama", "DROELOE", "A Matter of Perspective", 316)
        );

        RealSongService realSongService = new RealSongService(newSongs);
        ProxySongService proxySongService = new ProxySongService(realSongService);


        testSearchByTitle(proxySongService, "One of Us");
        testSearchByTitle(proxySongService, "One of Us");


        testSearchById(proxySongService, 3);
        testSearchById(proxySongService, 3);


        testSearchByAlbum(proxySongService, "Renaissance");
        testSearchByAlbum(proxySongService, "Renaissance");
    }

    private static void testSearchByTitle(ProxySongService service, String title) {
        long startTime = System.currentTimeMillis();
        int resultCount = service.searchByTitle(title).size();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Searching by Title '" + title + "':");
        System.out.println(resultCount + " songs found.");
        System.out.println("Time taken: " + duration + " ms\n");
    }

    private static void testSearchById(ProxySongService service, int id) {
        long startTime = System.currentTimeMillis();
        NewSong song = service.searchById(id);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Searching by ID " + id + ":");
        System.out.println(song != null ? "Song found: " + song.getTitle() : "No song found.");
        System.out.println("Time taken: " + duration + " ms\n");
    }

    private static void testSearchByAlbum(ProxySongService service, String album) {
        long startTime = System.currentTimeMillis();
        List<NewSong> songs = service.searchByAlbum(album);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Searching by Album '" + album + "':");
        System.out.println(songs.size() + " songs found.");
        System.out.println("Time taken: " + duration + " ms\n");
    }
}