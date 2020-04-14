import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArtistController {
    public void create(Artist a){
        String name = a.getName();
        String country = a.getCountry();
        String querry = "insert into artists(name,country) values (?,?)";
        PreparedStatement stmt;
        try {
            Connection connection = Database.getDatabase();
            stmt = connection.prepareStatement(querry);
            stmt.setString(1,name);
            stmt.setString(2,country);
            stmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Artist findByName(String name){
        String querry = "select * from artists where name like ?";
        PreparedStatement stmt;
        Artist a = new Artist();
        try {
            Connection connection = Database.getDatabase();
            stmt = connection.prepareStatement(querry);
            stmt.setString(1,name);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setCountry(rs.getString("country"));
            }
            rs.close();
            stmt.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return a;
    }
}
