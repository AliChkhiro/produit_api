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

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit craeteProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);

    }
}
