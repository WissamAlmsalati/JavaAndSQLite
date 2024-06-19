import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {

    private Connection conn = null; 
    private Statement stmt = null; 

    //?Create a conniction

    public void connect() { 
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:your_database_file.db"); // Replace with your database file path
            System.out.println("Connected to SQLite database.");

            stmt = conn.createStatement(); 
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    //?Close Conniction
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) { 
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    //?SQL Queries
    
    public void createTable(String tableName) { 
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (ID INTEGER PRIMARY KEY, NAME TEXT NOT NULL)";
        try {
            stmt.executeUpdate(sql);
            System.out.println("Table created: " + tableName);
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void showTables() { 
        try {
            String sql = "SELECT name FROM sqlite_master WHERE type='table'";
            stmt.execute(sql);
            System.out.println("Tables in the database:");
            while (stmt.getResultSet().next()) {
                System.out.println(stmt.getResultSet().getString(1));
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void dropTable(String tableName) { 
        String sql = "DROP TABLE IF EXISTS " + tableName;
        try {
            stmt.executeUpdate(sql);
            System.out.println("Table dropped: " + tableName);
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void insertData(String tableName, int id, String name) { 
        String sql = "INSERT INTO " + tableName + " (ID, NAME) VALUES (" + id + ", '" + name + "')";
        try {
            stmt.executeUpdate(sql);
            System.out.println("Data inserted into " + tableName + ": ID=" + id + ", NAME=" + name);
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void updateData(String tableName, int id, String name) { 
        String sql = "UPDATE " + tableName + " SET NAME = '" + name + "' WHERE ID = " + id;
        try {
            stmt.executeUpdate(sql);
            System.out.println("Data updated in " + tableName + ": ID=" + id + ", NAME=" + name);
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

   
}
