import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonaForm extends JFrame implements ActionListener {

    private JLabel lbTitle;
    private JTextField tfNome;
    private JTextField tfCognome;
    private JTextField tfIndirizzo;
    private JTextField tfTelefono;
    private JTextField tfEta;
    private JLabel lbNome;
    private JLabel lbCognome;
    private JLabel lbIndirizzo;
    private JLabel lbTelefono;
    private JLabel lbEta;
    private JButton btnSave;
    private JButton btnCancel;
    private String mode;
    private int index;


    PersonaForm(String mode)
    {
        this.mode = mode;
        JPanel loginPanel = loginForm();

        getContentPane().add(loginPanel, BorderLayout.CENTER);
        setTitle("Login Form");
        setBounds(10,10,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    PersonaForm(String mode, int idx)
    {
        index = idx;
        this.mode = mode;
        JPanel loginPanel = loginForm();

        RubricaDB rubricaDB = new RubricaDB();
        Persona persona = rubricaDB.getPersonaDB(index);
        setNome(persona.getNome());
        setCognome(persona.getCognome());
        setIndirizzo(persona.getIndirizzo());
        setTelefono(persona.getTelefono());
        setEta(String.valueOf(persona.getEta()));

        getContentPane().add(loginPanel, BorderLayout.CENTER);
        setTitle("Login Form");
        setBounds(10,10,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public JPanel loginForm(){

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        Insets i = new Insets(3, 3, 3, 3);


        lbTitle = new JLabel("<html>Form di<br>Compilazione</html>");
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        lbTitle.setVerticalAlignment(JLabel.TOP);
        lbTitle.setFont(new Font("Verdana", Font.PLAIN, 25));
        lbTitle.setPreferredSize(new Dimension(185, 100));
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbTitle, cs);

        lbNome = new JLabel("Nome: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbNome, cs);

        tfNome = new JTextField(20);
        tfNome.setPreferredSize(new Dimension(100,30));
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        cs.insets = i;
        panel.add(tfNome, cs);

        lbCognome = new JLabel("Cognome: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbCognome, cs);

        tfCognome = new JTextField(20);
        tfCognome.setPreferredSize(new Dimension(100,30));
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        cs.insets = i;
        panel.add(tfCognome, cs);

        lbIndirizzo = new JLabel("Indirizzo: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbIndirizzo, cs);

        tfIndirizzo = new JTextField(20);
        tfIndirizzo.setPreferredSize(new Dimension(100,30));
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        cs.insets = i;
        panel.add(tfIndirizzo, cs);

        lbTelefono = new JLabel("Telefono: ");
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbTelefono, cs);

        tfTelefono = new JTextField(20);
        tfTelefono.setPreferredSize(new Dimension(100,30));
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        cs.insets = i;
        panel.add(tfTelefono, cs);

        lbEta = new JLabel("Età: ");
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbEta, cs);

        tfEta = new JTextField(20);
        tfEta.setPreferredSize(new Dimension(100,30));
        cs.gridx = 1;
        cs.gridy = 5;
        cs.gridwidth = 2;
        cs.insets = i;
        panel.add(tfEta, cs);

        btnSave = new JButton("Salva");
        btnSave.setHorizontalAlignment(JLabel.CENTER);
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 2;
        cs.insets = new Insets(20,10,20,20);
        panel.add(btnSave, cs);


        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                    if (mode == "Add"){
                        Persona persona = new Persona();
                        persona.setNome(getNome());
                        persona.setCognome(getCognome());
                        persona.setIndirizzo(getIndirizzo());
                        persona.setTelefono(getTelefono());
                        persona.setEta(Integer.parseInt(getEta()));
                        RubricaDB rubricaDB = new RubricaDB();
                        rubricaDB.insertPersonaDB(persona);
                        new Rubrica().setVisible(true);
                        dispose();

                    }

                 else if (mode == "Edit"){
                        Persona persona = new Persona();
                        persona.setNome(getNome());
                        persona.setCognome(getCognome());
                        persona.setIndirizzo(getIndirizzo());
                        persona.setTelefono(getTelefono());
                        persona.setEta(Integer.parseInt(getEta()));
                        RubricaDB rubricaDB = new RubricaDB();
                        rubricaDB.updatePersonaDB(index,persona);
                        new Rubrica().setVisible(true);
                        dispose();

                }


                }


            }
        );

        btnCancel = new JButton("Annulla");
        btnCancel.setHorizontalAlignment(JLabel.CENTER);
        cs.gridx = 1;
        cs.gridy = 7;
        cs.gridwidth = 2;
        cs.insets = new Insets(20,10,20,20);
        panel.add(btnCancel, cs);


        btnCancel.addActionListener(new ActionListener() {

              public void actionPerformed(ActionEvent e) {
                  new Rubrica().setVisible(true);
                  dispose();


              }


          }
        );




        return panel;
    }

    public String getNome() {
        return tfNome.getText().trim();
    }

    public void setNome(String nome){

        tfNome.setText(nome);

    }

    public String getCognome() {
        return tfCognome.getText().trim();
    }

    public void setCognome(String cognome){

        tfCognome.setText(cognome);

    }
    public String getIndirizzo() {
        return tfIndirizzo.getText().trim();
    }

    public void setIndirizzo(String indirizzo){

        tfIndirizzo.setText(indirizzo);

    }

    public String getTelefono() {
        return tfTelefono.getText().trim();
    }

    public void setTelefono(String telefono){

        tfTelefono.setText(telefono);

    }

    public String getEta() {
        return tfEta.getText().trim();
    }

    public void setEta(String eta){

        tfEta.setText(eta);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
