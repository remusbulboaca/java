import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    static Connection conn = null;
    private Database(){

    }
    public static Connection getDatabase(){
        try {
            if(conn==null){
                conn = DriverManager.getConnection("jdbc:mysql://localhost/MusicAlbums?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "dba", "sql");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
