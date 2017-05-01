package inspection.controller;

import inspection.integration.DatabaseManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Anders on 2017-05-01.
 */
public class ControllerTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Tests if the inspectioncost equals 500
     * @throws Exception
     */
    @Test
    public void findInspection() throws Exception {
        DatabaseManager dbMgr = new DatabaseManager();
        Controller controller = new Controller(dbMgr);
        String regNo = "ABC123";
        double expResult = 500;
        double result = controller.findInspection(regNo);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void startInspection() throws Exception {
    }

    @Test
    public void payWithCard() throws Exception {
    }

}