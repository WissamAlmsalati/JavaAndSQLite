import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            
            // Connect to the SQLite database
            conn = DriverManager.getConnection("jdbc:sqlite:/home/wissam/Documents/javaDB/src/SqliteJavaDB.db");
            
            // Print confirmation message
            System.out.println("Connected to SQLite database.");
            
        } catch (Exception e) {
            // Print error message
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            // Close the connection
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }
}
