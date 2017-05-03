/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * The inspectionProtocol is a List of InspectionTasks
 */
public class InspectionProtocol {

    private List<InspectionTask> inspectionProtocol;

    /**
     * InspectionProtocol constructor
     */
    public InspectionProtocol() {
       createDummyInspections();
    }

    /**
     * creates dummy inspection list that emulates information gathered from the database
     * @return
     */
    public List<InspectionTask> createDummyInspections() {
        inspectionProtocol = new ArrayList<>();
        inspectionProtocol.add(new InspectionTask("brakes", false));
        inspectionProtocol.add(new InspectionTask("suspension", false));
        inspectionProtocol.add(new InspectionTask("steering", false));

        return inspectionProtocol;
    }
}
