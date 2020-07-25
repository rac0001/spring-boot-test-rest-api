package prac.rac.io.bootservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import prac.rac.io.bootservice.domain.User;

import java.util.List;

@RestController
public class UserDataController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user-data")
    public List<User> fetchUsers(){
        ResponseEntity<List<User>> response= this.restTemplate.exchange("https://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>(){
                });
        return response.getBody();
    }

}
