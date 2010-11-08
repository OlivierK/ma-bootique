package fr.bootique;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ejbBootique.AccesCatalogueBeanRemote;
import fr.modelBootique.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getListeProduits(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
	protected void getListeProduits(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Produit> list = null;
		try{
			InitialContext jndi = new InitialContext();
			AccesCatalogueBeanRemote remote=(AccesCatalogueBeanRemote)jndi.lookup("BootiqueJNDI/remote");
			list=remote.getListProduits(Integer.parseInt(request.getParameter("cat")));
		}
		
			catch(Exception e){
			e.printStackTrace();
		}
			
		
		request.setAttribute("cat",request.getParameter("nomCat"));
		request.setAttribute("listeProd", list);
		request.getRequestDispatcher("Produit.jsp").forward(request, response);
	}

}
