/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.model;

/**
 * Created by Anders on 2017-04-24.
 * A vehicle that is inspected
 */
public class Vehicle {

    private String regNo;

    /**
     * Vehicle constructor
     * @param regNo
     */
    public Vehicle(String regNo){
        this.regNo = regNo;
    }

    /**
     * Returns a vehicles registration number
     * @return
     */
    public String getRegNo() {
        return regNo;
    }
}
