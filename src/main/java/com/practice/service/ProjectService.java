package com.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class ProjectService {

    private static Map<String, Project> db = new HashMap<>();

    public static Object postProject(Request request, Response response) {
        Project newProject = stringToPojo(request);
        newProject.setId(String.valueOf(db.size() + 1));
        db.put(newProject.getId(), newProject);
        return newProject.getId();
    }


    public static String getProject(Request request, Response response) {
        response.type("application/json");
        return dataToJson(db.values());
    }

    private static Project stringToPojo(Request request) {
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