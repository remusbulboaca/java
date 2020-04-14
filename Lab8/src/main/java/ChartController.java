import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ChartController {
    public ArrayList<Chart> getChart(){
        ArrayList<Chart> charts = new ArrayList<>();
        String querry= "select artists.name, albums.name, votes from charts left join albums on albums.id=charts.id_album left join artists on artists.id=albums.artist_id order by votes desc";
        Statement stmt;
        try {
            Connection connection = Database.getDatabase();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while(rs.next()){
                Chart chart = new Chart();
                chart.setArtist_name(rs.getString(1));
                chart.setAlbum_name(rs.getString(2));
                chart.setVotes(rs.getInt("votes"));
                charts.add(chart);
            }
            //Avem lista cu ChartData(id_album si votes)
            //Realizam un nou ArrayList de tip <Chart> unde stocam nume artist,nume album si votes.

        }catch (Exception e){
            System.out.println(e);
        }
        return charts;
    }
    public void create(Album album,Integer votes){
        Integer album_id = album.getId();
        String querry = "insert into charts(id_album,votes) values (?,?)";
        PreparedStatement stmt;
        try{
            Connection connection = Database.getDatabase();
            stmt = connection.prepareStatement(querry);
            stmt.setInt(1,album_id);
            stmt.setInt(2,votes);
            stmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
