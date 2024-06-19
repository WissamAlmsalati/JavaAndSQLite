import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DB_Connection dbConnection = new DB_Connection();
        DBOperations dbOperations = new DBOperations();

        try (Connection conn = dbConnection.connect()) {
            if (conn != null) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Choose an operation:");
                    System.out.println("1. Create Table");
                    System.out.println("2. Drop Table");
                    System.out.println("3. Insert Data");
                    System.out.println("4. Update Data");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter table name: ");
                            String createTableName = scanner.next();
                            dbOperations.createTable(conn, createTableName);
                            break;
                        case 2:
                            System.out.print("Enter table name: ");
                            String dropTableName = scanner.next();
                            dbOperations.dropTable(conn, dropTableName);
                            break;
                        case 3:
                            System.out.print("Enter table name: ");
                            String insertTableName = scanner.next();
                            System.out.print("Enter ID: ");
                            int insertId = scanner.nextInt();
                            System.out.print("Enter Name: ");
                            String insertName = scanner.next();
                            dbOperations.insertData(conn, insertTableName, insertId, insertName);
                            break;
                        case 4:
                            System.out.print("Enter table name: ");
                            String updateTableName = scanner.next();
                            System.out.print("Enter ID: ");
                            int updateId = scanner.nextInt();
                            System.out.print("Enter Name: ");
                            String updateName = scanner.next();
                            dbOperations.updateData(conn, updateTableName, updateId, updateName);
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
