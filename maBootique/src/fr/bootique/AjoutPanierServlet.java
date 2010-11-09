package fr.bootique;

import java.io.IOException;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;


import fr.ejbBootique.AccesCatalogueBeanRemote;
import fr.modelBootique.Produit;

/**
 * Servlet implementation class AjoutPanierServlet
 */
public class AjoutPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutPanierServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajouterProduit(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void ajouterProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idProd=Integer.parseInt(request.getParameter("idProd"));
		Produit aProd=null;
		try{
			InitialContext jndi = new InitialContext();
			AccesCatalogueBeanRemote remote=(AccesCatalogueBeanRemote)jndi.lookup("BootiqueJNDI/remote");
			aProd=remote.getProduit(idProd);
		}

		catch(Exception e){
			e.printStackTrace();
		}
		HttpSession session=request.getSession(true);
		Vector<Produit> list=(Vector<Produit>) session.getAttribute("panier");
		if(list==null)
			list=new Vector<Produit>();
		list.add(aProd);
		session.setAttribute("panier", list);
		request.getRequestDispatcher("Panier.jsp").forward(request, response);
	}
}
