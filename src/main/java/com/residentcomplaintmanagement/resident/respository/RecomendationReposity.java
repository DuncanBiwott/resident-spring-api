package com.residentcomplaintmanagement.resident.respository;

import com.residentcomplaintmanagement.resident.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendationReposity extends JpaRepository<Recommendation, Long> {
}
