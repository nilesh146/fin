package com.alt.fin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alt.fin.entity.ProductEnt;
@Repository
public interface ProductRepo extends JpaRepository<ProductEnt, Integer>{

}
