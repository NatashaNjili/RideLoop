package za.co.rideloop.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.rideloop.Domain.Rental;
import za.co.rideloop.Repository.RentalRepository;

import java.util.List;

/**
 * RentalFactory.java
 * RentalFactory Model Class
 *
 * @Author: Mziwamangwevu Ntutu
 * @Student Number: 217054420
 * Group 3 I
 **/
@Service
@Transactional
public class RentalService {


    @Autowired

    private RentalRepository repository;

    // ===== Create =====

    @Transactional
    public Rental create(Rental rental) {

        return this.repository.save(rental);
    }

    public List<Rental> getAll() {
        return this.repository.findAll();
    }
    
    // ===== Find by Status =====
    public List<Rental> getRentalsByCustomer(int customerId) {
        return repository.findByCustomerID(customerId);
    }

}
