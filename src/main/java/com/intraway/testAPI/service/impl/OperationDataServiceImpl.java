package com.intraway.testAPI.service.impl;

import com.intraway.testAPI.model.OperationData;
import com.intraway.testAPI.repository.OperationDataRepository;
import com.intraway.testAPI.service.OperationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationDataServiceImpl implements OperationDataService {

    @Autowired
    private OperationDataRepository operationDataRepository;

    public List<OperationData> findAll() {
        return operationDataRepository.findAll();
    }

    public Optional<OperationData> findById(Long id) {
        return operationDataRepository.findById(id);
    }

    public OperationData save(OperationData operationData) {
        return operationDataRepository.save(operationData);
    }

    public void deleteById(Long id) {
        operationDataRepository.deleteById(id);
    }
}
