package com.Km_Agri.repository;

import com.Km_Agri.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    //    @Query(value = "select id, user_name, password, role, user_id from auth where user_name=userName")
    Optional<Auth> findByUserName(String userName);

    void deleteByUserName(String userName);

}
