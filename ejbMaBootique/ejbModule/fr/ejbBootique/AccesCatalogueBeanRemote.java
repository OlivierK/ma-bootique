package fr.ejbBootique;
import java.util.ArrayList;

import javax.ejb.Remote;

import fr.modelBootique.Categorie;
import fr.modelBootique.Produit;

@Remote
public interface AccesCatalogueBeanRemote {
	public ArrayList<Categorie> getListCategories();	
	public ArrayList<Produit> getListProduits(int cat);
}
