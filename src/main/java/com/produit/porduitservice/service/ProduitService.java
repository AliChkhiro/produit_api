package com.produit.porduitservice.service;

import com.produit.porduitservice.model.Produit;
import com.produit.porduitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
