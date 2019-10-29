package com.example.SmartziWeb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SmartziWeb.model.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;





public interface UserRepository extends JpaRepository<User, Long>{ 

	 @Query("SELECT  at FROM User at WHERE at.Email = :email AND at.Password=:password")
	 List<User> findTemplate(String email,String password);
}
