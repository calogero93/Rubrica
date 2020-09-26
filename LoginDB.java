import java.sql.PreparedStatement;

import java.sql.SQLException;


public class LoginDB extends ConnectionDB {

    public Utente verificaUtente(String user, String pass){

        this.apriConnessione();

        Utente utente = new Utente();

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT 1 FROM login WHERE username=? AND password=?");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                this.chiudiConnessione();
                return utente;
            }
            else{
                return null;
            }

        } catch (SQLException e) {
            return null;
        }

    }

    public void registraUtente(String user, String pass){

        this.apriConnessione();

        Utente utente = new Utente();

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO login (username, password) VALUES(?,?)");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.executeUpdate();



        } catch (SQLException e) {

        }

    }


}
