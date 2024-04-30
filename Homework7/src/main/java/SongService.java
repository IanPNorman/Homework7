import java.util.List;

public interface SongService {
    NewSong searchById(Integer songID);
    List<NewSong> searchByTitle(String title);
    List<NewSong> searchByAlbum(String album);
}
