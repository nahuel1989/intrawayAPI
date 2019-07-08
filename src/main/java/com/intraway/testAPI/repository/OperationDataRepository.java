package com.intraway.testAPI.repository;

import com.intraway.testAPI.model.OperationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDataRepository extends JpaRepository<OperationData, Long> {
}
