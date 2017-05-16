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


    /**
     * Returns true if equal
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return regNo != null ? regNo.equals(vehicle.regNo) : vehicle.regNo == null;
    }

    /**
     * Hash code
     * @return
     */
    @Override
    public int hashCode() {
        return regNo != null ? regNo.hashCode() : 0;
    }
}
