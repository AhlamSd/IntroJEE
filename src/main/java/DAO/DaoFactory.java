package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {

	//private static final String fichier_prop = "/Biblio/src/main/java/DAO/dao.properties";
	private static final String prop_url     = "jdbc:mysql://localhost:3306/bibliotheque";
	private static final String prop_driver  = "com.mysql.cj.jdbc.Driver";
	private static final String prop_username= "root";
	
	private String url;
	private String username;
	
	public DaoFactory(String url, String username) {
		super();
		this.url = url;
		this.username = username;
	}
	
	public static DaoFactory getInstance() throws DaoConfigurationException {
		 //Properties properties = new Properties();
		 
		// String url;
		// String driver;
		// String username;
		 
		 //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		 //InputStream fichierProperties = classLoader.getResourceAsStream(fichier_prop);
		 
		 /*if (fichierProperties == null) {
			 throw new DaoConfigurationException("le fichier properties " +fichier_prop+ "est invalide");
			 
		 }
		 
		 try {
			 properties.load(fichierProperties);
			 url = properties.getProperty(prop_url);
			 driver = properties.getProperty(prop_driver);
			 username = properties.getProperty(prop_username);
			 
		 } catch (IOException e) {
			 throw new DaoConfigurationException("Impossible de charger le fichier properties");
		 }
		 */
		 try {
			 //Class.forName(driver);
			 Class.forName(prop_driver);
			 
			 
		 } catch (ClassNotFoundException e) {
			 throw new DaoConfigurationException("Le driver est introuvable");
		 }
		 
		 
		 DaoFactory instance = new DaoFactory(prop_url, prop_username);
		 return instance;
		 
	}
	
	// Méthode chargé de fournir une connexion à la BD
	 static Connection getConnection() throws SQLException {
		Connection conn= null;
		try {
	    
		conn = DriverManager.getConnection(prop_url, prop_username, "");
		}catch(SQLException e) {
			System.out.println("Erreur de connexion à la BD");
		}
		return conn;
		
		
		
	}
	
	// Récupération de l'implémentation des différents DAO
	
	
	public LivreDao getLivreDao() {
		return new LivreDaoImpl(this);
		
	}
	
	
	
}
