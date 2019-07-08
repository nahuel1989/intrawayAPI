package com.intraway.testAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
@Table(name = "operation_data")
public class OperationData {
    public OperationData() {
    }

    public OperationData(Integer min, Integer max) {
        if (max < min) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los parámetros enviados son incorrectos");
        }
        this.min = min;
        this.max = max;
        this.timestamp = System.currentTimeMillis();
        this.list = IntStream.range(min, max + 1).mapToObj(i -> getString(i)).collect(Collectors.joining(","));
        this.description = getDescriptionText(this.list);
    }

    @Id
    @GeneratedValue
    private Long id;

    private Long timestamp;

    @Transient
    private String description;

    @Transient
    private String list;

    private Integer min;

    private Integer max;

    @JsonIgnore
    public Long getId(){
        return this.id;
    }

    @JsonProperty("code")
    public String getCode(){
        return String.format("%03d", this.id);
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public String getList() {
        return this.list;
    }

    private String getDescriptionText(String list) {
        String desciptionText = "No se encontraron multiplos";
        if (list.contains("Fizz") && list.contains("Buzz")) {
            desciptionText = "Se encontraron multiplos de 3 y de 5";
        } else if (list.contains("Fizz")) {
            desciptionText = "Se encontraron multiplos de 3";
        } else if (list.contains("Buzz")) {
            desciptionText = "Se encontraron multiplos de 5";
        }
        return desciptionText;
    }


    public String getString(int number) {
        String response = "";
        if ((number % 3) == 0) {
            response = "Fizz";
        }
        if ((number % 5) == 0) {
            response += "Buzz";
        }
        if (response == "") {
            response = String.valueOf(number);
        }
        return response;
    }
}
