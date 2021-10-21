package com.misiontic.webfavorites.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.webfavorites.entity.ProductoFav;
import com.misiontic.webfavorites.repository.ProductoFavRepository;


@Service
public class ProductoFavService {

	@Autowired
	private ProductoFavRepository productofavRepo;


	public List<ProductoFav> findAll() {
		List<ProductoFav> productos = productofavRepo.findAll();
		return productos;
	}

	public ProductoFav fingById(Long productoId) {
		ProductoFav producto = productofavRepo.findById(productoId).orElseThrow(() -> new RuntimeException("El usuario no existe"));
		return producto;
	}

	@Transactional
	public void delete(Long userId) {
		ProductoFav producto = productofavRepo.findById(userId).orElseThrow(() -> new RuntimeException("El usuario no existe"));

		productofavRepo.delete(producto);
	}

	@Transactional
	public ProductoFav save(ProductoFav producto) {

		if (producto.getIdProducto() == null) {
			ProductoFav newProduct = productofavRepo.save(producto);
			return newProduct;
		}

		ProductoFav updateProduct = productofavRepo.findById(producto.getIdProducto())
				.orElseThrow(() -> new RuntimeException("El usuario no existe."));

		updateProduct.setNameProducto(producto.getNameProducto());
		updateProduct.setDescripcion(producto.getDescripcion());


		productofavRepo.save(updateProduct);

		return updateProduct;
	}

	

	
	
}
