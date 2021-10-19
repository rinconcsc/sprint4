package com.misiontic.webfavorites.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.webfavorites.entity.ProductosFav;
import com.misiontic.webfavorites.entity.User;
import com.misiontic.webfavorites.repository.ProductoFavRepository;
import com.misiontic.webfavorites.repository.UserRepository;
import com.misiontic.webfavorites.validators.UserValidator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductoFavRepository productofavRepo;
	
	public List<User> findAll() {
		List<User> users = userRepo.findAll();
		return users;
	}

	public User fingById(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("El usuario no existe"));
		return user;
	}

	@Transactional
	public void delete(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("El usuario no existe"));

		userRepo.delete(user);
	}

	@Transactional
	public User save(User user) {

		UserValidator.save(user);

		if (user.getId() == null) {
			User newUser = userRepo.save(user);
			return newUser;
		}

		User updateUser = userRepo.findById(user.getId())
				.orElseThrow(() -> new RuntimeException("El usuario no existe."));

		updateUser.setName(user.getName());
		updateUser.setPassword(user.getPassword());
		updateUser.setEmail(user.getEmail());

		userRepo.save(updateUser);

		return updateUser;
	}

	public void addFav(User user, ProductosFav producto) {
		
		User userAddFav = userRepo.findById(user.getId()).orElseThrow(() -> new RuntimeException("El usuario no existe"));
		ProductosFav productAddFav = productofavRepo.findById(producto.getIdProducto()).orElseThrow(() -> new RuntimeException("El usuario no existe"));
		
		List<ProductosFav> productosFav = new ArrayList<>();
		productosFav.add(productAddFav);
		
		userAddFav.setProductosFav(productosFav);
		
		userRepo.save(userAddFav);
	}

}
