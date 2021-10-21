package com.misiontic.webfavorites.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.webfavorites.dtos.ProductosFavDTO;
import com.misiontic.webfavorites.entity.ProductoFav;
import com.misiontic.webfavorites.services.ProductoFavService;

@RestController
public class ProductofavController {

	@Autowired
	private ProductoFavService productoFavService;

	@GetMapping(value = "/producto")
	public ResponseEntity<List<ProductosFavDTO>> findAll() {
		List<ProductoFav> productos= productoFavService.findAll();

		List<ProductosFavDTO> productosDto = productos.stream().map(producto -> {
			return ProductosFavDTO.builder()
					.idProducto(producto.getIdProducto())
					.nameProducto(producto.getNameProducto())
					.descripcion(producto.getDescripcion())
					.build();
		}).collect(Collectors.toList());

		return new ResponseEntity<>(productosDto, HttpStatus.OK);

	}

	@GetMapping(value = "/producto/{productoId}")
	public ResponseEntity<ProductosFavDTO> findById(@PathVariable("productoId") Long productoId){
		ProductoFav producto = productoFavService.fingById(productoId);

		ProductosFavDTO productoDto = ProductosFavDTO.builder()
				.idProducto(producto.getIdProducto())
				.nameProducto(producto.getNameProducto())
				.descripcion(producto.getDescripcion())
				.build();

		return new ResponseEntity<>(productoDto, HttpStatus.OK);
	}

	@DeleteMapping(value = "/producto/{productoId}")
	public ResponseEntity<Void> delete(@PathVariable("productoId") Long productoId){
		productoFavService.delete(productoId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/producto")
	public ResponseEntity<ProductosFavDTO> create(@RequestBody ProductoFav producto){
		ProductoFav newProductCreate = productoFavService.save(producto);

		ProductosFavDTO productoDto = ProductosFavDTO.builder()
				.idProducto(newProductCreate.getIdProducto())
				.nameProducto(newProductCreate.getNameProducto())
				.descripcion(newProductCreate.getDescripcion())
				.build();
		return new ResponseEntity<>(productoDto, HttpStatus.CREATED);
	}

	@PutMapping(value = "/producto")
	public ResponseEntity<ProductosFavDTO> update(@RequestBody ProductoFav producto){
		ProductoFav newProductUpdate = productoFavService.save(producto);

		ProductosFavDTO productoDto = ProductosFavDTO.builder()
				.idProducto(newProductUpdate.getIdProducto())
				.nameProducto(newProductUpdate.getNameProducto())
				.descripcion(newProductUpdate.getDescripcion())
				.build();
		return new ResponseEntity<>(productoDto, HttpStatus.OK);
	}
		
}
