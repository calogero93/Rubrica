import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class RubricaDB extends ConnectionDB{

    public DefaultTableModel mostraRubrica() {

        DefaultTableModel model = new DefaultTableModel();
        connection = this.apriConnessione();

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT *" +
                    " FROM persona");

            model.addColumn("ID");
            model.addColumn("Nome");
            model.addColumn("Cognome");
            model.addColumn("Indirizzo");
            model.addColumn("Telefono");
            model.addColumn("Età");



            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                model.addRow(new Object[]{resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("cognome"),resultSet.getString("indirizzo"),resultSet.getString("telefono"),resultSet.getInt("eta")});
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.chiudiConnessione();
        return model;



    }


    public Persona getPersonaDB(int id) {

        connection = this.apriConnessione();

        Persona persona = new Persona();

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT *" +
                    " FROM persona WHERE id=?");

            preparedStatement.setInt(1, id);


            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            persona.setNome(resultSet.getString("nome"));
            persona.setCognome(resultSet.getString("cognome"));
            persona.setIndirizzo(resultSet.getString("indirizzo"));
            persona.setTelefono(resultSet.getString("telefono"));
            persona.setEta(resultSet.getInt("eta"));


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.chiudiConnessione();

        return persona;

    }


    public void insertPersonaDB(Persona persona) {

        connection = this.apriConnessione();

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO persona (nome, cognome, indirizzo, telefono, eta)" +
                    " VALUES(?,?,?,?,?)");

            preparedStatement.setString(1, persona.getNome());
            preparedStatement.setString(2, persona.getCognome());
            preparedStatement.setString(3, persona.getIndirizzo());
            preparedStatement.setString(4, persona.getTelefono());
            preparedStatement.setInt(5, persona.getEta());


            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.chiudiConnessione();



    }

    public void updatePersonaDB(int id, Persona persona) {

        connection = this.apriConnessione();

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement("UPDATE persona SET nome=?, cognome=?, indirizzo=?, telefono=?, eta=?" +
                    " WHERE id=?");

            preparedStatement.setString(1, persona.getNome());
            preparedStatement.setString(2, persona.getCognome());
            preparedStatement.setString(3, persona.getIndirizzo());
            preparedStatement.setString(4, persona.getTelefono());
            preparedStatement.setInt(5, persona.getEta());
            preparedStatement.setInt(6, id);


            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.chiudiConnessione();



    }


    public void deletePersonaDB(int id, JTable table) {



        connection = this.apriConnessione();

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement("DELETE FROM persona " +
                    " WHERE id=?");


            preparedStatement.setInt(1, id);


            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.chiudiConnessione();



    }

}
