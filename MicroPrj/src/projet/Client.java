
package projet;

public class Client {
	private int id;
	private String titre;
	private String nom;
	private String prenom;
	private int version;
	
	public Client() {}
	public Client(int version,String titre,String nom, String prenom) 
	{
		this.titre=new String(titre);
		this.nom=new String(nom);
		this.prenom =new String(prenom);
		this.version=version;
	}
	public Client(int id,int version,String titre,String nom,String prenom) 
	{
		this.id=id;
		this.titre=new String(titre);
		this.nom=new String(nom);
		this.prenom =new String(prenom);
		this.version=version;
	}
	
	public Client(Client client)
	{
		setId(client.getId());
		setTitre(client.getTitre());
		setNom(client.getNom());
		setPrenom(client.getPrenom());
		setVersion(client.getVersion());
	}
	
	public int getId() { return this.id;}
	public void setId(int id) { this.id=id;}
	
	public String getTitre() { return this.titre;}
	public void setTitre(String titre) { this.titre=titre;}
	
	public String getNom() { return this.nom;}
	public void setNom(String nom) { this.nom=nom;}
	
	public String getPrenom() { return this.prenom;}
	public void setPrenom(String prenom) { this.prenom=prenom;}
	
	public int getVersion() { return this.version;}
	public void setVersion(int version) { this.version=version;}

	
	public String toString() 
	{
		String str="\n-Id Client : "+id+"\n-Titre : "+titre+"\n-Prenom : "+"\n-Nom : "+nom+"\n-Prenom : "+prenom+"\n-Version : "+version;
		return str;
	}

}