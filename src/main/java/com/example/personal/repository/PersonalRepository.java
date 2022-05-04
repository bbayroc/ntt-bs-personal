package com.example.personal.repository;

import com.example.personal.entity.Personal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends MongoRepository<Personal, Long> {
    Personal findByDni(String dni);
}
