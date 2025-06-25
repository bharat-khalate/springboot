package com.bk.AsyncApiCall.Callers;

import com.bk.AsyncApiCall.Responses.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AddNewEmployeeApi {

    private final ObjectMapper objectMapper=new ObjectMapper();

    public String addEmployee(Employee employee){
        try{
            AsyncHttpClient client= Dsl.asyncHttpClient();
            String requestbody=objectMapper.writeValueAsString(employee);
            CompletableFuture<Response> completableFuture=client
                    .preparePost("http://localhost:8080/createEmployee")
                    .setHeader("Content-type","application/json")
                    .setBody(requestbody).execute().toCompletableFuture();
            return completableFuture.thenApply(response -> {
                if(response.getStatusCode()==200 || response.getStatusCode()==201){
                    return "employee added";
                }else{
                    return "failed to add employee";
                }
            }).join();

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return null;
    }
}
