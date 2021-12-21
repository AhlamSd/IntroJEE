package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Livre;


public class LivreDaoImpl implements LivreDao {

	private DaoFactory daoFactory;

	public LivreDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	//--------------------Ajouter--------------------------------//
	
	public void ajouter(Livre livre) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO livre(isbn, titre, auteur, prix, nbrpages, annee_edition) VALUES(?, ?, ?, ?, ?, ?);");
		    
			preparedStatement.setString(1, livre.getIsbn());
			preparedStatement.setString(2, livre.getTitre());
			preparedStatement.setString(3, livre.getAuteur());
			preparedStatement.setFloat(4, livre.getPrix());
			preparedStatement.setInt(5, livre.getNbrpages());
			preparedStatement.setInt(6, livre.getAnnee_edition());
			
		   preparedStatement.executeUpdate();
		   
		} catch(SQLException e) {
			//throw new DaoException(e);
			throw new DaoException("Erreur dans l'insertion");
		}
		
		
	}

	//--------------------Afficher le tout--------------------------------//
	public List<Livre> selectAllLivres() {
		
		List<Livre> listLivre = new ArrayList<Livre>();
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
        
        String sql = "SELECT * FROM livre";
        
        String isbn, titre, auteur;
    	int nbrpages, annee_edition;
    	float prix;
         
        try {
        	
        	connexion = daoFactory.getConnection();
        	statement = connexion.createStatement();
        	resultat = statement.executeQuery(sql);
        	
        	while (resultat.next()) {
                
                isbn = resultat.getString("isbn");
                titre = resultat.getString("titre");
                auteur = resultat.getString("auteur");
                prix = resultat.getFloat("prix");
                nbrpages = resultat.getInt("nbrpages");
                annee_edition = resultat.getInt("annee_edition");
                
                Livre livre = new Livre();
                livre.setIsbn(isbn);
                livre.setTitre(titre);
                livre.setAuteur(auteur);
                livre.setPrix(prix);
                livre.setNbrpages(nbrpages);
                livre.setAnnee_edition(annee_edition);
              
                listLivre.add(livre);
                //System.out.println("isbn : " +isbn+ " titre : " +titre+ "auteur : " +auteur+ " prix : " +prix+ " nbrpages : " +nbrpages+ " year : " +annee_edition+ "\n");
            }
        	
        	
            resultat.close();
            statement.close();
            
            return listLivre;
            
        } catch (SQLException e) {
        	throw new DaoException("Erreur dans l'affichage de la liste des livres");
        }
		
	}
	
	//----------------------Supprimer--------------------------------//
	
      public boolean supprimer(Livre livre) throws SQLException {
    	  
    	     Connection connexion = null;
  		     PreparedStatement preparedStatement = null;
  		    
  		     String sql = "DELETE FROM livre where isbn = ?";
  		
  		 try {
  			connexion = daoFactory.getConnection();
  			preparedStatement = connexion.prepareStatement(sql);
  			
  			preparedStatement.setString(1, livre.getIsbn());
   
  			
    	        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
    	        preparedStatement.close();
    	        //disconnect();
    	        
    	        return rowDeleted;     
    	    } catch (SQLException e) {
            	throw new DaoException("Erreur dans la suppression des livres");
    	    }
      }
      
  	//------------------------Modifier--------------------------------//
      
      public boolean modifier(Livre livre) throws SQLException {
    	  
          String sql = "UPDATE livre SET isbn = ? titre = ?, auteur = ?, prix = ?, nbrpages = ?, annee_esition = ?";
          sql += " WHERE isbn = ?";
          
          Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		    
		     
		
		 try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(sql);
			
			preparedStatement.setString(1, livre.getIsbn());
			preparedStatement.setString(2, livre.getTitre());
			preparedStatement.setString(3, livre.getAuteur());
			preparedStatement.setFloat(4, livre.getPrix());
			preparedStatement.setInt(5, livre.getNbrpages());
			preparedStatement.setInt(6, livre.getAnnee_edition());
			
			boolean rowUpdated = preparedStatement.executeUpdate() > 0;
			
          preparedStatement.close();
          //disconnect();
          return rowUpdated;     
          
      } catch (SQLException e) {
      	throw new DaoException("Erreur dans la modification des livres");
	    }
      }
      
    //------------------------Select by ISBN--------------------------------//
              
      public Livre getBook(String isbn) throws SQLException {
    	  
    	  Livre livre = null;
          Connection connexion;
  		  Statement statement;
  		  ResultSet resultat;
          
          String sql = "SELECT * FROM livre WHERE isbn = '"+isbn+"'";
          
          String titre, auteur;
      	  int nbrpages, annee_edition;
      	  float prix;
          
try {
        	
        	 connexion = daoFactory.getConnection();
        	 statement = connexion.createStatement();
        	 resultat = statement.executeQuery(sql);
        	
        	
     	   
        	
        	while (resultat.next()) {
                
        		isbn = resultat.getString("isbn");
                titre = resultat.getString("titre");
                auteur = resultat.getString("auteur");
                prix = resultat.getFloat("prix");
                nbrpages = resultat.getInt("nbrpages");
                annee_edition = resultat.getInt("annee_edition");
                
                
                livre = new Livre(isbn, titre, auteur, prix, nbrpages, annee_edition);
              
                
               //System.out.println("isbn : " +isbn+ " titre : " +titre+ " auteur : " +auteur+ " prix : " +prix+ " nbrpages : " +nbrpages+ " year : " +annee_edition+ "\n");
            }
        	
        	
            resultat.close();
            statement.close();
            
            return livre;
            
        } catch (SQLException e) {
        	throw new DaoException("Erreur dans la sélection des livres by isbn");
        }

          
		
      }
		
	/*
	public static void main(String[] args) throws Exception {
		
		DaoFactory daoFactory = DaoFactory.getInstance() ;
		
		LivreDaoImpl l = new LivreDaoImpl(daoFactory);
		
		//l.selectAllLivres();
		
		l.getBook("1231");
		
		/*
		String isbn = "5678", titre="E", auteur="B";
		int nbrpages=12, annee_edition=2000;
		float prix=161;
		Livre liv(isbn,titre, auteur, nbrpages, annee_edition, prix);
		l.supprimer(liv);
		
		
	} */
		

}	
	

	


