package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bikash Shah
 */

@RestController
@RequestMapping(value = "user")
public class UserController extends AdminController {

    @GetMapping()
    public ResponseEntity<?> getUsers() {
        String userURL = BASE_URL + "scim2/Users";
        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(userURL, HttpMethod.GET, request, String.class);
        System.out.println("result : " + result.getBody());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
