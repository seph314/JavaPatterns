package inspection.view;

import inspection.model.InspectionTask;
import inspection.model.InspectionTaskObserver;
import java.util.List;

/**
 * This view shows the total number of inspections performed since the program start
 */
public class InspectionStatsView implements InspectionTaskObserver {
    private int numberOfInspectionsPerformed = 0;

    /**
     * When a inspection task is performed, this method makes necessary calls to
     * increments the number of inspection tasks performed by 1 and prints the current state
     * @param inspectionTask
     */
    @Override
    public void inspectionTaskPerformed(InspectionTask inspectionTask) {
        countNumberOfInspections();
        printCurrentNumberOfInspections();
    }

    /**
     * Loops through a list of inspections
     * Adds inspection observer
     * @param inspectionTaskList is a list of inspections
     */
    public void listenToTasks(List<InspectionTask> inspectionTaskList){
        for (InspectionTask inspectionTask : inspectionTaskList){
            inspectionTask.addInspectionObserver(this);
        }
    }

    private void countNumberOfInspections(){
        numberOfInspectionsPerformed++;
    }

    private void printCurrentNumberOfInspections(){
        System.out.println("Total number of inspection since program start: " + numberOfInspectionsPerformed);
    }
}
