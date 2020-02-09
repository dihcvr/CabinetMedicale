/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			connection=DriverManager.getConnection("jdbc:mysql://localhost/micro_prj","root","");   
		}
		catch(ClassNotFoundException e){ 
			//System.out.println("Problème au niveau du pilote");
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println("Problème au niveau de base ou accès au données ");
		}
	}
	
	public static Connection getConnect() {
		return connection;
	}

}
