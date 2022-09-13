package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Bikash Shah
 */
@RestController
public class AdminController {


    public static final String BASE_URL = "https://localhost:9443/";
    protected RestTemplate restTemplate;
    protected HttpHeaders headers;
    public AdminController() {
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.setBasicAuth("admin", "admin");
    }
}
