package com.example.demorest.repo;

import com.example.demorest.domeins.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Long> {
}
