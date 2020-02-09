/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientDAOImp implements ClientDAO {
	Connection con;
	
	@Override
	public List<Client> getAllClient(){
	Client client=null;
		List<Client> lc=new ArrayList<>();
		con=Connect.getConnect();
        String req="Select * From Clients";
        try {
            PreparedStatement ps= con.prepareStatement(req);
            ResultSet res=ps.executeQuery();
            while(res.next()) {
            	Client c=new Client(res.getInt("id"),res.getInt("version"),res.getString("titre"),res.getString("nom"),res.getString("prenom"));
            	lc.add(c);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
		return lc;
	}
	
	@Override
	public Client getClient(int id) {
		Client client=null;
		con=Connect.getConnect();
        String req="Select Version, Titre, Nom,Prenom From Clients WHERE Id=?";
        try {
           PreparedStatement ps= con.prepareStatement(req);
            ps.setInt(1,id);
            ResultSet res=ps.executeQuery();
            if(res.next()) {
            	client=new Client(id,res.getInt("version"),res.getString("titre"),res.getString("nom"),res.getString("prenom"));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
		return client;
		
	}
	
	@Override
	public void addClient(Client client) {
		con=Connect.getConnect();
	        String req="INSERT into Clients(Version,Titre,Nom,Prenom) VALUES(?,?,?,?)";
	        try {
	            PreparedStatement ps= con.prepareStatement(req);
	            ps.setInt(1, client.getVersion());
	            ps.setString(2, client.getTitre());
	            ps.setString(3, client.getNom());
	            ps.setString(4, client.getPrenom());
	            int i=ps.executeUpdate();  
	            System.out.println(i+" records inserted");  
	
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}
	@Override
	public void updateClient(Client client) {
		con=Connect.getConnect();
        String req="UPDATE Clients SET Version=?, Titre=? , Nom=?, Prenom=? where Id=?";
        try {
            PreparedStatement ps= con.prepareStatement(req);
            ps.setInt(1, client.getVersion());
            ps.setString(2, client.getTitre());
            ps.setString(3, client.getNom());
            ps.setString(4, client.getPrenom());
            ps.setInt(5, client.getId());
            int i=ps.executeUpdate();  
            System.out.println(i+" records updated");  

        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	@Override
	public void deleteClient(Client client) {
		con=Connect.getConnect();
		String req = "DELETE FROM Clients where Id = ?";
		try {
		    PreparedStatement ps= con.prepareStatement(req);
	        ps.setInt(1, client.getId());
	        int i=ps.executeUpdate();  
            System.out.println(i+" records deleted");  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	}

}
