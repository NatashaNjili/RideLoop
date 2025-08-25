package za.co.rideloop.Service;

/**
 *
 * @Author: Ndyebo Qole 210018615
 * @Student Number: 210018615
 **/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.rideloop.Domain.CustomerApproval;
import za.co.rideloop.Factory.CustomerApprovalFactory;

import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerApprovalServiceTest {

    @Autowired

    private CustomerApprovalService customerApprovalService;
    private CustomerApproval approvalService;

    @BeforeEach
    void setUp() {

        this.approvalService = CustomerApprovalFactory.createCustomerApproval(1,"NQO3113", true);
    }
    @Test
    @Order(1)
    void save() {
        CustomerApproval createApproval = this.customerApprovalService.save(this.approvalService);
        Assertions.assertNotNull(createApproval);
        System.out.println(createApproval);

    }

    @Test
    @Order(2)
    void read() {
        CustomerApproval readApproval = this.customerApprovalService.read(2);
        Assertions.assertNotNull(readApproval);
        System.out.println(readApproval);
    }

    @Test
    @Order(3)
    void update() {
        CustomerApproval newAproval = (new CustomerApproval.approvalBuilder()).setLicenseNumber("3333").build();
        CustomerApproval updateApproval = this.customerApprovalService.update(newAproval);
        Assertions.assertNotNull(updateApproval);
        System.out.println(updateApproval);
    }

    @Test
    @Order(4)
    void deleteById() {
        boolean deleted = this.customerApprovalService.deleteById(8);
        Assertions.assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {
        List<CustomerApproval> customerApprovals = this.customerApprovalService.getAll();
        System.out.println(customerApprovals);
    }
}