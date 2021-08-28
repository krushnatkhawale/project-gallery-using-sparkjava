package com.practice.service;

import spark.Request;
import spark.Response;

public class HTTPService {
    public static final String HEALTHCHECK_URL = "/health";

    public static Object healthCheck(Request request, Response response) {
        response.status(200);
        return response;
    }
}
