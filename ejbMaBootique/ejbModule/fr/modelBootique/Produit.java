package fr.modelBootique;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema="boutique", name="produits")
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1205585966433878239L;
	private int id;
	private int categorie;
	private String libelle;
	private float prix;
	
	@Id
	@GeneratedValue
	@Column(name="pk_produit")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="fk_categorie")
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
	@Column(name="libelle")
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Column(name="prix")
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
}
