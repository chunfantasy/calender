package no.ntnu.pu.gui.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {

    private JTextField userField;
    private JPasswordField passField;
    private JButton btnLogin, btnForgottenPassword;

    private String usernameInput, passwordInput;

    static JLabel lblUsername, lblPassword;

    static Container pane;
    static JFrame frmMain;

    public LoginView(){
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Labels
        lblUsername = new JLabel("Brukernavn: ", JLabel.LEFT);
        lblPassword = new JLabel("Passord: ", JLabel.LEFT);

        //Textfields (with listeners)
        userField = new JTextField(20);
        userField.addActionListener(new myUserAction());
        passField = new JPasswordField(20);
        passField.addActionListener(new myPasswordAction());

        //Buttons (with listeners)
        btnLogin = new JButton("Logg inn");
        btnLogin.addActionListener(new myLoginAction());
        btnForgottenPassword = new JButton("Glemt passord?");
        btnForgottenPassword.addActionListener(new myForgottenAction());

        //Adding components to panel
        panelAdd(0, 0, constraints, lblUsername, panel);
        panelAdd(0, 1, constraints, lblPassword, panel);
        panelAdd(1, 0, constraints, userField, panel);
        panelAdd(1, 1, constraints, passField, panel);
        panelAdd(1, 2, constraints, btnLogin, panel);
        panelAdd(1, 3, constraints, btnForgottenPassword, panel);
    }

    public void panelAdd(int gridx, int gridy, GridBagConstraints c, Component comp, JPanel panel){
        c.gridx = gridx;
        c.gridy = gridy;
        panel.add(comp, c);
    }

    public String getUsernameInput() {
        return usernameInput;
    }

    public void setUsernameInput(String usernameInput) {
        this.usernameInput = usernameInput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(String passwordInput) {
        this.passwordInput = passwordInput;
    }

    class myUserAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            setUsernameInput(userField.getText());
        }
    }

    class myPasswordAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            setPasswordInput(new String(passField.getPassword()));
        }
    }

    class myLoginAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //TODO: Sjekk brukernavn (usernameInput) og passord (passwordInput) opp mot database, gå så til kalendervisning
        }
    }

    class myForgottenAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //TODO: Hent ut e-post som matcher brukernavn, send passord til e-post
        }
    }

    public static void main(String args[]){
        frmMain = new JFrame("LoginView");
        pane = frmMain.getContentPane();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.add(new LoginView());
        frmMain.pack();
        frmMain.setResizable(false);
        frmMain.setVisible(true);
    }
}