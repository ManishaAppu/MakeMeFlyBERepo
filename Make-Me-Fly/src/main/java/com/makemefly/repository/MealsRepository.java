package com.makemefly.repository;

import com.makemefly.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsRepository extends JpaRepository<Meal, Integer> {
}
