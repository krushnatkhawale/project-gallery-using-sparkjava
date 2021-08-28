package com.practice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpResponse {

    private int statusCode;
    private String body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public JsonNode getBodyAsJson() {
        try {
            return new ObjectMapper().readTree(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while parsing json: " + body, e);
        }
    }

    public void setBody(String body) {
        this.body = body;
    }
}