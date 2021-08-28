package com.practice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.practice.model.Project;
import spark.Request;

import java.io.IOException;
import java.io.StringWriter;

public class JsonUtil {
    public static Project stringToPojo(Request request) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(request.body(), Project.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing request body: " + request.body(), e);
        }
    }

    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, data);
            return sw.toString();
        } catch (IOException e) {
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }
}