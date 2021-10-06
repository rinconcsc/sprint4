package com.misiontic.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.webfavorites.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
