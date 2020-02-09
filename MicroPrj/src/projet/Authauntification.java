
package projet;

import Exceptions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

class Authauntification {
    Connection con;
    Statement stm;
    ResultSet rst;
    Test d = new Test();
    private String username, password;
    public Authauntification(String username,String password) throws ErrAuth,ErrDriver, Exception{
       
      con=Connect.getConnect();
        
        
        String query="select * from user where username='"+username+"'"
           +"and password='"+password+"'";

        rst=stm.executeQuery(query);
        rst.last();
        int nbrRow=rst.getRow();
        
        if(("admin".equals(username) && "admin".equals(password))|| nbrRow!=0){
            d.setVisible(true) ;   
        }
        else throw ErrAuth(username,password);
        
        
         
    }

    private Exception ErrAuth(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet.");   }
    
}
