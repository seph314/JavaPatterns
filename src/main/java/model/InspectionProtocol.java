package main.java.model;

/**
 * Created by Anders on 2017-04-25.
 */
public class InspectionProtocol {

    private String[] inspectionTasks = {"Kolla bromsarna", "Kolla lysen", "Mät utsläpp"};
    private double inspectionCost = 499;

    public String[] getInspectionTasks() {
        return inspectionTasks;
    }

    public double getInspectionCost() {
        return inspectionCost;
    }
}
