package com.bk.AsyncApiCall.Callers;

import com.bk.AsyncApiCall.Responses.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class GetAllEmployeesApi {

    public List<Employee> getEmployee() {
        try {
            AsyncHttpClient client = Dsl.asyncHttpClient(); // Auto-close client
            CompletableFuture<Response> completableFuture = client
                    .prepareGet("http://localhost:8080/viewAllEmployee")
                    .execute()
                    .toCompletableFuture();

            // Process response and convert to Employee object
            return completableFuture.thenApply(response -> {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(response.getResponseBody(), new TypeReference<List<Employee>>() {});
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }).join(); // Waits for async completion and returns Employee

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
