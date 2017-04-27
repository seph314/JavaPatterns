package inspection.model;

/**
 * Created by Anders on 2017-04-24.
 * A vehicle that is inspected
 */
public class Vehicle {

    private String regNo;

    public Vehicle(String regNo){
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }
}
