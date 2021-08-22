package com.practice;

import com.practice.service.ProjectService;

import static spark.Spark.get;
import static spark.Spark.post;

public class Api {


    public static void main(String[] args) {
        get("/projects", ProjectService::getProject);
        post("/projects", ProjectService::postProject);
    }
}