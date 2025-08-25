package za.co.rideloop.Service;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.rideloop.Domain.Admin;
import za.co.rideloop.Factory.AdminFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    private Admin admin;
    @BeforeEach

    void setUp(){
        admin = AdminFactory.createAdmin(1, "Ndyebo","Cput2025!");
    }

    @Test
    @Order(1)
    void save() {
        Admin newAdmin = adminService.save(admin);
        assertNotNull(newAdmin);
        System.out.println(newAdmin);

    }

    @Test
    @Order(2)
    void read() {
        Admin adminID = adminService.read(2);
        assertNotNull(adminID);
        System.out.println(adminID);
    }

    @Test
    @Order(3)
    void update() {
        Admin newAdmin = new Admin.adminBuilder().copy(admin).setUserName("adminUser2").build();
        Admin updatedAdmin = adminService.update(newAdmin);
        assertNotNull(updatedAdmin);
        System.out.println(updatedAdmin);
    }

    @Test
    @Order(4)
    void deleteId() {
        boolean deleted = adminService.deleteId(1);
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {
        List<Admin> adminList = adminService.getAll();
        System.out.println(adminList);
    }
}