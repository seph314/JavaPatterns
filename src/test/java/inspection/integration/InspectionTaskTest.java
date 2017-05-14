package inspection.integration;

import inspection.model.InspectionProtocol;
import inspection.model.InspectionTask;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Anders on 2017-05-01.
 */
public class InspectionTaskTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * tests if fail (false) is the default boolean condition for an inspection task
     * @throws Exception
     */
    @Test
    public void isPassOrFail() throws Exception {
        InspectionProtocol inspectionProtocol = new InspectionProtocol();
        List <InspectionTask> allInspectionTasks = inspectionProtocol.createDummyInspections();
        for (InspectionTask task : allInspectionTasks){
            assertFalse(task.isPassOrFail());
        }
    }

    /**
     * test if inspection task is set to pass (true) when set by inspector
     * @throws Exception
     */
    @Test
    public void setPassOrFail() throws Exception {
        InspectionProtocol inspectionProtocol = new InspectionProtocol();
        List <InspectionTask> allInspectionTasks = inspectionProtocol.createDummyInspections();
        for (InspectionTask task : allInspectionTasks){
            task.setPassOrFail(true);
        }
        for (InspectionTask task : allInspectionTasks){
            assertTrue(task.isPassOrFail());
        }
    }
}