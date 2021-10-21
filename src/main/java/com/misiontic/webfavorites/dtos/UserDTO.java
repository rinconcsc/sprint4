package com.misiontic.webfavorites.dtos;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

	private Long id;
	private String name;
	private String password;
	private String email;

}
