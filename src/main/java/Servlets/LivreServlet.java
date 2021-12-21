package Servlets;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import Beans.Livre;
import DAO.DaoException;
import DAO.DaoFactory;
import DAO.LivreDao;
import DAO.LivreDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")

public class LivreServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LivreDao livreDao;
	
	private LivreDaoImpl livreDaoImpl;
	
	
	public void init() throws ServletException {
		DaoFactory daofactory = DaoFactory.getInstance();
		this.livreDao = daofactory.getLivreDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
	
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	 
	        switch (action) {
			case "/new":
				try {
			    showNewForm(request, response);
				} catch (Exception e) {
					throw new DaoException("Erreur dans /new");
				}
			    break;
			case "/insert":
				try {
			    insertBook(request, response);
				}catch (Exception e) {
					throw new DaoException("Erreur dans /insert ");
				}
			    break;
			case "/delete":
				try {
			    deleteBook(request, response);
				} catch (Exception e) {
					throw new DaoException("Erreur dans /delete ");
				}
			    break;
			case "/edit":
				try {
			    showEditForm(request, response);
				} catch (Exception e) {
					throw new DaoException("Erreur dans /edit ");
				}
			    break;
			case "/update":
				try {
			     updateBook(request, response);
				} catch (Exception e) {
					throw new DaoException("Erreur dans /update ");
				}
			    break;
			default:
				try {
			    listLivre(request, response);
				} catch (Exception e) {
					throw new DaoException("Erreur dans /list ");
				}
			    break;
			}
	    }
	    
	 
	 private void listLivre(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException, DaoException {
	    	
	        List<Livre> listLivre = livreDao.selectAllLivres();
	       
	        //request.setAttribute("livres", livreDao.selectAllLivres());
	        request.setAttribute("listLivre", listLivre);
	        //RequestDispatcher dispatcher = request.getRequestDispatcher("LivreListe.jsp");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("LivreListe.jsp");
	        dispatcher.forward(request, response);
	        
	        System.out.println("C'est bien lister");
	        
	    }

	    private void insertBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	
	    	Livre livre = new Livre();
	    	livre.setIsbn(request.getParameter("isbn"));
			livre.setTitre(request.getParameter("titre"));
			livre.setAuteur(request.getParameter("auteur"));
			livre.setPrix(Float.parseFloat(request.getParameter("prix")));
			livre.setNbrpages(Integer.parseInt(request.getParameter("nbrpages")));
			//int nbrpages = Integer.parseInt(request.getParameter("id"));
			livre.setAnnee_edition(Integer.parseInt(request.getParameter("annee_edition")));
			livreDao.ajouter(livre);
			
			response.sendRedirect("list");
	        /*
	    	String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        float price = Float.parseFloat(request.getParameter("price"));
	 
	        Book newBook = new Book(title, author, price);
	        bookDAO.insertBook(newBook);
	        response.sendRedirect("list");
	        */
	        
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/Biblio/WebContent/LivreListe.jsp");
	        //dispatcher.forward(request, response);
			
			
			//request.setAttribute("livres", LivreDao.lister());
	        
	    }
	 
	    
	 
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("LivreForm.jsp");
	        dispatcher.forward(request, response);
	    }
	    
	    
	      private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        String isbn = request.getParameter("isbn");
	        Livre livrepresent = livreDaoImpl.getBook(isbn);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("LivreForm.jsp");
	        request.setAttribute("livre", livrepresent);
	        dispatcher.forward(request, response);
	 
	    }
	      
	 
	    
	    private void updateBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	    	
	    	String isbn = request.getParameter("isbn");
	        String titre = request.getParameter("titre");
	        String auteur = request.getParameter("auteur");
	        float prix = Float.parseFloat(request.getParameter("prix"));
	        int nbrpages =Integer.parseInt(request.getParameter("nbrpages"));
	        int annee_edition =Integer.parseInt(request.getParameter("annee_edition"));
	        
	        Livre livre = new Livre(isbn, titre, auteur, prix, nbrpages, annee_edition);
	        livreDaoImpl.modifier(livre);
	        
	        response.sendRedirect("list");
	    }  
	 
	   
	    
	    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {

	    	String isbn = request.getParameter("isbn");
	    	Livre livre = new Livre(isbn);
	        livreDaoImpl.supprimer(livre);
	        
	        response.sendRedirect("list");
	 
	    }
	    
	    
	} 
	
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  request.setAttribute("livres", livreDao.lister());
	  this.getServletContext().getRequestDispatcher("/Biblio/WebContent/LivreListe.jsp").forward(request, response);
	  
		
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Livre livre = new Livre();
		livre.setIsbn(request.getParameter("isbn"));
		livre.setTitre(request.getParameter("titre"));
		livre.setAuteur(request.getParameter("auteur"));
		livre.setPrix(Float.parseFloat(request.getParameter("prix")));
		livre.setNbrpages(Integer.parseInt(request.getParameter("nbrpages")));
		//int nbrpages = Integer.parseInt(request.getParameter("id"));
		livre.setAnnee_edition(Integer.parseInt(request.getParameter("annee_edition")));
		
		livreDao.ajouter(livre);
		
		request.setAttribute("livres", livreDao.lister());
		
		this.getServletContext().getRequestDispatcher("/Biblio/WebContent/LivreListe.jsp").forward(request, response);
		
	}
	*/
	/*
	 * private void listBook(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
    List<Book> listBook = bookDAO.listAllBooks();
    request.setAttribute("listBook", listBook);
    RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
    dispatcher.forward(request, response);
} 
	 * 
	 */

