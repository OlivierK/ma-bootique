package fr.ejbBootique;
import java.util.ArrayList;

import javax.ejb.Local;

import fr.modelBootique.Categorie;
import fr.modelBootique.Produit;

@Local
public interface AccesCatalogueBeanLocal {
	public ArrayList<Categorie> getListCategories();	
	public ArrayList<Produit> getListProduits(int cat);
	public Produit getProduit(int idProd);
}
