import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxySongService implements SongService {
    private RealSongService realSongService;
    private Map<Integer, NewSong> idCache = new HashMap<>();
    private Map<String, List<NewSong>> titleCache = new HashMap<>();
    private Map<String, List<NewSong>> albumCache = new HashMap<>();

    public ProxySongService(RealSongService realSongService) {
        this.realSongService = realSongService;
    }

    @Override
    public NewSong searchById(Integer songID) {
        return idCache.computeIfAbsent(songID, realSongService::searchById);
    }

    @Override
    public List<NewSong> searchByTitle(String title) {
        return titleCache.computeIfAbsent(title, realSongService::searchByTitle);
    }

    @Override
    public List<NewSong> searchByAlbum(String album) {
        return albumCache.computeIfAbsent(album, realSongService::searchByAlbum);
    }
}
