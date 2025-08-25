package za.co.rideloop.Service;

/**
 *
 * @Author: Ndyebo Qole 210018615
 * @Student Number: 210018615
 **/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.rideloop.Domain.Admin;
import za.co.rideloop.Repository.AdminRepository;


import java.util.List;

    @Service
    public class AdminService {
        @Autowired
        private AdminRepository adminRepository;

        public Admin save(Admin admin) {
            return adminRepository.save(admin);
        }
        public Admin read(int id) {
            return adminRepository.findById(id).orElse(null);
        }
        public Admin update(Admin admin) {
            return adminRepository.save(admin);


        }
        public boolean deleteId(int id) {
            adminRepository.deleteById(id);
            return !adminRepository.existsById(id);
        }
        public List<Admin> getAll(){
            return adminRepository.findAll();
        }


    }


