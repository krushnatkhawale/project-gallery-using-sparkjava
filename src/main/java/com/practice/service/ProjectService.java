package com.practice.service;

import com.practice.model.Project;
import com.practice.util.JsonUtil;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ProjectService {

    private static Map<String, Project> db = new HashMap<>();

    public static Object postProject(Request request, Response response) {
        Project newProject = JsonUtil.stringToPojo(request);
        newProject.setId(String.valueOf(db.size() + 1));
        db.put(newProject.getId(), newProject);
        return newProject.getId();
    }


    public static String getProject(Request request, Response response) {
        response.type("application/json");
        return JsonUtil.dataToJson(db.values());
    }
}