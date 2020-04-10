import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlbumController {
    public void create(String name, Artist a, Integer year) {
        Integer idArtist = a.getId();
        String albumName = name;
        Integer releaseYear = year;
        String querry = "insert into albums(name,artist_id,release_year) values (?,?,?)";
        PreparedStatement statement;
        try {
            Connection connection = Database.getDatabase();
            statement = connection.prepareStatement(querry);
            statement.setString(1, albumName);
            statement.setInt(2, idArtist);
            statement.setInt(3, releaseYear);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Album findByArtist(Artist a) {
        Album album = new Album();
        String querry = "select * from albums where artist_id=?";
        PreparedStatement stmt;
        try {
            Connection connection = Database.getDatabase();
            stmt = connection.prepareStatement(querry);
            stmt.setInt(1,a.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                album.setId(rs.getInt("id"));
                album.setName(rs.getString("name"));
                album.setArtist_id(rs.getInt("artist_id"));
                album.setReleaseYear(rs.getInt("release_year"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return album;
    }
}
