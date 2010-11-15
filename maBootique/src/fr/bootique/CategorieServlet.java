package fr.bootique;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ejbBootique.AccesCatalogueBeanRemote;
import fr.modelBootique.Categorie;

/**
 * Servlet implementation class CategorieServlet
 */
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getListeCategories(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
	protected void getListeCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ArrayList<Categorie> list = null;
			try{
				InitialContext jndi = new InitialContext();
				AccesCatalogueBeanRemote remote=(AccesCatalogueBeanRemote)jndi.lookup("MaBootiqueEAR/BootiqueJNDI/remote");
				list=remote.getListCategories();
			}
			
				catch(Exception e){
				e.printStackTrace();
			}
			request.setAttribute("listeCat", list);
			request.getRequestDispatcher("Categorie.jsp").forward(request, response);
			
		}
	
	

}
