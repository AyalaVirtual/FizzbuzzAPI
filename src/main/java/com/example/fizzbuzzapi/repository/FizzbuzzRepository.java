package com.example.fizzbuzzapi.repository;

import com.example.fizzbuzzapi.model.Fizzbuzz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FizzbuzzRepository extends JpaRepository<Fizzbuzz, Long> {

    // This method finds a fizzbuzz by  its id
    Optional<Fizzbuzz> findById(Long fizzbuzzId);
}
