import java.util.List;
import java.util.stream.Collectors;

public class RealSongService implements SongService {
    private List<NewSong> newSongs;

    public RealSongService(List<NewSong> newSongs) {
        this.newSongs = newSongs;
    }

    private void simulateNetworkDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public NewSong searchById(Integer songID) {
        simulateNetworkDelay();
        for (NewSong NewSong : newSongs) {
            if (NewSong.getId().equals(songID)) {
                return NewSong;
            }
        }
        return null;
    }

    @Override
    public List<NewSong> searchByTitle(String title) {
        simulateNetworkDelay();
        return newSongs.stream()
                .filter(NewSong -> NewSong.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<NewSong> searchByAlbum(String album) {
        simulateNetworkDelay();
        return newSongs.stream()
                .filter(NewSong -> NewSong.getAlbum().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }
}
