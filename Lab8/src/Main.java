import java.sql.*;

public class Main {
    public static void main(String Args[]) {
        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();

        Artist artist1 = new Artist("B.U.G Mafia","Romania");
        artistController.create(artist1);


        /*
        Artist wantedArtist = new Artist();
        wantedArtist = artistController.findByName("Sisu");
        System.out.println(wantedArtist);

         */


        /*
        Album albumNou;
        albumController.create("Deasupra tuturor",wantedArtist,1997);
        */

        /*
        Album wantedAlbum = new Album();
        wantedAlbum = albumController.findByArtist(wantedArtist);
        System.out.println(wantedAlbum);

        */


    }
}
