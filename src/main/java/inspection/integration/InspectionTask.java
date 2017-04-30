package inspection.integration;

/**
 * Created by Anders on 2017-04-26.
 *
 */
public class InspectionTask {

    private String name;
    private boolean passOrFail = false;

    /**
     * Creates new instance representing the specified control.
     * @param name The name of this control.
     *
     */
    InspectionTask(String name, boolean passOrFail) {
        this.name = name;
        this.passOrFail = passOrFail;
    }
    public String getName(){
        return this.name;
    }

    public boolean isPassOrFail() {
        return passOrFail;
    }

    public void setPassOrFail(boolean passOrFail) {
        this.passOrFail = passOrFail;
    }
}
