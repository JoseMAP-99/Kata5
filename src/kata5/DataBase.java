package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    
    private final String URL;
    private Connection connection = null;

    public DataBase(String URL) {
        this.URL = URL;
    }

    public void open() {
        try {
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Base de datos abierta");
        } catch (SQLException ex) {
            System.out.println("ERROR DATABASE::open (SQLException) " + ex.getMessage());
        }
    }

    public void close() {
        try {
            if(this.connection != null){
                connection.close();
                System.out.println("Base de datos cerrada");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DATABASE::close (SQLException) " + ex.getMessage());
        }
    }

    void selectPEOPLE() {
        String SQL = "SELECT * FROM PEOPLE";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID\tNAME\tSURNAME\tDEPARTMENT");
            while(resultset.next()){
                System.out.println(resultset.getInt("ID") + "\t" + 
                        resultset.getString("NAME") + "\t" + 
                        resultset.getString("SURNAME") + "\t" + 
                        resultset.getString("DEPARTMENT"));
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR DATABASE::select (SQLException) " + e.getMessage());
        }
    }   
}
