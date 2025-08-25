package za.co.rideloop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.rideloop.Domain.Admin;

import java.util.List;


/**
 * AdminRepository.java
 * AdminRepository Model Class
 *
 * @Author: Ndyebo Qole 210018615
 * @Student Number: 210018615
 **/
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findByadminID(int adminID);

    boolean existsByadminID(int adminID);

    List<Admin> findByadminIDAndPassword(int adminID, String password);


}

