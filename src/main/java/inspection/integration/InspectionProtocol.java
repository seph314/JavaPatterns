package inspection.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * The inspectionProtocol is a List of InspectionTasks
 */
public class InspectionProtocol {

    int i = 1;

    private List<InspectionTask> inspectionProtocol;

    /**
     * constructor
     */
    public InspectionProtocol() {
       createDummyInspections();
    }

    /**
     * creates dummy inspection list
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
