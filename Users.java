
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.List;

public class Users extends JInternalFrame {
    private JDesktopPane desktopPane;
    private JPanel panel;
    private Database database;
    public Users(JDesktopPane desktopPane){
        this.desktopPane = desktopPane;
        database =  new Database();
        initComponents();
    }

    private void initComponents(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 5, 5));
        List<UserModel> users = database.getUsers();

        Object rows[][]= new Object[users.size()][3];
        for(int i = 0; i < users.size(); i++){
            rows[i] = new Object[]{users.get(i).getId(), users.get(i).getName(), users.get(i).getAge()};
        }
        String columns[]={"ID","NAME","AGE"};
        JTable tblUsers = new JTable(rows, columns);
        JScrollPane scrollPane=new JScrollPane(tblUsers);
        panel.add(scrollPane);
        add(panel);
        pack();
    }
}
