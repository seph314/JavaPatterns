package main.java.integration;
import main.java.model.Vehicle;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by Anders on 2017-04-26.
 * A test class, using JUnit a framework for unit tests
 */
public class DatabaseManagerTest {
    DatabaseManager databaseManager = new DatabaseManager();

    @org.junit.Before
    public void setUp() throws Exception {
//        Spårutskrift
//        System.out.println("Starting to test...");
//        Kod som kommer att vara gemensam för flera olika tester i setupen skrivs här
    }

    @org.junit.After
    public void tearDown() throws Exception {
//        Spårutskrift
//        System.out.println("Finished testing.");
    }

    @org.junit.Test
    public void findInspectionByVehicle() throws Exception {
        List<InspectionTask> list = databaseManager.findInspectionByVehicle(new Vehicle("ABC123"));
        String inspectionName = list.get(2).getName();
        assertEquals("Wrong inspection name", "steering", inspectionName);
    }
}