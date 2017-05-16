package inspection.integration;

import inspection.model.Vehicle;

/**
 * Handles exceptions for illegal license numbers
 * A license number is illegal if there are no inspections for that number
 */
public class IllegalLicenseNumberException extends Exception {

    private Vehicle vehicleWithIllegalLicenceNumber;

    /**
     * Constructor
     * @param vehicleWithIllegalLicenceNumber contains the illegal licensenumber
     */
    public IllegalLicenseNumberException(Vehicle vehicleWithIllegalLicenceNumber) {
        super("Unable to find inspection for vehicle withe regNo: " + vehicleWithIllegalLicenceNumber.getRegNo());
        this.vehicleWithIllegalLicenceNumber = vehicleWithIllegalLicenceNumber;
    }

    /**
     * Getter
     * @return vehicle with illegal licensenumber
     */
    public Vehicle getVehicleWithIllegalLicenceNumber() {
        return vehicleWithIllegalLicenceNumber;
    }
}
