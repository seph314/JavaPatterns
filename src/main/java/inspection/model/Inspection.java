package inspection.model;

import inspection.integration.InspectionTask;

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
     * This inspection company has a marketing strategy where every inspection has a fixed price inspectionCost
     */
    private final double inspectionCost = 500;

    /**
     * Constructor
     *
     * @param vehicle
     * @param inspectionProtocol
     */
    public Inspection(Vehicle vehicle, List<InspectionTask> inspectionProtocol) {
        this.vehicle = vehicle;
        this.inspectionProtocol = inspectionProtocol;
    }

    /**
     * Returns each task in the inspectionProtocol to the view
     * @return
     */
    public List<InspectionTask> performInspection(){
        return inspectionProtocol;
    }

    /**
     * Returns the inspectioncost if there is an inspectionProtocol has been created
     * @return the cost for inspection
     */
    public double getInspectionCost() {
        if(inspectionProtocol != null)
            return inspectionCost;
        else
            return 0;
    }
}
