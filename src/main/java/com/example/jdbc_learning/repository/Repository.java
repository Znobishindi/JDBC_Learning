package com.example.jdbc_learning.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Repository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> returnProductNameByCustomerName(String customerName) {
        String scriptProductNameByCustomerName = read("selection_by_name.sql");
        return (namedParameterJdbcTemplate.queryForList(scriptProductNameByCustomerName,
                Map.of("name", customerName),
                String.class));

    }


}
