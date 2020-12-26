package com.jordans.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jordans.models.Shoe;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Integer> {

	List<Shoe> findByModelContaining(String model);
}
