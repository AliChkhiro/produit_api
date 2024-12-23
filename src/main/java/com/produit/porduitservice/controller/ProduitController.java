package com.produit.porduitservice.controller;

import com.produit.porduitservice.model.Produit;
import com.produit.porduitservice.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;


    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit craeteProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }

    @GetMapping("{id}")
    public Produit getProduitById(@PathVariable long id) {
        return produitService.getProduitById(id);
    }

    @DeleteMapping("{id}")
    public String deleteProduitById(@PathVariable("id") long idProduit){
        return produitService.deleteProduitById(idProduit);
    }

    @PutMapping("{id}")
    public Produit editProduit(@PathVariable long id, @RequestBody Produit produit){
        return produitService.editProduit(id, produit);
    }
}
