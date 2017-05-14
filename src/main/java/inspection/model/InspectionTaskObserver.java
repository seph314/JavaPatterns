package inspection.model;

/**
 * A listener interface for receiving notifications about finished inspection tasks
 * Notifies regardless of outcome (pass or fail).
 */
public interface InspectionTaskObserver {

    /**
     * Invoked when a task has been inspected
     * Triggered in method setPassOrFail in class InspectionTask
     */
    void inspectionTaskPerformed();
}
