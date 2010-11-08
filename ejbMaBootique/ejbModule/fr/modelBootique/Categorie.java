package fr.modelBootique;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="boutique", name="categories")
public class Categorie implements Serializable {
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -6915192636525886408L;
	/**
	 * 
	 */
	private int id;
	
	@Id
	@GeneratedValue
	@Column(name="id_categories")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String aLibelle;
	
	@Column(name="libelle")
	public String getLibelle(){
		return aLibelle;
	}
	
	public void setLibelle(String pLibelle){
		aLibelle=pLibelle;
	}
	

}