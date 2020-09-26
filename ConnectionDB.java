import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class ConnectionDB {


    public Connection connection = null;
    public Statement stmt = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;



    public Connection apriConnessione(){
        new GestioneDriver().registraDriver();



        try {
            //FileReader reader=new FileReader("credenziali.properties");

            Properties p= new Properties();
            File jarPath=new File(ConnectionDB.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String propertiesPath=jarPath.getParentFile().getAbsolutePath();
            System.out.println(" propertiesPath-"+propertiesPath);
            p.load(new FileInputStream(propertiesPath+"/credenziali.properties"));
            //p.load(ConnectionDB.class.getResourceAsStream("./credenziali.properties"));

            connection = DriverManager
                    .getConnection("jdbc:mysql://"+p.getProperty("ip")+":"+p.getProperty("porta")+"/rubrica?useTimezone=true&serverTimezone=UTC"
                            , p.getProperty("username"), p.getProperty("password"));
            //connection = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void chiudiConnessione(){

        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(stmt != null){

            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if(resultSet != null){

            try {
                resultSet.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }




}


