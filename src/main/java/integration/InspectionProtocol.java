package main.java.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anders on 2017-04-25.
 */
public class InspectionProtocol {

    private List<InspectionTask> inspectionProtocol;

    public InspectionProtocol() {
       createDummyInspections();
    }

    public List<InspectionTask> createDummyInspections() {
        inspectionProtocol = new ArrayList<>();
        inspectionProtocol.add(new InspectionTask("brakes"));
        inspectionProtocol.add(new InspectionTask("suspension"));
        inspectionProtocol.add(new InspectionTask("steering"));

        return inspectionProtocol;
    }
}
