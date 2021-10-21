package com.misiontic.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.webfavorites.entity.ProductoFav;

@Repository
public interface ProductoFavRepository extends JpaRepository<ProductoFav, Long>{

}
