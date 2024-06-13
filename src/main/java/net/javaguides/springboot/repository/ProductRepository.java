package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query(value = "Select * from employees e where e.email_id LIKE ?1",nativeQuery = true)
    Optional<Product> findByEmailId(String email_id);

}
