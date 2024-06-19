import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {

    public void createTable(Connection conn, String tableName) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (ID INTEGER PRIMARY KEY, NAME TEXT NOT NULL)";
        executeUpdate(conn, sql);
    }

    public void showTable(Connection conn ){
        String sql = "Show Tables";
    }

    public void dropTable(Connection conn, String tableName) {
        String sql = "DROP TABLE IF EXISTS " + tableName;
        executeUpdate(conn, sql);
    }

    public void insertData(Connection conn, String tableName, int id, String name) {
        String sql = "INSERT INTO " + tableName + " (ID, NAME) VALUES (" + id + ", '" + name + "')";
        executeUpdate(conn, sql);
    }

    public void updateData(Connection conn, String tableName, int id, String name) {
        String sql = "UPDATE " + tableName + " SET NAME = '" + name + "' WHERE ID = " + id;
        executeUpdate(conn, sql);
    }

    private void executeUpdate(Connection conn, String sql) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Operation successful: " + sql);
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
