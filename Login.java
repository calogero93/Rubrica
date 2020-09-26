import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {

    private JLabel lbTitle;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JButton btnRegistra;
    private boolean succeeded;

    Login()
    {
        JPanel loginPanel = loginForm();

        getContentPane().add(loginPanel, BorderLayout.CENTER);
        setTitle("Login Form");
        setBounds(10,10,370,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public JPanel loginForm(){

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

         Insets i = new Insets(3, 3, 3, 3);


        lbTitle = new JLabel("Login");
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        lbTitle.setVerticalAlignment(JLabel.TOP);
        lbTitle.setFont(new Font("Verdana", Font.PLAIN, 25));
        lbTitle.setPreferredSize(new Dimension(185, 100));
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbTitle, cs);

        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        tfUsername.setPreferredSize(new Dimension(100,30));
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        cs.insets = i;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        pfPassword.setPreferredSize(new Dimension(100,30));
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        cs.insets = i;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("Login");
        btnLogin.setHorizontalAlignment(JLabel.CENTER);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        cs.insets = new Insets(20,10,20,20);
        panel.add(btnLogin, cs);


        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LoginDB loginDB = new LoginDB();
                if (loginDB.verificaUtente(getUsername(),getPassword())!=null){
                    JOptionPane.showMessageDialog(Login.this,
                            "Ciao " + getUsername() + "! Hai eseguito il login con successo!",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);

                    Login.this.setVisible(false);
                    Rubrica rubrica = new Rubrica();
                    rubrica.setVisible(true);

                }
                else {
                    JOptionPane.showMessageDialog(Login.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    tfUsername.setText("");
                    pfPassword.setText("");


                }

            }
        });

        btnRegistra = new JButton("Registrazione");
        btnRegistra.setHorizontalAlignment(JLabel.CENTER);
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        cs.insets = new Insets(20,10,20,20);
        panel.add(btnRegistra, cs);

        btnRegistra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.setVisible(false);
                new Registrazione().setVisible(true);
                dispose();
            }
        });

        return panel;
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
