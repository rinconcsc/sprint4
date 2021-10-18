package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.User;

public class UserValidator {
	
	public static void save(User user) {
		
		if(user.getName() == null || user.getName().trim().isEmpty()) {
			throw new RuntimeException("El nombre es obligatorio.");
		}
		
		if(user.getName().length() > 100) {
			throw new RuntimeException("El nombre no puede ser mayor a 100 caracteres.");
		}
	}
}
