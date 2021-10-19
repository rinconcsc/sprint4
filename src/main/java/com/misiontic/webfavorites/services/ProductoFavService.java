package com.misiontic.webfavorites.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.webfavorites.entity.ProductosFav;
import com.misiontic.webfavorites.repository.ProductoFavRepository;


@Service
public class ProductoFavService {
	
	@Autowired
	private ProductoFavRepository productofavRepo;
	
	public List<ProductosFav> findAll() {
		List<ProductosFav> productos = productofavRepo.findAll();
		return productos;
	}

	public ProductosFav fingById(Long productoId) {
		ProductosFav producto = productofavRepo.findById(productoId).orElseThrow(() -> new RuntimeException("El usuario no existe"));
		return producto;
	}

	@Transactional
	public void delete(Long userId) {
		ProductosFav producto = productofavRepo.findById(userId).orElseThrow(() -> new RuntimeException("El usuario no existe"));

		productofavRepo.delete(producto);
	}

	@Transactional
	public ProductosFav save(ProductosFav producto) {

		if (producto.getIdProducto() == null) {
			ProductosFav newProduct = productofavRepo.save(producto);
			return newProduct;
		}

		ProductosFav updateProduct = productofavRepo.findById(producto.getIdProducto())
				.orElseThrow(() -> new RuntimeException("El usuario no existe."));
		
		updateProduct.setNameProducto(producto.getNameProducto());
		updateProduct.setDescripcion(producto.getDescripcion());
		updateProduct.setIdUser(producto.getIdUser());
		
		productofavRepo.save(updateProduct);
		
		return updateProduct;
	}

}
