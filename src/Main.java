import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        IDatabaseOperations dbConnection = new DB_Connection();
        dbConnection.connect(); // Establish the connection

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
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter table name to create: ");
                    String createTableName = scanner.nextLine();
                    dbConnection.createTable(createTableName);
                    break;
                case 2:
                    System.out.print("Enter table name to drop: ");
                    String dropTableName = scanner.nextLine();
                    dbConnection.dropTable(dropTableName);
                    break;
                case 3:
                    // Implement insertData logic
                    break;
                case 4:
                    // Implement updateData logic
                    break;
                case 5:
                    // Implement showTables logic
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}