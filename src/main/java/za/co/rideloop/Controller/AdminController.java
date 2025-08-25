package za.co.rideloop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.rideloop.Domain.Admin;
import za.co.rideloop.Service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired

    private AdminService adminService;

    @PostMapping("/save")
    public Admin save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @GetMapping("/read/{adminId}")
    public Admin read(@PathVariable int adminId) {
        return adminService.read(adminId);
    }

    @PostMapping("/update")
    public Admin update(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @DeleteMapping("/delete/{adminId}")
    public boolean delete(@PathVariable int adminId) {
        return adminService.deleteId(adminId);
    }

    @GetMapping("/getall")
    public List<Admin> getAll() {
        return adminService.getAll();
    }

}
