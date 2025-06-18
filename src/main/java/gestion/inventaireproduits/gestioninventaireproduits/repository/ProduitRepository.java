package gestion.inventaireproduits.gestioninventaireproduits.repository;

import gestion.inventaireproduits.gestioninventaireproduits.model.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> { // Correction ici

    // Méthode pour trouver les produits dont la quantité en stock est inférieure à un certain seuil
    // Utile pour la fonctionnalité "Alerte sur stock bas"
    List<Produit> findByQuantiteEnStockLessThan(Integer quantite); // Correction ici

    // Vous pouvez ajouter d'autres méthodes de requête personnalisées ici si nécessaire.
    // Par exemple, pour trouver un produit par son nom :
    Optional<Produit> findByNom(String nom); // Correction ici
}
