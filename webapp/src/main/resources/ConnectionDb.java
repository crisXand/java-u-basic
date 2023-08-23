import java.sql.DriverManager;

public class ConnectionDb {
	private static  String url = "jdbc:mysql://localhost:3306/javajdbc?serverTimeZone=America/El_Salvador";
    private static String username = "root";
    private static String pass = "";
    private static Connection conn = null;

    public static Connection getInstance() throws SQLException {
        if(conn == null){
            conn = DriverManager.getConnection(url,username,pass)
        }
        return conn;
    }
}
