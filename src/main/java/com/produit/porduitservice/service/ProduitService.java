package com.produit.porduitservice.service;

import com.produit.porduitservice.model.Produit;
import com.produit.porduitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository produitRepository;


    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Desole produit inexistant");
        }
        return optionalProduit.get();
    }

    public String deleteProduitById(long idProduit) {
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);
        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Suppression impossible: PRODUIT INEXISTANT.");
        }
        produitRepository.delete(optionalProduit.get());
        return "Produit supprimé avec succès !";
    }

    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Modification impossible !");
        }
        Produit produitAModifier = optionalProduit.get();
        produitAModifier.setName(produit.getName());
        produitAModifier.setPrice(produit.getPrice());
        return produitRepository.save(produitAModifier);
    }
}
