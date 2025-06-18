package gestion.inventaireproduits.gestioninventaireproduits.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal; // Préférable pour les prix

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(nullable = false)
    private BigDecimal prix; // Utiliser BigDecimal pour la précision monétaire

    @Column(name = "quantite_en_stock", nullable = false)
    private Integer quantiteEnStock;

    // Optionnel : pour la fonctionnalité d'alerte sur stock bas,
    // on pourrait ajouter un seuil directement ici ou le gérer au niveau service.
    // Pour l'instant, gardons l'entité simple.

    // Supprimez la classe interne Produit qui était ici
}