package com.intraway.testAPI;

import com.intraway.testAPI.model.OperationData;
import com.intraway.testAPI.repository.OperationDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OperationDataRepositoryIntegrationTest {

    @Autowired
    private OperationDataRepository operationDataRepository;


    @Test
    public void whenCreateOperationData_thenReturnOperationData() {
        // given
        int min = 1;
        int max = 25;

        //when
        OperationData operationData = new OperationData(min,max);

        //then
        assertNotNull(operationData);
    }

    @Test
    public void whenCreateOperationDataBadParameters_thenReturnNull() {
        // given
        int min = 25;
        int max = 1;

        //when
        OperationData operationData = null;
        try{
            operationData = new OperationData(min,max);

        }catch (Exception e){

        }

        //then
        assertNull(operationData);
    }

    @Test
    public void whenPersistOperationData_thenReturnOperationData() {

        // given
        OperationData operationData = new OperationData(1,5);

        //when
        operationDataRepository.save(operationData);

        //then
        assertNotNull(operationData.getId());
    }

}
