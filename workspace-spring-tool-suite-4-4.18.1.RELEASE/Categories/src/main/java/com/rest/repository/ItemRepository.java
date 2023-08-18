package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.model.Items;
@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {
	@Query("SELECT i From Items i WHERE i.category=?1")
	List<Items> findByCategory(String category);
}
