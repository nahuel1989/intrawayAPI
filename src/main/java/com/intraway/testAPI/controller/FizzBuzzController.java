package com.intraway.testAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intraway.testAPI.model.OperationData;
import com.intraway.testAPI.repository.OperationDataRepository;
import com.intraway.testAPI.service.OperationDataService;
import com.intraway.testAPI.service.impl.OperationDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/intraway/api/fizzbuzz")
public class FizzBuzzController {

    @Autowired
    OperationDataServiceImpl operationDataService;

    @Autowired
    OperationDataRepository operationDataRepository;

    @GetMapping(value = "/{min}/{max}")
    public ResponseEntity<Object> test(@PathVariable("min") int min, @PathVariable("max") int max) {
        ObjectMapper objectMapper = new ObjectMapper();
        OperationData operationData = null;
        try{
            operationData = new OperationData(min, max);
            operationDataService.save(operationData);
            operationData.getId();
            return new ResponseEntity<Object>(objectMapper.writeValueAsString(operationData), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
