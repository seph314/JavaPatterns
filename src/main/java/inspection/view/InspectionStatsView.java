package inspection.view;

import inspection.model.InspectionTaskObserver;

/**
 * Created by Anders on 2017-05-14.
 */
public class InspectionStatsView implements InspectionTaskObserver {
    private int numberOfInspectionsPerformed = 0;

    @Override
    public void inspectionTaskPerformed() {
        addNewInspection();
        printCurrentNumberOfInspections();
    }

    private void addNewInspection(){
        numberOfInspectionsPerformed++;
    }

    private void printCurrentNumberOfInspections(){
        System.out.println("Total number of inspection since program start: " + numberOfInspectionsPerformed);
    }
}
