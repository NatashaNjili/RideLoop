package za.co.rideloop.Factory;

import za.co.rideloop.Domain.Maintenance;
import za.co.rideloop.Util.Helper;

/* MaintananceFactory.java

     Mainntanence Factory class

     Author: Natasha Njili(221785345)

     Date: 18 May 2025 */
public class MaintenanceFactory {

    public static Maintenance createMaintenance(
            Long id,
    String insuranceCompanyName,
    String contactPerson,
    String contactNumber,
    String coverageType,
    Double costPerMonth,
    String description
    ) {

        if (Helper.isNull(id) || id <= 0) {
            throw new IllegalArgumentException("Invalid Maintenance ID");
        }
        if (Helper.isNullOrEmpty(insuranceCompanyName)) {
            throw new IllegalArgumentException("Insurance company name cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(contactPerson)) {
            throw new IllegalArgumentException("Contact person cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(contactNumber)) {
            throw new IllegalArgumentException("Contact number cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(coverageType)) {
            throw new IllegalArgumentException("Coverage type cannot be null or empty");
        }
        if (Helper.isNull(costPerMonth) || !Helper.isValidAmount(costPerMonth)) {
            throw new IllegalArgumentException("Monthly cost must be greater than 0");
        }
        if (Helper.isNullOrEmpty(description)) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }


        return new Maintenance.Builder()
            .setId(id)
            .setInsuranceCompanyName(insuranceCompanyName)
            .setContactPerson(contactPerson)
            .setContactNumber(contactNumber)
            .setCoverageType(coverageType)
            .setCostPerMonth(costPerMonth)
            .setDescription(description)
            .build();
    }
}
