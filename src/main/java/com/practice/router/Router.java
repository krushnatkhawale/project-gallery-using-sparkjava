package com.practice.router;

import com.practice.service.HTTPService;
import com.practice.service.ProjectService;

import static com.practice.service.HTTPService.HEALTHCHECK_URL;
import static spark.Spark.get;
import static spark.Spark.post;

public class Router {

    public static final String PROJECTS_BASE_URL = "/projects";

    public void registerRoutes() {
        get(PROJECTS_BASE_URL, ProjectService::getProject);
        post(PROJECTS_BASE_URL, ProjectService::postProject);
        get(HEALTHCHECK_URL, HTTPService::healthCheck);
    }
}