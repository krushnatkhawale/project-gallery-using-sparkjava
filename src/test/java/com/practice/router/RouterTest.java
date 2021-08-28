package com.practice.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.util.HttpResponse;
import com.practice.util.HttpUtility;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouterTest {

    HttpUtility httpUtililty = new HttpUtility("http", "localhost", 4567);

    @BeforeEach
    public void setup() {
        new Router().registerRoutes();
    }

    @Test
    public void postProjectTest() {

    }

    @Test
    public void getProjectsReturnsAListTest() {
        HttpResponse httpResponse = httpUtililty.makeRequest(Router.PROJECTS_BASE_URL);

        assertEquals(httpResponse.getStatusCode(), HttpStatus.OK_200);
        assertEquals(httpResponse.getBodyAsJson(), new ObjectMapper().createArrayNode());
    }
}