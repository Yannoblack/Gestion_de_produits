package gestion.inventaireproduits.gestioninventaireproduits.service.impl;

import gestion.inventaireproduits.gestioninventaireproduits.model.entity.Produit;
import gestion.inventaireproduits.gestioninventaireproduits.repository.ProduitRepository;
import gestion.inventaireproduits.gestioninventaireproduits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    @Transactional
    public Produit creerProduit(Produit produit) { // Correction ici
        // On pourrait ajouter des validations ici avant de sauvegarder
        // Par exemple, vérifier si un produit avec le même nom existe déjà
        return produitRepository.save(produit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produit> listerTousLesProduits() { // Correction ici
        return produitRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Produit> trouverProduitParId(Long id) { // Correction ici
        return produitRepository.findById(id);
    }

    @Override
    @Transactional
    public Produit mettreAJourProduit(Long id, Produit produitDetails) { // Corrections ici
        Produit produitExistant = produitRepository.findById(id) // Correction ici
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + id)); // Idéalement, une exception personnalisée

        produitExistant.setNom(produitDetails.getNom());
        produitExistant.setPrix(produitDetails.getPrix());
        produitExistant.setQuantiteEnStock(produitDetails.getQuantiteEnStock());
        // Autres champs à mettre à jour si nécessaire

        return produitRepository.save(produitExistant);
    }

    @Override
    @Transactional
    public void supprimerProduit(Long id) {
        if (!produitRepository.existsById(id)) {
            throw new RuntimeException("Produit non trouvé avec l'id : " + id); // Idéalement, une exception personnalisée
        }
        produitRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produit> trouverProduitsAvecStockBas(Integer seuilStock) { // Correction ici
        if (seuilStock == null || seuilStock < 0) {
            // Gérer le cas d'un seuil invalide, par exemple retourner une liste vide ou lever une exception
            throw new IllegalArgumentException("Le seuil de stock ne peut pas être négatif ou nul.");
        }
        return produitRepository.findByQuantiteEnStockLessThan(seuilStock);
    }
}