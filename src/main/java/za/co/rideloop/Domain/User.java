package za.co.rideloop.Domain;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;  // primary key

    @Column(unique = true)
    private String email;

    private String username;
    private String password;


    // Role: CUSTOMER or ADMIN
    private String role = "CUSTOMER"; // default

    // BCrypt encoder (can be reused)
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User() {}

    protected User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password; // already hashed in Builder
        this.email = builder.email;
        this.role = builder.role;
    }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    // User.java
    public void setPassword(String password) {
        this.password = password; // store raw password from service
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getId() {
        return this.userID;
    }

    public void setUserId(int i) {

    }

    public static class Builder {
        private String username;
        private String password;
        private String email;
        private String role = "CUSTOMER";

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        // Hash password automatically when using builder
        public Builder setPassword(String password) {
            this.password = passwordEncoder.encode(password);
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
