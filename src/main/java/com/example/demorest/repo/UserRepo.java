package com.example.demorest.repo;

import com.example.demorest.domeins.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
