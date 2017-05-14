/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anders on 2017-04-26.
 *
 */
public class InspectionTask {

    private String name;
    private boolean passOrFail = false;
    private List<InspectionTaskObserver> inspectionTaskOberservers = new ArrayList<>();
    private InspectionTask task;

    /**
     * Creates new instance representing the specified control.
     * @param name The name of this control.
     *
     */
    public InspectionTask(String name, boolean passOrFail) {
        this.name = name;
        this.passOrFail = passOrFail;
    }

    /**
     * Returs the name of a task
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns true or false for handling of pass or fail of inspection task
     * @return
     */
    public boolean isPassOrFail() {
        return passOrFail;
    }

    /**
     * Set boolan true or false tp handle pass or fail of inspection task
     * @param passOrFail
     */
    public void setPassOrFail(boolean passOrFail) {
        this.passOrFail = passOrFail;
        notifyObservers();
    }

    private void notifyObservers(){
        for (InspectionTaskObserver inspTaskObs : inspectionTaskOberservers){
            inspTaskObs.inspectionTaskPerformed();
        }
    }
    public void addInspecTaskObservers(List<InspectionTaskObserver> observers){
        inspectionTaskOberservers.addAll(observers);
    }
}
