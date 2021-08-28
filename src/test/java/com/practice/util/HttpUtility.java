package com.practice.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtility {

    private final String protocol;
    private final String host;
    private final int port;

    public HttpUtility(String protocol, String host, int port) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
    }

    public HttpResponse makeRequest(String path) {
        HttpResponse httpResponse = new HttpResponse();
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(protocol, host, port, path).openConnection();
            httpResponse.setStatusCode(con.getResponseCode());
            String response = getResponseBody(con);
            httpResponse.setBody(response);
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException("Error while making request: " + path, e);
        }
        return httpResponse;
    }

    private String getResponseBody(HttpURLConnection con) {
        BufferedReader in = null;

        // https://stackoverflow.com/questions/24707506/httpurlconnection-how-to-read-payload-of-400-response
        try {
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
        } catch (Exception e) {
            // handle 400 exception messages
            InputStream stream = con.getErrorStream();
            if (stream != null) {
                in = new BufferedReader(
                        new InputStreamReader(stream));
            }
        }

        String inputLine;
        StringBuffer responseBody = new StringBuffer();

        try {
            if (in != null) {
                while ((inputLine = in.readLine()) != null) {
                    responseBody.append(inputLine);
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseBody.toString();
    }
}