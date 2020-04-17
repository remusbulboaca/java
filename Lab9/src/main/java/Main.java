import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;
import util.PersistenceUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();

        Artist artist = new Artist();
        artist.setName("Lab9");
        artist.setCountry("Romania");
        artistRepository.create(artist);

        ;

    }
}
