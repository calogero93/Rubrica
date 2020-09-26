import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrazione extends JFrame implements ActionListener{

    private JLabel lbTitle;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnRegistra;
    private JButton btnAnnulla;
    private JButton btnCancel;
    private boolean succeeded;

    Registrazione()
    {
        JPanel registraPanel = registraForm();

        getContentPane().add(registraPanel, BorderLayout.CENTER);
        setTitle("Registrazione Form");
        setBounds(10,10,370,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public JPanel registraForm(){

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        Insets i = new Insets(3, 3, 3, 3);


        lbTitle = new JLabel("Registrazione");
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

        btnRegistra = new JButton("Registra");
        btnRegistra.setHorizontalAlignment(JLabel.CENTER);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        cs.insets = new Insets(20,10,20,20);
        panel.add(btnRegistra, cs);


        btnRegistra.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LoginDB loginDB = new LoginDB();
                loginDB.registraUtente(getUsername(), getPassword());
                Registrazione.this.setVisible(false);
                new Login().setVisible(true);
                dispose();

            }
        });

        btnAnnulla = new JButton("Annulla");
        btnAnnulla.setHorizontalAlignment(JLabel.CENTER);
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        cs.insets = new Insets(20,10,20,20);
        panel.add(btnAnnulla, cs);


        btnAnnulla.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Registrazione.this.setVisible(false);
                new Login().setVisible(true);
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
