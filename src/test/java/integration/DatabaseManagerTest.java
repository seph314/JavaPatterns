package test.java.integration;

import main.java.integration.DatabaseManager;
import main.java.integration.InspectionTask;
import main.java.model.Vehicle;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Anders on 2017-04-26.
 */
public class DatabaseManagerTest {
    DatabaseManager databaseManager = new DatabaseManager();

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Starting to test...");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("Finished testing.");
    }

    @org.junit.Test
    public void findInspectionByVehicle() throws Exception {
        List<InspectionTask> list = databaseManager.findInspectionByVehicle(new Vehicle("ABC123"));
        String inspectionName = list.get(2).getName();
        assertEquals("Wrong inspection name", "steering", inspectionName);

    }

}