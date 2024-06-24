public interface IDatabaseOperations {
    void connect();
    void createTable(String tableName);
    void dropTable(String tableName);
    void insertData(String tableName, int id, String name);
    void updateData(String tableName, int id, String name); // Updated method signature
    void showTables();
}