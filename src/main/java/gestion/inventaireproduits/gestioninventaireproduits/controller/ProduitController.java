package gestion.inventaireproduits.gestioninventaireproduits.controller;

import gestion.inventaireproduits.gestioninventaireproduits.model.entity.Produit;
import gestion.inventaireproduits.gestioninventaireproduits.service.ProduitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
@Tag(name = "Produits", description = "API pour la gestion des produits en inventaire")
public class ProduitController {

    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @Operation(summary = "Créer un nouveau produit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produit créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping
    public ResponseEntity<Produit> creerProduit(@RequestBody Produit produit) {
        Produit nouveauProduit = produitService.creerProduit(produit);
        return new ResponseEntity<>(nouveauProduit, HttpStatus.CREATED);
    }

    @Operation(summary = "Récupérer la liste de tous les produits")
    @ApiResponse(responseCode = "200", description = "Liste des produits récupérée")
    @GetMapping
    public ResponseEntity<List<Produit>> listerTousLesProduits() {
        List<Produit> produits = produitService.listerTousLesProduits();
        return ResponseEntity.ok(produits);
    }

    @Operation(summary = "Récupérer un produit par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produit trouvé"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Produit> trouverProduitParId(
            @Parameter(description = "ID du produit à récupérer") @PathVariable Long id) {
        return produitService.trouverProduitParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Mettre à jour un produit existant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produit mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Produit> mettreAJourProduit(
            @Parameter(description = "ID du produit à mettre à jour") @PathVariable Long id,
            @RequestBody Produit produitDetails) {
        try {
            Produit produitMisAJour = produitService.mettreAJourProduit(id, produitDetails);
            return ResponseEntity.ok(produitMisAJour);
        } catch (RuntimeException e) { // Attraper l'exception si le produit n'est pas trouvé
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Supprimer un produit par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produit supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProduit(
            @Parameter(description = "ID du produit à supprimer") @PathVariable Long id) {
        try {
            produitService.supprimerProduit(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) { // Attraper l'exception si le produit n'est pas trouvé
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Récupérer les produits avec un stock bas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des produits à stock bas récupérée"),
            @ApiResponse(responseCode = "400", description = "Seuil de stock invalide")
    })
    @GetMapping("/stock-bas")
    public ResponseEntity<List<Produit>> trouverProduitsAvecStockBas(
            @Parameter(description = "Seuil en dessous duquel le stock est considéré comme bas (par défaut : 5)")
            @RequestParam(defaultValue = "5") Integer seuil) {
        try {
            List<Produit> produits = produitService.trouverProduitsAvecStockBas(seuil);
            return ResponseEntity.ok(produits);
        } catch (IllegalArgumentException e) {
            // Vous pourriez vouloir retourner un message d'erreur plus spécifique ici
            return ResponseEntity.badRequest().build();
        }
    }
}