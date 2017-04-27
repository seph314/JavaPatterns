package inspection.integration;

import inspection.model.Vehicle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Anders on 2017-04-26.
 * A test class, using JUnit a framework for unit tests
 * Tester ska inte göra egna utskrifter
 * Enda utskrifterna kommer frin JUnit
 * Testmetoder kan ha duplicerad kod eftersom tanken är att de ska vara oberoende
 */
public class DatabaseManagerTest {
    DatabaseManager databaseManager = new DatabaseManager();

    @org.junit.Before
    public void setUp() throws Exception {
//        Kod som kommer att vara gemensam för (alla?)/flera olika tester i setupen skrivs här
    }

    @org.junit.After
    public void tearDown() throws Exception {
//        Kod som kommer att vara gemensam för (alla?)/flera olika tester i setupen tas bort här
    }

    @org.junit.Test
    public void findInspectionByVehicle() throws Exception {
        List<InspectionTask> list = databaseManager.findInspectionByVehicle(new Vehicle("ABC123"));
        String inspectionName = list.get(2).getName();
        assertEquals("Wrong inspection name", "steering", inspectionName);
    }

    @org.junit.Test
    public void testNumberOfFoundInspections() throws Exception{
        Vehicle vehicle = null;
        DatabaseManager instance = new DatabaseManager();
        int expResult = 3;
        int result = instance.findInspectionByVehicle(vehicle).size();
        assertEquals("Wrong number of inspection Items", expResult, result);
    }
}