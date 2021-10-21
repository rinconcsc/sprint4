package com.misiontic.webfavorites.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos_favoritos")
public class ProductoFav {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long idProducto;

	@Column(name = "name_producto",length = 100, nullable = false)
	private String nameProducto;

	@Column(name = "descripcion",length = 500, nullable = false)
	private String descripcion;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="favoritos", nullable = true	)
	private User user;


}
