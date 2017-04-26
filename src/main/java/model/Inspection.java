package main.java.model;

import main.java.integration.InspectionProtocol;
import main.java.integration.InspectionTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anders on 2017-04-24.
 * Handles inspections
 */
public class Inspection {
    private final Vehicle vehicle;
    private List<InspectionTask> inspectionProtocol = new ArrayList<>();

    /**
     * en fast kostnad för hela inspektionen
     */
    private final double inspectionCost = 500;

    public Inspection(Vehicle vehicle, List<InspectionTask> inspectionProtocol) {
        this.vehicle = vehicle;
        this.inspectionProtocol = inspectionProtocol;
    }


    public double getInspectionCost() {
        if(inspectionProtocol != null)
            return inspectionCost;
        else
            return 0;
    }

}
