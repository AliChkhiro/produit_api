package com.produit.porduitservice.repository;

import com.produit.porduitservice.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

}
