package com.misiontic.webfavorites.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductosFavDTO {

	private Long idProducto;
	private String nameProducto;
	private String descripcion;
}
