
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JInternalFrame {
    private JDesktopPane desktopPane;
    private JPanel panel;
    private JLabel lblID;
    private JLabel lblName;
    private JLabel lblAge;

    private JTextField tfID;
    private JTextField tfName;
    private JTextField tfAge;

    private JButton btnSave;

    private Database database;

    public User(JDesktopPane desktopPane){
        this.desktopPane = desktopPane;
        initComponents();
        database = new Database();
    }

    private void initComponents(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 5, 5));

        lblID = new JLabel("Enter ID: ");
        tfID = new JTextField();

        lblAge = new JLabel("Enter Age: ");
        tfAge = new JTextField();

        lblName = new JLabel("Enter Name: ");
        tfName = new JTextField();

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnSaveClicked(e);
            }
        });

        panel.add(lblID);
        panel.add(tfID);
        panel.add(lblName);
        panel.add(tfName);
        panel.add(lblAge);
        panel.add(tfAge);
        panel.add(btnSave);

        add(panel);

        pack();
    }

    private void onBtnSaveClicked(ActionEvent e){
        int id = Integer.parseInt(tfID.getText());
        String name = tfName.getText();
        int age = Integer.parseInt(tfAge.getText());
        int result = database.insertUser(new UserModel(id, name, age));
        if (result == 1){
            JOptionPane.showMessageDialog(this, "User added successfully!", "Success Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Error adding user!", "Error Information", JOptionPane.ERROR_MESSAGE);
        }
    }
}
