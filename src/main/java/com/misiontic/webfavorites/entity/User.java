package com.misiontic.webfavorites.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", length = 100, nullable = false)
	private String name;
	
	@Column(name="password", length = 200, nullable = false)
	private String password;
	
	@Column(name="email", length= 100, nullable = false)
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", nullable =true)
	private List<ProductosFav> productosFav;
	
	
}
