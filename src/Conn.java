import java.sql.*;

public class Conn {
    Connection connection;
    Statement statement;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/gestion_bank","root","");            
            statement = connection.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
