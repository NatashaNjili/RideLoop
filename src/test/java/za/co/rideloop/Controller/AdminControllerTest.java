package za.co.rideloop.Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.co.rideloop.Domain.Admin;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String BASE_URL = "http://localhost:8080/rideloop/admin";
    private Admin admin;


    @Test
    void save() {
        String url = "http://localhost:8080/rideloop/admin/save";
        ResponseEntity<Admin> postResponse = this.testRestTemplate.postForEntity(url, this.admin, Admin.class, new Object[0]);
        Assertions.assertNotNull(postResponse);
        Assertions.assertNotNull(postResponse.getBody());
        System.out.println("Admin saved:");
        System.out.println(postResponse.getBody());
    }

    @Test
    void read() {
        String url = "http://localhost:8080/rideloop/admin/read/5";
        ResponseEntity<Admin> response = this.testRestTemplate.getForEntity(url, Admin.class, new Object[0]);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        String url = "http://localhost:8080/rideloop/admin/update";
        Admin newAdmin = (new Admin.adminBuilder()).copy(this.admin).setPassword("8901").build();
        ResponseEntity<Admin> postResponse = this.testRestTemplate.postForEntity(url, newAdmin, Admin.class, new Object[0]);
        Assertions.assertNotNull(postResponse);
        Assertions.assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    void delete() {
        String url = "http://localhost:8080/rideloop/admin/delete/6";
        this.testRestTemplate.delete(url, new Object[0]);
        System.out.println("Admin Deleted successfully");
    }

    @Test
    void getAll() {
        String url = "http://localhost:8080/rideloop/admin/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity((Object)null, headers);
        ResponseEntity<String> response = this.testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class, new Object[0]);
        System.out.println("All Admins:");
        System.out.println((String)response.getBody());
    }
}