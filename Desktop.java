
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.beans.PropertyVetoException;

public class Desktop extends JFrame implements InternalFrameListener{
    private JDesktopPane desktopPane;
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem newUserMenuItem;
    private JMenuItem usersMenuItem;

    public Desktop(){
        initComponents();
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int appWidth = screenDimension.width/2;
        int appHeight = screenDimension.height/2;

        setSize(appWidth,appHeight);
        setLocation(appWidth/2, appHeight/2);

        setTitle("Simple Appplication");
    }

    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        menu = new JMenu();
        menuBar = new JMenuBar();
        newUserMenuItem =  new JMenuItem();
        usersMenuItem =  new JMenuItem();

        desktopPane.setBackground(new java.awt.Color(255,255,255));
        GroupLayout desktopLayout = new GroupLayout(desktopPane);
        desktopPane.setLayout(desktopLayout);

        desktopLayout.setHorizontalGroup(desktopLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,997,Short.MAX_VALUE));
        desktopLayout.setVerticalGroup(desktopLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,522,Short.MAX_VALUE));

        menu.setText("File");

        usersMenuItem.setText("Users");
        usersMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usersMenuItemClicked(e);
            }
        });

        newUserMenuItem.setText("Add User");
        newUserMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUserMenuItemClicked(e);
            }
        });

        menu.add(newUserMenuItem);
        menu.add(usersMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        pack();
    }

    public void usersMenuItemClicked(ActionEvent e){
        Users users =  new Users(desktopPane);
        users.addInternalFrameListener(this);
        users.setVisible(true);
        desktopPane.add(users);
        try {
            users.setMaximum(true);
            setContentPane(desktopPane);
        } catch (PropertyVetoException propertyVetoException) {
            propertyVetoException.printStackTrace();
        }
    }

    public void newUserMenuItemClicked(ActionEvent e){
        User user =  new User(desktopPane);
        user.addInternalFrameListener(this);
        user.setVisible(true);
        desktopPane.add(user);
        try {
            user.setMaximum(true);
            setContentPane(desktopPane);
        } catch (PropertyVetoException propertyVetoException) {
            propertyVetoException.printStackTrace();
        }
    }


    public static void main(String[] args){
        new Desktop().setVisible(true);
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }
}
