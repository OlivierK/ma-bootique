package fr.ejbBootique;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.modelBootique.Categorie;
import fr.modelBootique.Produit;

/**
 * Session Bean implementation class AccesCatalogueBean
 */
@Stateless(name="BootiqueJNDI")
public class AccesCatalogueBean implements AccesCatalogueBeanRemote, AccesCatalogueBeanLocal {

	

    /**
     * Default constructor. 
     */
    public AccesCatalogueBean() {
        // TODO Auto-generated constructor stub
    }
  
    public ArrayList<Categorie> getListCategories(){
    	ArrayList<Categorie> liste = new ArrayList<Categorie>();
		try{
			InitialContext jndi = new InitialContext();
			//Recherche nom datasource dans l'annuaire jndi
			DataSource ds = (DataSource) jndi.lookup("java:BoutiqueDS");
			//J'ouvre la connection Ã  la base
    			Connection c = (Connection) ds.getConnection();
    			   			
    			PreparedStatement requete = c.prepareStatement("select * from categories");
    			ResultSet r = requete.executeQuery();
    			r.beforeFirst();
    			
    			while(r.next()){
    				int id = r.getInt("id_categories");
    				String libelle = r.getString("libelle");
    				Categorie cat = new Categorie();
    				cat.setId(id);
    				cat.setLibelle(libelle);
    				liste.add(cat);
    			}  			
    			r.close();
    			c.close();    			
    		}
    		catch(NamingException e){
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	return liste;
    }
    
    public ArrayList<Produit> getListProduits(int cat){
    	ArrayList<Produit> liste = new ArrayList<Produit>();
		try{
			InitialContext jndi = new InitialContext();
			//Recherche nom datasource dans l'annuaire jndi
			DataSource ds = (DataSource) jndi.lookup("java:BoutiqueDS");
			//J'ouvre la connection Ã  la base
    			Connection c = (Connection) ds.getConnection();
    			
    			PreparedStatement requete = c.prepareStatement("select * from produits p where p.fk_categorie="+cat);
    			ResultSet r = requete.executeQuery();
    			r.beforeFirst();
    			
    			while(r.next()){
    				int id = r.getInt("pk_produit");
    				String libelle = r.getString("libelle");
    				float prix=r.getFloat("prix");
    				Produit prod = new Produit();
    				prod.setId(id);
    				prod.setLibelle(libelle);
    				prod.setCategorie(cat);
    				prod.setPrix(prix);
    				liste.add(prod);
    			}  			
    			r.close();
    			c.close();    			
    		}
    		catch(NamingException e){
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	return liste;
    }


}
