package com.example.inventManager.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventManager.models.User;


@Repository
public interface IUserRepository extends JpaRepository<User,UUID> {
    
}
