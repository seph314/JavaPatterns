package inspection.view;
import inspection.controller.Controller;
import inspection.integration.DatabaseManager;
import inspection.integration.InspectionProtocol;

import java.util.Scanner;

/**
 * Created by Anders on 2017-04-24.
 */
public class View {

    private DatabaseManager dbMgr = new DatabaseManager();
    private Controller controller = new Controller(dbMgr);

    public View() {
    }

    void showCommandList(){
        System.out.println("C O M M A N D    L I S T\n" +
                "open       = open door and update quenumber\n" +
                "close      = close door\n" +
                "find       = find inspection\n" +
                "start      = start inspection\n" +
                "commands   = shows commands" +
                "quit       = exit program");
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! type open to open garage door\n");
        showCommandList();
        String command = "";
        double cost;
        while (!command.equalsIgnoreCase("quit")) {
            command = in.nextLine();
            switch (command.toLowerCase()) {

                case "open":
                    controller.nextCustomer();
                    System.out.println("Door is open");
                    break;
                case "close":
                    controller.closeDoor();
                    System.out.println("Door is closed");
                    break;
                case "find":
                    System.out.println("Enter regnumber:");
                    String regNo = in.next();
                    if(controller.findInspection(regNo) == 0.0)
                        System.out.println("There is no booked inspection for this car");
                    else{
                        cost = controller.findInspection(regNo);
                        System.out.println("Amount to pay: " + cost);
                    }
                    break;
                case "start":
                    System.out.println("The inspection is about to start, hang on!");
                    controller.startInspection();

                case "commands":
                    showCommandList();
                    break;
                default:
                    break;
            }
        }

        System.out.println("Good bye!");
    }
}
