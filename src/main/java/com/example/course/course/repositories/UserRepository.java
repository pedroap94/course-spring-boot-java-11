package com.example.course.course.repositories;

import com.example.course.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //ele pede o <Tipo entidade, Tipo id>
//A gente não cria uma implementação desta interface, pois o Spring JpaRepository já tem uma implementação padrão para esta interface
}
