package inspection.view;
import inspection.controller.Controller;
import inspection.integration.DatabaseManager;

import java.util.Scanner;

/**
 * Created by Anders on 2017-04-24.
 */
public class View {

    private DatabaseManager dbMgr = new DatabaseManager();
    private Controller controller = new Controller(dbMgr);

    public View() {
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! type open to open garage door\n");
        System.out.println("C O M M A N D    L I S T\n" +
                "open = open door and update quenumber\n" +
                "close = close door\n" +
                "new = find inspection\n" +
                "commands = show commands\n");
        String command = "";
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
                case "new":
                    System.out.println("Enter regnumber:");
                    String regNo = in.next();
                    if(controller.findInspection(regNo) == 0.0)
                        System.out.println("There is no booked inspection for this car");
                    else
                        System.out.println("Amount to pay: " + controller.findInspection(regNo));
                    break;
                case "commands":
                    System.out.println("C O M M A N D    L I S T\n" +
                            "open = open door and update quenumber\n" +
                            "close = close door\n" +
                            "find = find inspection\n");
                default:
                    break;
            }
        }

        System.out.println("Good bye!");
    }
}
