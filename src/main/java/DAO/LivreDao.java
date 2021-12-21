package DAO;

import java.util.*;

import Beans.Livre;

public interface LivreDao {

	void ajouter(Livre livre);
	
	List<Livre> selectAllLivres();
		
	
	
}

