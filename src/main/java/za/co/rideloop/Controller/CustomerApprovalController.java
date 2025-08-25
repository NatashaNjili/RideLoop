package za.co.rideloop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.rideloop.Domain.CustomerApproval;
import za.co.rideloop.Factory.CustomerApprovalFactory;
import za.co.rideloop.Service.CustomerApprovalService;

import java.net.http.HttpHeaders;
import java.util.List;

@RestController
public class CustomerApprovalController {

    @Autowired
    private CustomerApprovalService customerApprovalService;

    @PostMapping("/save")
    public CustomerApproval save(@RequestBody CustomerApproval customerApproval) {
        return customerApprovalService.save(customerApproval);
    }

    @GetMapping("/read/{customerApprovalId}")
    public CustomerApproval read(@PathVariable int customerApprovalId) {
        return customerApprovalService.read(customerApprovalId);
    }

    @PostMapping("/update")
    public CustomerApproval update(@RequestBody CustomerApproval customerApproval) {
        return customerApprovalService.save(customerApproval);
    }

    @DeleteMapping("/delete/{customerApprovalId}")
    public boolean delete(@PathVariable int customerApprovalId) {
        return customerApprovalService.deleteById(customerApprovalId);
    }

    @GetMapping("/getall")
    public List<CustomerApproval> getAll() {

        return customerApprovalService.getAll();
    }

}
