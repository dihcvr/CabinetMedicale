/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;


import java.util.List;

public interface ClientDAO {

	public List<Client> getAllClient();
	public Client getClient(int id);
	public void addClient(Client client);
	public void updateClient(Client client);
	public void deleteClient(Client client);
	
}
