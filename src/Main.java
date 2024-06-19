import java.sql.Connection;
import java.util.Scanner;


//?To understand how to operate, open a README.md file in Preview

public class Main {

    public static void main(String[] args) {
        DB_Connection dbConnection = new DB_Connection();

        try {
            dbConnection.connection(); // Establish the connection

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1. Create Table");
                System.out.println("2. Drop Table");
                System.out.println("3. Insert Data");
                System.out.println("4. Update Data");
                System.out.println("5. Show Tables");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter table name: ");
                        String createTableName = scanner.next();
                        dbConnection.createTable(createTableName);
                        break;
                    case 2:
                        System.out.print("Enter table name: ");
                        String dropTableName = scanner.next();
                        dbConnection.dropTable(dropTableName);
                        break;
                    case 3:
                        System.out.print("Enter table name: ");
                        String insertTableName = scanner.next();
                        System.out.print("Enter ID: ");
                        int insertId = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        String insertName = scanner.next();
                        dbConnection.insertData(insertTableName, insertId, insertName);
                        break;
                    case 4:
                        System.out.print("Enter table name: ");
                        String updateTableName = scanner.next();
                        System.out.print("Enter ID: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        String updateName = scanner.next();
                        dbConnection.updateData(updateTableName, updateId, updateName);
                        break;
                    case 5:
                    dbConnection.showTables();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        dbConnection.closeConnection(); // Close the connection
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
