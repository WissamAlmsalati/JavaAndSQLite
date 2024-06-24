import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DataInsertionGUI extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JButton insertButton;
    private DB_Connection dbConnection;

    public DataInsertionGUI(DB_Connection dbConnection) {
        this.dbConnection = dbConnection;
        setTitle("Data Insertion");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        insertButton = new JButton("Insert Data");
        panel.add(insertButton);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> tableNames = dbConnection.getTableNames();
                String[] options = tableNames.toArray(new String[0]);
                String selectedTable = (String) JOptionPane.showInputDialog(null, "Select Table:", "Table Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (selectedTable != null) {
                    showDataInsertionDialog(selectedTable);
                }
            }
        });
    }

    private void showDataInsertionDialog(String tableName) {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        Object[] message = {
            "ID:", idField,
            "Name:", nameField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Insert Data into " + tableName, JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            insertData(tableName, idField.getText(), nameField.getText());
        }
    }

    private void insertData(String tableName, String idText, String nameText) {
        int id = Integer.parseInt(idText);
        String name = nameText;

        new Thread(() -> {
            dbConnection.insertData(tableName, id, name);
            JOptionPane.showMessageDialog(this, "Data inserted successfully!");
        }).start();
    }

    public static void main(String[] args) {
        DB_Connection dbConnection = new DB_Connection();
        dbConnection.connect();
        SwingUtilities.invokeLater(() -> {
            DataInsertionGUI gui = new DataInsertionGUI(dbConnection);
            gui.setVisible(true);
        });
    }
}