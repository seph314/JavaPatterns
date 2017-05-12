package inspection.integration;

import inspection.model.Vehicle;

/**
 * Handles exceptions for illegal license numbers
 * A license number is illegal if there are no inspections for that number
 */
public class IllegalLicenseNumberException extends Exception {
    private Vehicle vehicleWithIllefalLicenceNumber;

    /**
     * Constructor
     * @param vehicleWithIllefalLicenceNumber
     */
    public IllegalLicenseNumberException(Vehicle vehicleWithIllefalLicenceNumber) {
        super("Unable to find inspection for vehicle withe regNo: " + vehicleWithIllefalLicenceNumber.getRegNo());
        this.vehicleWithIllefalLicenceNumber = vehicleWithIllefalLicenceNumber;
    }

    /**
     * Getter
     * @return
     */
    public Vehicle getVehicleWithIllefalLicenceNumber() {
        return vehicleWithIllefalLicenceNumber;
    }
}
