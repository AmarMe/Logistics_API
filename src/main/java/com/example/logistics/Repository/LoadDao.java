package com.example.logistics.Repository;

import com.example.logistics.Model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadDao extends JpaRepository<Load,Long> {
    List<Load> findByShipperId(String shipperId);
}
