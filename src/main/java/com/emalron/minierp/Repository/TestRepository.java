package com.emalron.minierp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emalron.minierp.Entity.TestItem;

public interface TestRepository extends JpaRepository<TestItem, Long> {
 
}