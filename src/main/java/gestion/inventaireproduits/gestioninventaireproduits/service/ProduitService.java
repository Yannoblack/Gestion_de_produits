package gestion.inventaireproduits.gestioninventaireproduits.service;

import gestion.inventaireproduits.gestioninventaireproduits.model.entity.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    Produit creerProduit(Produit produit);

    List<Produit> listerTousLesProduits();

    Optional<Produit> trouverProduitParId(Long id);

    Produit mettreAJourProduit(Long id, Produit produitDetails);

    void supprimerProduit(Long id);

    List<Produit> trouverProduitsAvecStockBas(Integer seuilStock);
}