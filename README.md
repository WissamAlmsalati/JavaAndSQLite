# JDBC SQLite Connection Example

This Java program demonstrates how to connect to an SQLite database using JDBC.

## Prerequisites

1. **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed.
   - You can download JDK from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/).

2. **SQLite JDBC Driver**: 
   - The SQLite JDBC driver (`sqlite-jdbc-3.5.8.jar`) is required to connect to SQLite databases.
   - Download it from the [SQLite JDBC website](http://www.java2s.com/Code/Jar/s/Downloadsqlitejdbc358jar.htm).

3. **SQLite Database File**:
   - Ensure your SQLite database file (`SqliteJavaDB.db`) exists in the `src` directory of your project.

## Setup Instructions

### Compilation

#### Windows:

1. **Open Command Prompt**:
   - Navigate to the project directory containing `Main.java` and `sqlite-jdbc-3.5.8.jar`.

2. **Compile `Main.java`**:
   ```cmd
   javac -cp "lib/sqlite-jdbc-3.5.8.jar:lib/slf4j-api-1.7.36.jar" -d bin src/DB_Connection.java  src/Main.java
3. **Run Main File**
   ```cmd
   java -cp "bin;lib/sqlite-jdbc-3.5.8.jar:lib/slf4j-api-1.7.36.jar" Main



#### Linux Or Mac os

1. **Open Terminal**
     - Navigate to the project directory containing `Main.java` and `sqlite-jdbc-3.5.8.jar`.

2. **Compile Main**
   ```cmd 
    javac -cp "lib/sqlite-jdbc-3.5.8.jar:lib/slf4j-api-1.7.36.jar" -d bin src/DB_Connection.java  src/Main.java

3. **Run Main File**
   ```cmd
   java -cp "bin:lib/sqlite-jdbc-3.5.8.jar:lib/slf4j-api-1.7.36.jar" Main

# JavaAndSQLite
