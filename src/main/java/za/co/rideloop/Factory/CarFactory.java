package za.co.rideloop.Factory;

import jdk.javadoc.doclet.Taglet;
import za.co.rideloop.Domain.Car;
import za.co.rideloop.Domain.Location;
import za.co.rideloop.Util.Helper;

import java.time.Year;

/* CarFactory.java

     CAR Factory class

     Author: Natasha Njili(221785345)

     Date: 18 May 2025 */
public class CarFactory {
    public static Car createCar(int carID,
            String brand,
            String model,
            int year,
            String licensePlate,
            double rentalRate,
            String status,
            String category,
            int mileage,
            String lastMaintenance,
            String maintenanceDue,
            Location location
    ) {

        // ===== VALIDATION =====
        if (!Helper.isValidInterger(carID)) {
            throw new IllegalArgumentException("Invalid Car ID");
        }
        if (Helper.isNullOrEmpty(brand)) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(model)) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }

        int currentYear = Year.now().getValue();
        if (year < 1990 || year > currentYear) {
            throw new IllegalArgumentException("Year must be between 1990 and " + currentYear);
        }

        if (Helper.isNullOrEmpty(licensePlate)) {
            throw new IllegalArgumentException("License plate cannot be null or empty");
        }

        if (!Helper.isValidAmount(rentalRate)) {
            throw new IllegalArgumentException("Rental rate must be greater than 0");
        }

        if (Helper.isNullOrEmpty(status)) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }

        if (Helper.isNullOrEmpty(category)) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }

        if (!Helper.isValidInterger(mileage)) {
            throw new IllegalArgumentException("Mileage must be positive");
        }

        if (Helper.isNullOrEmpty(lastMaintenance)) {
            throw new IllegalArgumentException("Last maintenance cannot be null or empty");
        }

        if (Helper.isNullOrEmpty(maintenanceDue)) {
            throw new IllegalArgumentException("Maintenance due cannot be null or empty");
        }

        if (Helper.isNull(location)) {
            throw new IllegalArgumentException("Location cannot be null");
        }


        return new Car.Builder()
                .setCarId(carID)
                .setBrand(brand)
                .setModel(model)
                .setYear(year)
                .setLicensePlate(licensePlate)
                .setRentalRate(rentalRate)
                .setStatus(status)
                .setCategory(category)
                .setMileage(mileage)
                .setLastMaintenance(lastMaintenance)
                .setMaintenanceDue(maintenanceDue)
                .setLocation(location)
                .build();
    }

}
