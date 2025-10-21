package za.co.rideloop.Factory;

import za.co.rideloop.Domain.Location;
import za.co.rideloop.Util.Helper;

/* LocationFactory.java

     Location Factory  class

     Author: Natasha Njili(221785345)

     Date: 18 May 2025 */
public class LocationFactory {

    // 🔹 Factory method for creating a Location
    public static Location createLocation(
            double longitude,
            double latitude
    ) {

        if (!Helper.isPositive(Math.abs(longitude)) && longitude != 0) {
            throw new IllegalArgumentException("Longitude cannot be null or invalid");
        }
        if (!Helper.isPositive(Math.abs(latitude)) && latitude != 0) {
            throw new IllegalArgumentException("Latitude cannot be null or invalid");
        }

        // Check valid coordinate ranges
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180 degrees");
        }
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90 degrees");
        }

        return new Location.Builder()
                .setLongitude(longitude)
                .setLatitude(latitude)
                .build();
    }
}


