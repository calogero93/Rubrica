import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Rubrica  extends JFrame {

    RubricaDB rubricaDB = new RubricaDB();
    DefaultTableModel model = rubricaDB.mostraRubrica();
    private JLabel lbTitle;
    private JTable tbRubrica;
    JToolBar toolBar;
    int index;

    Rubrica(){

        JPanel rubricaPanel = rubricaScreen();

        getContentPane().add(rubricaPanel, BorderLayout.CENTER);
        getContentPane().add(toolBar, BorderLayout.NORTH);
        setTitle("Rubrica");
        setBounds(10,10,700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public JPanel rubricaScreen(){


        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        Insets i = new Insets(3, 3, 3, 3);


        toolBar = new JToolBar();

        lbTitle = new JLabel("Rubrica");
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        lbTitle.setVerticalAlignment(JLabel.TOP);
        lbTitle.setFont(new Font("Verdana", Font.PLAIN, 25));
        lbTitle.setPreferredSize(new Dimension(185, 100));
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(lbTitle, cs);


        tbRubrica = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbRubrica);
        scrollPane.setPreferredSize(new Dimension(600,300));
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        cs.insets = i;
        panel.add(scrollPane, cs);





        JButton buttonAdd = new JButton(new ImageIcon(getClass().getResource("add-user-male.png")));

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Rubrica.this.setVisible(false);
                PersonaForm personaForm = new PersonaForm("Add");
                personaForm.setVisible(true);
                dispose();

            }
        });

        JButton buttonEdit = new JButton(new ImageIcon(getClass().getResource("edit-icon.png")));

        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Rubrica.this.setVisible(false);
                PersonaForm personaForm = new PersonaForm("Edit", index);
                personaForm.setVisible(true);
                dispose();

            }
        });


        JButton buttonDelete = new JButton(new ImageIcon(getClass().getResource("Actions-button-cancel-icon.png")));

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    RubricaDB rubricaDB = new RubricaDB();
                    rubricaDB.deletePersonaDB(index, tbRubrica);
                    model.removeRow(tbRubrica.getSelectedRow());


            }
        });

        toolBar.add(buttonAdd);
        toolBar.add(buttonEdit);
        toolBar.add(buttonDelete);

        tbRubrica.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
               index = Integer.parseInt(tbRubrica.getValueAt(tbRubrica.getSelectedRow(), 0).toString());
            }


        });

        return panel;

    }

}
